package it.uniba.app.Thompson.game.util;

import it.uniba.app.Thompson.game.control.FormatterControl;

/**
 * {@literal << Util >>}
 * Class for user interaction messages.
 */
public final class UserInteractionMessages {

    private static final FormatterControl FORMATTER_CONTROL = new FormatterControl();

    /**
     * Constants of the class UserInteractionMessages.
     */
    public static final String QUITTING_PLAYER = FORMATTER_CONTROL.formatText("Quale giocatore "
            + "vuole abbandonare la partita? (N/B)", Style.BOLD);
    public static final String SURE_TO_QUIT = FORMATTER_CONTROL.formatText("Sei sicuro "
            + "di voler abbandonare la partita? (S/N)", Style.BOLD);
    public static final String ABORTED_QUIT = FORMATTER_CONTROL.formatText("La partita continuerà normalmente.",
            Color.BLUE, Style.BOLD);
    public static final String GOODBYE = FORMATTER_CONTROL.formatText("Arrivederci! Grazie per aver giocato!",
            Color.BLUE, Style.ITALIC);

    /**
     * Constructor for the class UserInteractionMessages.
     */
    private UserInteractionMessages() { }
}
