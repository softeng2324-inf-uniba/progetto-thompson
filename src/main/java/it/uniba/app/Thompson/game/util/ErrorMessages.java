package it.uniba.app.Thompson.game.util;
import it.uniba.app.Thompson.game.control.FormatterControl;

/**
 * {@literal << Util >>}
 * Class to manage error messages.
 */
public final class ErrorMessages {

    /**
     * Attributes of the class ErrorMessages.
     */
    private static final FormatterControl FORMATTER_CONTROL = new FormatterControl();

    /**
     * Constant containing the MATCH_NOT_NULL message.
     */
    public static final String MATCH_NOT_NULL = FORMATTER_CONTROL.formatText("C'e' gia' una partita in corso.",
            Color.ORANGE);

    /**
     * Constant containing the INVALID_PLAYER message.
     */
    public static final String INVALID_PLAYER = FORMATTER_CONTROL.formatText("Il giocatore inserito non e' valido,"
            + " comando annullato.", Color.ORANGE);

    /**
     * Constant containing the INVALID_CHOICE message.
     */
    public static final String INVALID_CHOICE = FORMATTER_CONTROL.formatText("Scelta non valida, comando annullato",
            Color.ORANGE);

    /**
     * Constant containing the SUGGEST_MATCH_INIT message.
     */
    public static final String SUGGEST_MATCH_INIT = FORMATTER_CONTROL.formatText("Non c'e' nessuna partita in corso,"

            + " utilizza '/gioca' per iniziarne una.", Color.ORANGE);

    /**
     * Constant containing the COMMAND_NOT_FOUND message.
     */
    public static final String COMMAND_NOT_FOUND = FORMATTER_CONTROL.formatText("(\u2022\u1D16\u2022\uFF61)"
            + " Comando non valido, con il comando '/help' puoi "
            + "trovare i comandi disponibili ", Color.RED);

    /**
     * Constant containing the ARGUMENT_NOT_FOUND message.
     */
    public static final String ARGUMENT_NOT_FOUND = FORMATTER_CONTROL.formatText("(\u2022\u1D16\u2022\uFF61)"
            + "Parametro non valido",
            Color.RED);

    /**
     * Constant containing the GENERIC_ERROR message.
     */
    public static final String GENERIC_ERROR = FORMATTER_CONTROL.formatText("( \u00B7 \u275B \u058A \u275B) "
            + "E' avvenuto un errore durante l'esecuzione del comdando", Color.RED);

    /**
     * Constructor for the class ErrorMessages.
     */
    private ErrorMessages() { }
}
