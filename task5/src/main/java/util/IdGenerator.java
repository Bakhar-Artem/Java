package util;

public class IdGenerator {
    private static long id = 0;

    private IdGenerator(){}

    public static long createId() {
        return id++;
    }
}
