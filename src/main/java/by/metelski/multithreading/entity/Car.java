package by.metelski.multithreading.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.metelski.multithreading.exception.FerryException;
import by.metelski.multithreading.util.IdGenerator;

public class Car extends Thread {
	public static final Logger logger = LogManager.getLogger();
	private long id;
	private int size;
	private int weight;
	private CarType type;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + size;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id != other.id)
			return false;
		if (size != other.size)
			return false;
		if (type != other.type)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", size=");
		builder.append(size);
		builder.append(", weight=");
		builder.append(weight);
		builder.append("]");
		return builder.toString();
	}
}
