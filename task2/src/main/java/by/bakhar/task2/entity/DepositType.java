package by.bakhar.task2.entity;

public enum DepositType {
    ONDEMAND,
    URGENT,
    CALCULATED,
    CUMULATIVE,
    SAVING;


    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
