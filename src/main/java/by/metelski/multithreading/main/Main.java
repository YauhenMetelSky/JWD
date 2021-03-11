package by.metelski.multithreading.main;

import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.metelski.multithreading.entity.Car;
import by.metelski.multithreading.entity.Car.CarType;
import by.metelski.multithreading.exception.FerryException;
import by.metelski.multithreading.factory.CarFactory;
import by.metelski.multithreading.parser.impl.CarDataParser;
import by.metelski.multithreading.reader.DataFromFileReaderInterface;
import by.metelski.multithreading.reader.impl.DataFromFileReader;

public class Main {
	public static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		String filePath = "data/cars.txt";
		DataFromFileReaderInterface reader = new DataFromFileReader();
		CarDataParser parser = new CarDataParser();
		CarFactory factory = CarFactory.getInstance();
		List<String> carsData;
		List<Integer> carsSpecification;
		CarType[] types = CarType.values();
		try {
			carsData = reader.readStringsFromFile(filePath);
			for (String element : carsData) {
				carsSpecification = parser.parseArrayFromString(element);	
					Car car = factory.createCar(carsSpecification.get(0), carsSpecification.get(1), types[carsSpecification.get(2)]);
					car.start();		
			}
		} catch (FerryException e) {
			logger.log(Level.ERROR, "Exception in Main " + e.getMessage());
		}
	}
}
