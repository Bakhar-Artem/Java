package by.bakhar.project.dao;

import by.bakhar.project.builder.UserBuilder;
import by.bakhar.project.entity.Status;
import by.bakhar.project.entity.User;
import by.bakhar.project.entity.UserRole;
import by.bakhar.project.exception.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User> {
    private final static String SQL_FIND_ALL_USERS = "select * from users";

    @Override
    public List<User> findAll() throws DaoException {
        Statement statement=null;
        List<User> users=null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_USERS);
            users = new ArrayList<>();
            UserBuilder userBuilder=new UserBuilder();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String password = resultSet.getString(4);
                UserRole role = resultSet.getObject(5, UserRole.class);
                Status status = resultSet.getObject(6, Status.class);
                User user= userBuilder.buildUser(id,name,email,password,role,status);
                users.add(user);
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
            //log
        }finally {
            close(statement);
        }
        return users;
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
