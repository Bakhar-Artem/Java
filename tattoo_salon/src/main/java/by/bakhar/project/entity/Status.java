package by.bakhar.project.entity;

public enum Status {
    ACTIVE, BANNED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
