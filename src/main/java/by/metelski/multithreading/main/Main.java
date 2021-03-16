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
					int size = carsSpecification.get(0);
					int weight = carsSpecification.get(1);
					CarType type = types[carsSpecification.get(2)];
					Car car = factory.createCar(size, weight, type);
					car.start();		
			}
		} catch (FerryException e) {
			logger.log(Level.ERROR, "Exception in Main " + e.getMessage());
		}
	}
}
