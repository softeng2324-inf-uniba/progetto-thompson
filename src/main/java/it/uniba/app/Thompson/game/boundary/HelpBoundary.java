package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.BoardCommandControl;
import it.uniba.app.Thompson.game.control.ExitCommandControl;
import it.uniba.app.Thompson.game.control.HelpCommandControl;
import it.uniba.app.Thompson.game.control.PlayCommandControl;

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
            + " - " + BoardCommandControl.getInstance().getCommand() + "\t: "
                    + BoardCommandControl.getInstance().getDescription() + "\n"
        );

    }

    private HelpBoundary() { }
}
