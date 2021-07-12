package by.bakhar.project.builder;

import by.bakhar.project.entity.Status;
import by.bakhar.project.entity.User;
import by.bakhar.project.entity.UserRole;
import by.bakhar.project.util.PasswordHash;

public class UserBuilder {
    public User buildUser(long id, String name, String lastname,String login, String password, UserRole role, Status status) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setLastname(lastname);
        user.setLogin(login);
        PasswordHash passwordHash = new PasswordHash();
        String encryptPassword = passwordHash.generatePassword(password);
        user.setPassword(encryptPassword);
        user.setRole(role);
        user.setStatus(status);
        return user;
    }
}
