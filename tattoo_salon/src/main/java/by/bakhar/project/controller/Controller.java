package by.bakhar.project.controller;

import by.bakhar.project.controller.command.Command;
import by.bakhar.project.controller.command.CommandProvider;
import by.bakhar.project.pool.CustomPool;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "controllerServlet", value = "/controller")
public class Controller extends HttpServlet {
    private static final String COMMAND = "command";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void destroy() {
        CustomPool.INSTANCE.destroyPool();
    }

    public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String commandName = req.getParameter(COMMAND);
        Command command = CommandProvider.getInstance().defineCommand(commandName.toUpperCase(Locale.ROOT));
        //log
        command.execute(req,resp);
    }
}
