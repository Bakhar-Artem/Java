package by.bakhar.project.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandProvider {
    private static final Logger logger = LogManager.getLogger();
    private static CommandProvider instance;

    private CommandProvider() {
    }

    public static CommandProvider getInstance() {
        if (instance == null) {
            instance = new CommandProvider();
        }
        return instance;
    }

    public Command defineCommand(String commandName) {
        if (commandName == null || commandName.isBlank()) {
            //log
            // what to do?
        }
        Command command = null;
        try {
            command = CommandType.valueOf(commandName.toUpperCase()).getCommand();
        } catch (IllegalArgumentException exception) {
            //log
            //what to do?
        }
        return command;
    }
}
