package by.metelski.multithreading.entity;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.metelski.multithreading.exception.FerryException;
import by.metelski.multithreading.util.IdGenerator;

public class Car extends Thread {
	public static final Logger logger = LogManager.getLogger();
	private long id;
	private CarType type;
	private int size;
	private int weight;

	public enum CarType {
		TRUCK, CAR
	}

	public Car() {
		id = IdGenerator.getId();
		size = 2;
		weight = 15;
		type = CarType.TRUCK;
	}

	public Car(int size, int weight, CarType type) {
		id = IdGenerator.getId();
		this.size = size;
		this.weight = weight;
		this.type = type;
	}

	@Override
	public void run() {
		Ferry ferry = Ferry.getInstance();
		try {
			ferry.loading(this);
		} catch (FerryException e) {
			logger.log(Level.ERROR, "Catched FarryException " + e.getMessage());
		}
		ferry.discharging(this);
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public long getId() {
		return id;
	}
}
