package it.uniba.app.Thompson.game.util;

import it.uniba.app.Thompson.game.control.FormatterControl;

/**
 * {@literal << Util >>}
 * Class to manage user interaction messages.
 */
public final class UserInteractionMessages {

    /**
     * Attributes of the class UserInteractionMessages.
     */
    private static final FormatterControl FORMATTER_CONTROL = new FormatterControl();

    /**
     * Constants of the class UserInteractionMessages.
     */
    public static final String QUITTING_PLAYER = FORMATTER_CONTROL.formatText("Quale giocatore "
            + "vuole abbandonare la partita? (N/B)", Style.BOLD);

    /**
     * Constant containing the SURE_TO_QUIT message.
     */
    public static final String SURE_TO_QUIT = FORMATTER_CONTROL.formatText("Sei sicuro "
            + "di voler abbandonare la partita? (S/N)", Style.BOLD);

    /**
     * Constant containing the ABORTED_QUIT message.
     */
    public static final String ABORTED_QUIT = FORMATTER_CONTROL.formatText("La partita continuera' normalmente.",
            Color.BLUE, Style.BOLD);

    /**
     * Constant containing the GOODBYE message.
     */
    public static final String GOODBYE = FORMATTER_CONTROL.formatText("Arrivederci! Grazie per aver giocato!",
            Color.BLUE, Style.ITALIC);

    /**
     * Constant containing the SKIP_TURN message.
     */
    public static final String SKIP_TURN = FORMATTER_CONTROL.formatText(
            "Nessuna pedina che possiedi può effettuare una mossa valida, il turno passa al .",
            Color.BLUE, Style.ITALIC);

    /**
     * Constructor for the class UserInteractionMessages.
     */
    private UserInteractionMessages() { }
}
