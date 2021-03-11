package by.metelski.multithreading.entity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.metelski.multithreading.exception.FerryException;

public class Ferry {
	private static final int LOAD_CAPACITY = 150;
	private static final int SQUARE = 150;
	private static Ferry instance;
	private State state;
	public static final Logger logger = LogManager.getLogger();
	private static Lock locker = new ReentrantLock();
	private final Condition condition = locker.newCondition();
	private int emptyCapacity;
	private int emptySquare;

	public enum State {
		LOADING, SEILING, DISCHARGING
	}

	private Ferry() {
		emptyCapacity = LOAD_CAPACITY;
		emptySquare = SQUARE;
		state = State.LOADING;
	}

	public void setState(State state) {
		this.state = state;
	}

	public static Ferry getInstance() {
		if (instance == null) {
			locker.lock();
			if (instance == null) {
				instance = new Ferry();
			}
			locker.unlock();
		}
		return instance;
	}

	public void transfer() throws FerryException {
		logger.log(Level.INFO, "Ferry is sailing");
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			throw new FerryException("Catched exception ", e);
		}
		state = State.DISCHARGING;
		condition.signalAll();
	}

	public void loading(Car car) throws FerryException {
		boolean flag = true;
		try {
			locker.lock();
			while (flag) {
				if (state != State.LOADING) {
					condition.await();
				} else if (checkFreeSpace(car)) {
					logger.log(Level.INFO, "empty capacity:" + emptyCapacity + "emptySquare:" + emptySquare);
					emptyCapacity -= car.getWeight();
					emptySquare -= car.getSize();
					flag = false;
					logger.log(Level.INFO, car.getType() + ":" + car.getId() + " loaded");
					condition.await(10000, TimeUnit.MILLISECONDS);
					if (state != State.DISCHARGING) {
						transfer();
					}
				} else {
					state = State.SEILING;
					transfer();
				}
			}
		} catch (InterruptedException e) {
		} finally {
			locker.unlock();
		}
	}

	public void discharging(Car car) {
		boolean flag = true;
		try {
			locker.lock();
			while (flag) {
				if (state != State.DISCHARGING) {
					condition.await();
				} else {
					emptyCapacity += car.getWeight();
					emptySquare += car.getSize();
					flag = false;
					logger.log(Level.INFO, car.getType() + ":" + car.getId() + " discharging");
				}
			}
			if (emptyCapacity == LOAD_CAPACITY && emptySquare == SQUARE) {
				logger.log(Level.INFO, "Ready to loading");
				state = State.LOADING;
				condition.signalAll();
			}
		} catch (InterruptedException e) {
		} finally {
			locker.unlock();
		}
	}

	private boolean checkFreeSpace(Car car) {
		boolean result = false;
		if (emptyCapacity > car.getWeight() && emptySquare > car.getSize()) {
			result = true;
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ferry [state=");
		builder.append(state);
		builder.append(", Load capacity=");
		builder.append(LOAD_CAPACITY);
		builder.append(", Square=");
		builder.append(SQUARE);
		builder.append(", emptyCapacity=");
		builder.append(emptyCapacity);
		builder.append(", emptySquare=");
		builder.append(emptySquare);
		builder.append("]");
		return builder.toString();
	}	
}
