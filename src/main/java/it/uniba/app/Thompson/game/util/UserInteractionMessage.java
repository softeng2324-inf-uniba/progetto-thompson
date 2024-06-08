package it.uniba.app.Thompson.game.util;

import it.uniba.app.Thompson.game.control.FormatterC;

/**
 * {@literal << Util >>}
 * Class to manage user interaction messages.
 */
public final class UserInteractionMessage {

    /**
     * Attributes of the class UserInteractionMessage.
     */
    private static final FormatterC FORMATTER_CONTROL = new FormatterC();

    /**
     * Constants of the class UserInteractionMessage.
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
     * Constructor for the class UserInteractionMessage.
     */
    private UserInteractionMessage() { }
}
