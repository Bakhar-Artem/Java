package entity;

import java.util.concurrent.Callable;

public class Ship implements Callable<Ship> {
    private long id;
    private Status status;

    public Ship(long id, Status status) {
        this.id = id;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Ship call() throws Exception {
        return null;
    }
}
