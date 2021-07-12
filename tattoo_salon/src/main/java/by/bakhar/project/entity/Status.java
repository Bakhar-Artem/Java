package by.bakhar.project.entity;

public enum Status {
    ACTIVE(1), BANNED(2);
    private int id;

    Status(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
