package by.bakhar.project.entity;


public enum UserRole {
    ADMIN, GUEST, CLIENT, MASTER;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
