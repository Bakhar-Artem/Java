package by.bakhar.project.dao;

import by.bakhar.project.builder.UserBuilder;
import by.bakhar.project.entity.Status;
import by.bakhar.project.entity.User;
import by.bakhar.project.entity.UserRole;
import by.bakhar.project.exception.DaoException;
import by.bakhar.project.pool.CustomPool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User> {
    private final static String SQL_FIND_ALL_USERS = "select * from users";
    private final static String SQL_ADD_USER_PREPARED = "insert into users(user_name,user_lastname,user_login,user_password,user_role,user_status) values(?,?,?,?,?,?);";

    public UserDao() {
        connection = CustomPool.INSTANCE.getConnection();
    }

    @Override
    public List<User> findAll() throws DaoException {
        Statement statement = null;
        List<User> users = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_USERS);
            users = new ArrayList<>();
            UserBuilder userBuilder = new UserBuilder();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String login = resultSet.getString(4);
                String password = resultSet.getString(5);
                int role = resultSet.getInt(6);
                UserRole userRole;
                switch (role) {
                    case (1) -> userRole = UserRole.ADMIN;
                    case (2) -> userRole = UserRole.GUEST;
                    case (3) -> userRole = UserRole.CLIENT;
                    default -> userRole = UserRole.MASTER;
                }
                int status = resultSet.getInt(7);
                Status userStatus;
                switch (role) {
                    case (1) -> userStatus = Status.ACTIVE;
                    default -> userStatus = Status.BANNED;
                }
                User user = userBuilder.buildUser(id, name, lastname, login, password, userRole, userStatus);
                users.add(user);
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
            //log
        } finally {
            try {
                connection.close();
                close(statement);
            } catch (SQLException exception) {
                throw new DaoException(exception);
                //log
            }

        }
        return users;
    }

    @Override
    public boolean addEntity(User user) throws DaoException{
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(SQL_ADD_USER_PREPARED);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setInt(5, 1);
            statement.setInt(6, 1);
            statement.execute();
        } catch (SQLException exception) {
            throw new DaoException(exception);
            //log

        } finally {
            try {
                connection.close();
                close(statement);
            } catch (SQLException exception) {
                throw new DaoException(exception);
                //log
            }
        }
        return true;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public boolean removeById(long id) {
        return false;
    }

    @Override
    public boolean remove(User entity) {
        return false;
    }
}
