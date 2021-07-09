package by.bakhar.project.entity;

public class User extends Entity {
    private long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
    private Status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return userRole;
    }

    public void setRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id && name.equals(user.name) && email.equals(user.email) && password.equals(user.password) && userRole == user.userRole && status == user.status;
    }

    @Override
    public int hashCode() {
        int hash = (13 * Long.hashCode(id)) % 101;
        hash += (15 * name.hashCode()) % 101;
        hash += (17 * email.hashCode()) % 101;
        hash += (17 * password.hashCode()) % 101;
        hash += (19 * userRole.hashCode()) % 101;
        hash += (21 * status.hashCode()) % 101;
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("id: ").append(id);
        stringBuilder.append(", name: ").append(name);
        stringBuilder.append(", email: ").append(email);
        stringBuilder.append(", role: ").append(userRole);
        stringBuilder.append(", status: ").append(status);
        return stringBuilder.toString();
    }
}
