package by.bakhar.project.controller.command;

import by.bakhar.project.controller.command.impl.LoginCommand;
import by.bakhar.project.controller.command.impl.RegisterCommand;

public enum CommandType {
    REGISTRATION(new RegisterCommand()),
    LOGIN(new LoginCommand());
    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
