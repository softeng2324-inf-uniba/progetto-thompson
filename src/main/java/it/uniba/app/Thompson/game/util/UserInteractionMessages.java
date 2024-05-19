package it.uniba.app.Thompson.game.util;

import it.uniba.app.Thompson.game.control.FormatterControl;

/**
 * << Util >>
 * Class for user interaction messages.
 */
public final class UserInteractionMessages {

    private static final FormatterControl formatterControl = new FormatterControl();

    /**
     * Constants for user interaction messages.
     */
    public static final String QUITTING_PLAYER = "Quale giocatore vuole abbandonare la partita? (N/B)";
    public static final String SURE_TO_QUIT = "Sei sicuro di voler abbandonare la partita? (S/N)";
    public static final String ABORTED_QUIT = "La partita continuerà normalmente.";
    public static final String GOODBYE = formatterControl.formatText("Arrivederci! Grazie per aver giocato!", Color.BLUE, Style.ITALIC);

    /**
     * Constructor for UserInteractionMessages.
     */
    private UserInteractionMessages() { }
}
