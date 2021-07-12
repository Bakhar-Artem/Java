package by.bakhar.project.servlet;

import by.bakhar.project.builder.UserBuilder;
import by.bakhar.project.dao.UserDao;
import by.bakhar.project.entity.Status;
import by.bakhar.project.entity.User;
import by.bakhar.project.entity.UserRole;
import by.bakhar.project.exception.DaoException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "regServlet", value = "/reg-servlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserBuilder userBuilder = new UserBuilder();
        User user = userBuilder.buildUser(1, login, login, login, password, UserRole.ADMIN, Status.ACTIVE);
        UserDao userDao = new UserDao();
        try {
            userDao.addEntity(user);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
