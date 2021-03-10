package by.metelski.multithreading.util;

public class IdGenerator {
	private static long id = 1L;

	public static long getId() {
		return id++;
	}
}
