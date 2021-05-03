package by.bakhar.task3.util;

public class ConeIdGenerator {
    private static long id = 0;

    private ConeIdGenerator() {
    }

    public static long generateId() {
        return ++id;
    }
}
