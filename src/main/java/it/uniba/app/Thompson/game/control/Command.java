package it.uniba.app.Thompson.game.control;

import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * << Control >>
 * Controls for command constants.
 */
public abstract class Command {
    private String command;

    /**
     * Method that returns command.
     * @return
     */
    String getCommand() {
        return command;
    }

    /**
     * Method that executes some instructions and return a CommandStatus.
     * @return
     */
    CommandStatus executeCommand() {
        return CommandStatus.SUCCESSFUL;
    }
}
