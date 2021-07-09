package entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.IdGenerator;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Pier {
    private static final Logger logger = LogManager.getLogger();
    private static final int MIN_WAIT_TIME = 5;
    private static final int MAX_WAIT_TIME = 50;
    private long id;

    public Pier() {
        this.id = IdGenerator.createId();
    }

    public long getId() {
        return id;
    }

    public void processShip(Ship ship) {
        int waitTime = new Random().nextInt(MAX_WAIT_TIME - MIN_WAIT_TIME) + MIN_WAIT_TIME;
        try {
            TimeUnit.MILLISECONDS.sleep(waitTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pier)) {
            return false;
        }
        Pier pier = (Pier) o;
        return id == pier.id;
    }

    @Override
    public int hashCode() {
        return (13 * Long.hashCode(id)) % 101;
    }
}
