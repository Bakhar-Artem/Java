package by.bakhar.project.controller.command.impl;

import by.bakhar.project.controller.command.Command;
import by.bakhar.project.exception.ServiceException;
import by.bakhar.project.service.UserService;
import by.bakhar.project.service.impl.UserServiceImpl;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class RegisterCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final String USER_NAME="name";
    private static final String USER_LASTNAME="lastname";
    private static final String USER_LOGIN="login";
    private static final String USER_PASSWORD="password";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter(USER_NAME);
        String lastname = req.getParameter(USER_LASTNAME);
        String login = req.getParameter(USER_LOGIN);
        String password = req.getParameter(USER_PASSWORD);
        UserService userService = new UserServiceImpl();
        try {
            userService.registerClient(name, lastname, login, password);
        } catch (ServiceException exception) {
            //log
            req.getRequestDispatcher("/pages/error.jsp").forward(req,resp);
        }
        req.getRequestDispatcher("/pages/success.jsp").forward(req,resp);
    }
}
