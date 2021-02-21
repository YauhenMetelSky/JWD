package by.metelski.quadrangle.generator;

public class IdGenerator {
    private static long id = 1L;

    public static long getId(){
        return id++;
    }

}
