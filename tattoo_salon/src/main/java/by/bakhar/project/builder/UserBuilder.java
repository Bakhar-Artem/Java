package by.bakhar.project.builder;

import by.bakhar.project.entity.Status;
import by.bakhar.project.entity.User;
import by.bakhar.project.entity.UserRole;

public class UserBuilder {
    public User buildUser(long id, String name, String email, String password, UserRole role, Status status) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setStatus(status);
        return user;
    }
}
