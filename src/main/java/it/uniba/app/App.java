package it.uniba.app;
import it.uniba.app.Thompson.game.control.MainControl;

/**
 * Main class of the application.
 */
public final class App {
    /**
     * Get a greeting sentence.
     *
     * @return the "Hello World!" string.
     */
    public String getGreeting() {
        return "Hello World!!!";
    }
    /**
     * Entrypoint of the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        MainControl.startMainControl();
    }
}
