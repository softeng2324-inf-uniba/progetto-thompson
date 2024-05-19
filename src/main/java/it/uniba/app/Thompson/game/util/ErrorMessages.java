package it.uniba.app.Thompson.game.util;

/**
 * << Util >>
 * Class for error messages.
 */
public final class ErrorMessages {

    /**
     * Constants for error messages.
     */
    public static final String INVALID_COMMAND = "Comando non valido, riprova.";
    public static final String INVALID_INPUT = "Input non valido, riprova.";
    public static final String MATCH_NOT_NULL = "C'è già una partita in corso.";
    public static final String MATCH_NULL = "Non c'è nessuna partita in corso.";
    public static final String INVALID_PLAYER = "Il giocatore inserito non è valido, comando annullato.";
    public static final String INVALID_CHOICE = "Scelta non valida, comando annullato.";
    public static final String SUGGEST_MATCH_INIT = "Non c'è nessuna partita in corso,"
                                                  + "utilizza '/gioca' per iniziarne una.";

    /**
     * Constructor for ErrorMessages.
     */
    private ErrorMessages() { }
}
