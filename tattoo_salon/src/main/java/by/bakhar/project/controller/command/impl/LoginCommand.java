package by.bakhar.project.controller.command.impl;

import by.bakhar.project.controller.command.Command;
import by.bakhar.project.exception.ServiceException;
import by.bakhar.project.service.UserService;
import by.bakhar.project.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter(USER_LOGIN);
        String password = req.getParameter(USER_PASSWORD);
        UserService userService = new UserServiceImpl();
        boolean isAuthorized = false;
        try {
            isAuthorized = userService.authorize(login, password);
        } catch (ServiceException e) {
            //log
        }
        if (isAuthorized) {
            req.getRequestDispatcher("/pages/success.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/error.jsp").forward(req, resp);
        }

    }
}
