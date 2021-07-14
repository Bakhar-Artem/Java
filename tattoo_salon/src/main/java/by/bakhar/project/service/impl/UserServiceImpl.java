package by.bakhar.project.service.impl;

import by.bakhar.project.dao.UserDao;
import by.bakhar.project.entity.User;
import by.bakhar.project.exception.DaoException;
import by.bakhar.project.exception.ServiceException;
import by.bakhar.project.service.UserService;
import by.bakhar.project.util.PasswordHash;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    public void registerClient(String name, String lastname, String login, String password) throws ServiceException {
        //to do validation
        User.UserBuilder userBuilder = User.createBuilder();
        User user = userBuilder.buildUserIgnoreId(name, lastname, login, User.UserRole.CLIENT, User.UserStatus.ACTIVE);
        PasswordHash passwordHash = new PasswordHash();
        String hashPassword = passwordHash.generatePassword(password);
        UserDao userDao = new UserDao();
        try {
            userDao.add(user, hashPassword);
        } catch (DaoException exception) {
            //log
            throw new ServiceException("", exception);
        }
        //success log
    }

    @Override
    public boolean authorize(String login, String password) throws ServiceException {
        UserDao userDao = new UserDao();
        boolean checkPassword = false;
        try {
            Optional<String> hashedPassword = userDao.findPasswordByLogin(login);
            if (hashedPassword.isPresent()) {
                PasswordHash passwordHash = new PasswordHash();
                checkPassword = passwordHash.checkPassword(password, hashedPassword.get());
            }
        } catch (DaoException exception) {
            //log
            throw new ServiceException("", exception);
        }
        return checkPassword;
    }
}
