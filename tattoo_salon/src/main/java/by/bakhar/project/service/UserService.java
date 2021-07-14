package by.bakhar.project.service;

import by.bakhar.project.exception.DaoException;
import by.bakhar.project.exception.ServiceException;

public interface UserService {
    void registerClient(String name, String lastname, String login, String password) throws ServiceException;

    boolean authorize(String login, String password) throws ServiceException;
}
