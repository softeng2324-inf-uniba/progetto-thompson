package it.uniba.app;
import it.uniba.app.Thompson.game.control.MainControl;

/**
 * Main class of the application.
 */
public final class App {

    /**
     * Private constructor to hide the implicit public one.
     */
    private App() { }

    /**
     * Entrypoint of the application.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        MainControl.startMainControl(args);
    }
}
