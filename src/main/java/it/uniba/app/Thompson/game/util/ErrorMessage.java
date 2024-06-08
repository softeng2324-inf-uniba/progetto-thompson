package it.uniba.app.Thompson.game.util;
import it.uniba.app.Thompson.game.control.FormatterC;

/**
 * {@literal << Util >>}
 * Class to manage error messages.
 */
public final class ErrorMessage {

    /**
     * Attributes of the class ErrorMessage.
     */
    private static final FormatterC FORMATTER_CONTROL = new FormatterC();

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
                    + "Parametro non valido", Color.RED);

    /**
     * Constant containing the GENERIC_ERROR message.
     */
    public static final String GENERIC_ERROR = FORMATTER_CONTROL.formatText("( \u00B7 \u275B \u058A \u275B) "
            + "E' avvenuto un errore durante l'esecuzione del comdando", Color.RED);

    /**
     * Constant containing the INVALID_ARGUMENTS message.
     */
    public static final String INVALID_ARGUMENTS = FORMATTER_CONTROL.formatText(
            "Il numero di argomenti non e' valido", Color.RED);

    /**
     * Constant containing the INVALID_MOVE message.
     */
    public static final String INVALID_MOVE = FORMATTER_CONTROL.formatText("La casella su cui vuoi effettuare la "
                                                                + "mossa e' irraggiungibile ", Color.ORANGE);

    /**
     * Constant containing the INVALID_START message.
     */
    public static final String INVALID_START = FORMATTER_CONTROL.formatText(
              "Non c'e' nessuna pedina nella casella di partenza", Color.ORANGE);

    /**
     * Constant containing the WRONG_PLAYER message.
     */
    public static final String WRONG_PLAYER = "Non e' il tuo turno, ora tocca al ";

    /**
     * Constant containing the TOO_MANY_INVALID_TILES message.
     */
    public static final String TOO_MANY_INVALID_TILES = FORMATTER_CONTROL.formatText(
            "Hai bloccato troppe caselle, ricorda che puoi bloccarne al massimo 9", Color.RED);

    /**
     * Constant containing the INVALID_TILE_TO_BLOCK message.
     */
    public static final String INVALID_TILE_TO_BLOCK = FORMATTER_CONTROL.formatText(
            "Non puoi bloccare completamente i movimenti di una singola pedina", Color.RED);

    /**
     * Constant containing the IMPOSSIBLE_MOVE message.
     */
    public static final String IMPOSSIBLE_MOVE = FORMATTER_CONTROL.formatText(
            "La casella su cui vuoi spostare la pedina e' bloccata, riprova", Color.ORANGE);

    /**
     * Constant containing the IMPOSSIBLE_BLOCK message.
     */
    public static final String IMPOSSIBLE_BLOCK = FORMATTER_CONTROL.formatText(
            "Impossibile bloccare la casella selezionata, riprova", Color.RED);

    /**
     * Constant containing the TILE_ALREADY_BLOCKED message.
     */
    public static final String TILE_ALREADY_BLOCKED = FORMATTER_CONTROL.formatText(
            "Non puoi bloccare una casella gia' bloccata", Color.RED);

    /**
     * Constant containing the COORDINATE_NOT_VALID message.
     */
    public static final String COORDINATE_NOT_VALID = FORMATTER_CONTROL.formatText(
            "Coordinate non valide, riprova", Color.RED);

    /**
     * Constant containing the TILE_OCCUPIED message.
     */
    public static final String TILE_OCCUPIED = FORMATTER_CONTROL.formatText("Non puoi bloccare una casella con una pedina sopra", Color.RED);

    /**
     * Constructor for the class ErrorMessage.
     */
    private ErrorMessage() { }
}
