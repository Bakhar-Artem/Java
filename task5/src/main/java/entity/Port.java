package entity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private static Port instance;
    private static final AtomicBoolean isCreated = new AtomicBoolean(false);
    private final ReentrantLock locker = new ReentrantLock();
    private final Deque<Pier> pierDeque = new ArrayDeque<>();
    private final Deque<Condition> waitingDeque = new ArrayDeque<>();

    private Port() {
    }

    public static Port getInstance() {
        if (instance == null) {
            instance = new Port();
        }
        return instance;
    }
}
