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
    public static final String QUITTING_PLAYER = formatterControl.formatText("Quale giocatore " +
            "vuole abbandonare la partita? (N/B)", Style.BOLD);
    public static final String SURE_TO_QUIT = formatterControl.formatText("Sei sicuro " +
            "di voler abbandonare la partita? (S/N)", Style.BOLD);
    public static final String ABORTED_QUIT = formatterControl.formatText( "La partita continuerà normalmente.",
            Color.BLUE, Style.BOLD );
    public static final String GOODBYE = formatterControl.formatText("Arrivederci! Grazie per aver giocato!", Color.BLUE, Style.ITALIC);

    /**
     * Constructor for UserInteractionMessages.
     */
    private UserInteractionMessages() { }
}
