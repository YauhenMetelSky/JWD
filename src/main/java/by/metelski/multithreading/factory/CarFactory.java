package by.metelski.multithreading.factory;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.metelski.multithreading.entity.Car;
import by.metelski.multithreading.entity.Car.CarType;

public class CarFactory {
	 public final static Logger logger = LogManager.getLogger();
	 private static CarFactory instance =  new CarFactory();
	 
	 private CarFactory() {	 
	 }
	 public static CarFactory getInstance() {
		 return instance;
	 }
	 public Car createCar(int size, int weight, CarType type) {
		 Car car;
		 if(size<=0||weight<=0) {
			 car = new Car();
		 } else {
			 car = new Car(size,weight,type);
		 }
		 logger.log(Level.INFO, "New car " + car.toString() +" created");
		 return car;
	 }
}
