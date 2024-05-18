package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.BoardCommandControl;
import it.uniba.app.Thompson.game.control.ExitCommandControl;
import it.uniba.app.Thompson.game.control.HelpCommandControl;
import it.uniba.app.Thompson.game.control.PlayCommandControl;
import it.uniba.app.Thompson.game.control.VoidCommandControl;

/**
 * << Boundary >>
 * Class used to print available commands.
 */
public final class HelpBoundary {

    /**
     * Print available commands.
     */
    public static void printCommands() {
        System.out.println(
            "COMANDI DISPONIBILI \n"
            + " - " + HelpCommandControl.getInstance().getCommand() + " : "
                    + HelpCommandControl.getInstance().getDescription() + "\n"
            + " - " + ExitCommandControl.getInstance().getCommand() + " : "
                    + ExitCommandControl.getInstance().getDescription() + "\n"
            + " - " + PlayCommandControl.getInstance().getCommand() + " : "
                    + PlayCommandControl.getInstance().getDescription() + "\n"
            + " - " + VoidCommandControl.getInstance().getCommand() + " : "
                    + VoidCommandControl.getInstance().getDescription() + "\n"
            + " - " + BoardCommandControl.getInstance().getCommand() + " : "
                    + BoardCommandControl.getInstance().getDescription() + "\n"
        );

    }

    private HelpBoundary() { }
}
