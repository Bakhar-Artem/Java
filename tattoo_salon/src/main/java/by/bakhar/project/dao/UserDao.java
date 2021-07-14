package by.bakhar.project.dao;

import by.bakhar.project.entity.User;
import by.bakhar.project.exception.DaoException;
import by.bakhar.project.pool.CustomPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao extends AbstractDao<User> {
    private static final Logger logger = LogManager.getLogger();
    private static final String SQL_FIND_ALL_USERS = "select user_id,user_name,user_lastname,user_login,user_role,user_status from users";
    private static final String SQL_ADD_USER_PREPARED = "insert into users(user_name,user_lastname,user_login,user_password,user_role,user_status) values(?,?,?,?,?,?);";
    private static final String SQL_FIND_USER_BY_ID = "select user_name,user_lastname,user_login,user_role,user_status from users where user_id ?";
    private static final String SQL_FIND_PASSWORD_BY_LOGIN = "select user_password from users where user_login= ?";

    public UserDao() {
        connection = CustomPool.INSTANCE.getConnection();
    }

    public boolean add(User user, String hashedPassword) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_ADD_USER_PREPARED);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getLogin());
            statement.setString(4, hashedPassword);
            statement.setInt(5, 3);
            statement.setInt(6, 1);
            statement.execute();
        } catch (SQLException exception) {
            throw new DaoException("", exception);
            //log

        } finally {
            try {
                connection.close();
                close(statement);
            } catch (SQLException exception) {
                throw new DaoException("", exception);
                //log
            }
        }
        return true;
    }

    public Optional<String> findPasswordByLogin(String login) throws DaoException {
        PreparedStatement statement = null;
        Optional<String> password = Optional.empty();
        try {
            statement = connection.prepareStatement(SQL_FIND_PASSWORD_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                password = Optional.of(resultSet.getString(1));
            }
        } catch (SQLException exception) {
            //log
            throw new DaoException("",exception);
        }finally {
            try {
                close(statement);
                connection.close();
            } catch (SQLException exception) {
                //log
            }
        }
        return password;
    }

    @Override
    public List<User> findAll() throws DaoException {
        Statement statement = null;
        List<User> users = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_USERS);
            users = new ArrayList<>();
            User.UserBuilder userBuilder = User.createBuilder();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String login = resultSet.getString(4);
                int role = resultSet.getInt(5);
                User.UserRole userRole = chooseRole(role);
                int status = resultSet.getInt(6);
                User.UserStatus userStatus;
                if (status == 1) {
                    userStatus = User.UserStatus.ACTIVE;
                } else {
                    userStatus = User.UserStatus.BANNED;
                }
                User user = userBuilder.buildUser(id, name, lastname, login, userRole, userStatus);
                users.add(user);
            }
        } catch (SQLException exception) {
            throw new DaoException("", exception);
            //log
        } finally {
            try {
                connection.close();
                close(statement);
            } catch (SQLException exception) {
                throw new DaoException("", exception);
                //log
            }

        }
        return users;
    }


    @Override
    public Optional<User> findById(long id) throws DaoException {
        PreparedStatement statement = null;
        Optional<User> user = Optional.empty();
        try {
            statement = connection.prepareStatement(SQL_FIND_USER_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User.UserBuilder userBuilder = User.createBuilder();
                String name = resultSet.getString(1);
                String lastname = resultSet.getString(2);
                String login = resultSet.getString(3);
                int role = resultSet.getInt(6);
                User.UserRole userRole = chooseRole(role);
                int status = resultSet.getInt(7);
                User.UserStatus userStatus;
                if (status == 1) {
                    userStatus = User.UserStatus.ACTIVE;
                } else {
                    userStatus = User.UserStatus.BANNED;
                }
                user = Optional.of(userBuilder.buildUser(id, name, lastname, login, userRole, userStatus));
            }
        } catch (SQLException exception) {
            throw new DaoException("", exception);
            //log
        } finally {
            try {
                connection.close();
                close(statement);
            } catch (SQLException exception) {
                //log
            }

        }
        return user;
    }

    @Override
    public boolean removeById(long id) {
        return false;
    }

    @Override
    public boolean remove(User entity) {
        return false;
    }

    private User.UserRole chooseRole(int role) {
        User.UserRole userRole;
        switch (role) {
            case (1) -> userRole = User.UserRole.ADMIN;
            case (2) -> userRole = User.UserRole.GUEST;
            case (3) -> userRole = User.UserRole.CLIENT;
            default -> userRole = User.UserRole.MASTER;
        }
        return userRole;
    }
}
