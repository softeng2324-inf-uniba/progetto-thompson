package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.BoardCommandControl;
import it.uniba.app.Thompson.game.control.ExitCommandControl;
import it.uniba.app.Thompson.game.control.HelpCommandControl;
import it.uniba.app.Thompson.game.control.PlayCommandControl;
import it.uniba.app.Thompson.game.control.QuitCommandControl;
import it.uniba.app.Thompson.game.control.VoidCommandControl;

/**
 * {@literal << Boundary >>}
 * Class to communicate available commands.
 */
public final class HelpBoundary {

    /**
     * Constructor for the class HelpBoundary.
     */
    private HelpBoundary() { }

    /**
     * Method printCommands, prints to stdout the available commands.
     */
    public static void printCommands() {
        System.out.print(
            "COMANDI DISPONIBILI \n"
            + " - " + HelpCommandControl.getInstance().getCommand() + " : "
                    + HelpCommandControl.getInstance().getDescription() + "\n"
            + " - " + PlayCommandControl.getInstance().getCommand() + " : "
                    + PlayCommandControl.getInstance().getDescription() + "\n"
            + " - " + VoidCommandControl.getInstance().getCommand() + " : "
                    + VoidCommandControl.getInstance().getDescription() + "\n"
            + " - " + BoardCommandControl.getInstance().getCommand() + " : "
                    + BoardCommandControl.getInstance().getDescription() + "\n"
            + " - " + QuitCommandControl.getInstance().getCommand() + " : "
                    + QuitCommandControl.getInstance().getDescription() + "\n"
            + " - " + ExitCommandControl.getInstance().getCommand() + " : "
                    + ExitCommandControl.getInstance().getDescription() + "\n"
        );
    }
}
