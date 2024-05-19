package it.uniba.app.Thompson.game.util;
import it.uniba.app.Thompson.game.control.FormatterControl;

/**
 * {@literal << Util >>}
 * Class for error messages.
 */
public final class ErrorMessages {

    /**
     * Attributes of the class ErrorMessages
     */
    private static final FormatterControl formatter = new FormatterControl();
  
    /**
     * Constants of the class ErrorMessages.
     */
    public static final String MATCH_NOT_NULL = formatter.formatText("C'è già una partita in corso.", Color.ORANGE);
    public static final String INVALID_PLAYER = formatter.formatText("Il giocatore inserito non è valido," +
            " comando annullato.", Color.ORANGE);
    public static final String INVALID_CHOICE = formatter.formatText("Scelta non valida, comando annullato", Color.ORANGE);
    public static final String SUGGEST_MATCH_INIT = formatter.formatText("Non c'è nessuna partita in corso," +
            " utilizza '/gioca' per iniziarne una.", Color.ORANGE);
    public static final String COMMAND_NOT_FOUND = formatter.formatText("(•ᴖ•｡) Comando non valido, con il comando '/help' puoi " +
            "trovare i comandi disponibili ", Color.RED);
    public static final String ARGUMENT_NOT_FOUND = formatter.formatText("(•ᴖ•｡) Parametro non valido", Color.RED);
    public static final String GENERIC_ERROR = formatter.formatText("( · ❛ ֊ ❛) E' avvenuto un errore durante l'esecuzione del comdando", Color.RED);

    /**
     * Constructor for the class ErrorMessages.
     */
    private ErrorMessages() { }
}
