package by.bakhar.project.entity;

public class User extends Entity {
    public enum UserRole {
        ADMIN, GUEST, CLIENT, MASTER;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }
    public enum UserStatus{
        ACTIVE,BANNED;
        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    private long id;
    private String name;
    private String lastname;
    private String login;
    private UserRole userRole;
    private UserStatus status;
    public class UserBuilder{
        private UserBuilder(){};
        public User buildUser(long id,String name,String lastname,String login,UserRole userRole,UserStatus userStatus){
            User user=new User();
            user.setId(id);
            user.setName(name);
            user.setLastname(lastname);
            user.setLogin(login);
            user.setUserRole(userRole);
            user.setStatus(userStatus);
            return user;
        }
        public User buildUserIgnoreId(String name,String lastname,String login,UserRole userRole,UserStatus userStatus){
            User user=new User();
            user.setName(name);
            user.setLastname(lastname);
            user.setLogin(login);
            user.setUserRole(userRole);
            user.setStatus(userStatus);
            return user;
        }

    }
    public static UserBuilder createBuilder(){
        return new User().new UserBuilder();
    }
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
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
        return id == user.id && name.equals(user.name) && login.equals(user.login) && userRole == user.userRole && status == user.status;
    }

    @Override
    public int hashCode() {
        int hash = (13 * Long.hashCode(id)) % 101;
        hash += (15 * name.hashCode()) % 101;
        hash += (17 * login.hashCode()) % 101;
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
