package by.bakhar.project.entity;

public enum UserRole {
    ADMIN(1), GUEST(2), CLIENT(3), MASTER(4);
    private int id;

    UserRole(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
