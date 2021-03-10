package by.metelski.multithreading.main;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import by.metelski.multithreading.entity.Car;
import by.metelski.multithreading.entity.Ferry;

public class Main {	
	public static void main(String[] args) {
		for(int i =0; i<11;i++) {
			new Car(new Random().nextInt(5),new Random().nextInt(50),Car.CarType.TRUCK).start();
			new Car(new Random().nextInt(3),new Random().nextInt(15),Car.CarType.CAR).start();
		}		
	}
}
