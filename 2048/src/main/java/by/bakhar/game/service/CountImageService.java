package by.bakhar.game.service;

public class CountImageService {
    public static int countImagePos(int value) {
        int result;
        switch (value) {
            case (0) -> result = 0;
            case (2) -> result = 1;
            case (4) -> result = 2;
            case (8) -> result = 3;
            case (16) -> result = 4;
            case (32) -> result = 5;
            case (64) -> result = 6;
            case (128) -> result = 7;
            case (256) -> result = 8;
            case (512) -> result = 9;
            case (1024) -> result = 10;
            case (2048) -> result = 11;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return result;
    }
}
