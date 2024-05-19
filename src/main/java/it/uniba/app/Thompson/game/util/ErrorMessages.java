package it.uniba.app.Thompson.game.util;

import it.uniba.app.Thompson.game.control.FormatterControl;

/**
 * << Util >>
 * Class for color constants.
 */
public final class ErrorMessages {

    private static final FormatterControl formatter = new FormatterControl();
    /**
     * Constants for error messages.
     */
    public static final String MATCH_NOT_NULL = "C'è già una partita in corso.";
    public static final String MATCH_NULL = "Non c'è nessuna partita in corso";
    public static final String INVALID_PLAYER = "Il giocatore inserito non è valido, comando annullato.";
    public static final String INVALID_CHOICE = "Scelta non valida, comando annullato";
    public static final String SUGGEST_MATCH_INIT = MATCH_NULL
            + ", utilizza '/gioca' per iniziarne una.";
    public static final String COMMAND_NOT_FOUND = formatter.formatText("(•ᴖ•｡) Comando non valido, con il comando '/help' puoi " +
            "trovare i comandi disponibili ", Color.RED);

    /**
     * Constructor for ErrorMessages.
     */
    private ErrorMessages() { }
}
