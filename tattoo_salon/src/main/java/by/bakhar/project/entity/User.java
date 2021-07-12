package by.bakhar.project.entity;

public class User extends Entity {
    private long id;
    private String name;
    private String lastname;
    private String login;
    private String password;
    private UserRole userRole;
    private Status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
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
        return id == user.id && name.equals(user.name) && login.equals(user.login) && password.equals(user.password) && userRole == user.userRole && status == user.status;
    }

    @Override
    public int hashCode() {
        int hash = (13 * Long.hashCode(id)) % 101;
        hash += (15 * name.hashCode()) % 101;
        hash += (17 * login.hashCode()) % 101;
        hash += (17 * password.hashCode()) % 101;
        hash += (19 * userRole.hashCode()) % 101;
        hash += (21 * status.hashCode()) % 101;
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ").append(id);
        stringBuilder.append(", name: ").append(name);
        stringBuilder.append(", lastname: ").append(lastname);
        stringBuilder.append(", login: ").append(login);
        stringBuilder.append(", role: ").append(userRole);
        stringBuilder.append(", status: ").append(status);
        return stringBuilder.toString();
    }
}
