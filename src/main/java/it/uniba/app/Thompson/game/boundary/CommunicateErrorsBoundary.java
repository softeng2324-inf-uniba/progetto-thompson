package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.FormatterControl;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.ErrorMessages;
import it.uniba.app.Thompson.game.util.PawnFigure;


/**
 * {@literal << Boundary >>}
 * Class to communicate errors.
 */
public final class CommunicateErrorsBoundary {

    /**
     * Attributes of the class CommunicateErrorsBoundary.
     */
    private static final FormatterControl FORMATTER_CONTROL = new FormatterControl();

    /**
     * Constructor for the class CommunicateErrors.
     */
    private CommunicateErrorsBoundary() { }

    /**
     * Method printMatchNotNull, prints to stdout the match not null message.
     */
    public static void printMatchNotNull() {
        System.out.println(ErrorMessages.MATCH_NOT_NULL);
    }

    /**
     * Method printMatchNull, prints to stdout the match null message.
     */
    public static void printMatchNull() {
        System.out.println(ErrorMessages.SUGGEST_MATCH_INIT);
    }

    /**
     * Method printInvalidPlayer, prints to stdout the invalid player message.
     */
    public static void printInvalidPlayer() {
        System.out.println(ErrorMessages.INVALID_PLAYER);
    }

    /**
     * Method printInvalidChoice, prints to stdout the invalid choice message.
     */
    public static void printInvalidChoice() {
        System.out.println(ErrorMessages.INVALID_CHOICE);
    }

    /**
     * Method printSuggestMatchInit, prints to stdout the suggest match init message.
     */
    public static void printSuggestMatchInit() {
        System.out.println(ErrorMessages.SUGGEST_MATCH_INIT);
    }

    /**
     * Method printCommandNotFound, prints to stdout the command not found message.
     */
    public static void printCommandNotFound() {
        System.out.println(ErrorMessages.COMMAND_NOT_FOUND);
    }

    /**
     * Method printArgumentNotFound, prints to stdout the argument not found message.
     * @param parameter The parameter that was not found
     */
    public static void printArgumentNotFound(final String parameter) {
        System.out.println(parameter + "\t\t " + ErrorMessages.ARGUMENT_NOT_FOUND);
    }

    /**
     * Method printGenericError, prints to stdout the generic error message.
     */
    public static void printGenericError() {
        System.out.println(ErrorMessages.GENERIC_ERROR);
    }

    /**
     * Method printInvalidArguments, prints to stdout the invalid arguments message.
     */
    public static void printInvalidArguments() {
        System.out.println(ErrorMessages.INVALID_ARGUMENTS);
    }

    /**
     * Method printInvalidMove, prints to stdout the invalid move message.
     */
    public static void printInvalidMove() {
        System.out.println(ErrorMessages.INVALID_MOVE);
    }

    /**
     * Method printInvalidStart, prints to stdout the invalid start message.
     */
    public static void printInvalidStart() {
        System.out.println(ErrorMessages.INVALID_START);
    }

    /**
     * Method printInvalidBlock, prints to stdout the wrong player message.
     */
    public static void printWrongPlayer(final PawnFigure player) {
        System.out.println(FORMATTER_CONTROL.formatText(ErrorMessages.WRONG_PLAYER
                + (player == PawnFigure.BLACK_PAWN ? "nero" : "bianco"), Color.ORANGE));
    }

    /**
     * Method printTooManyInvalidTiles, prints to stdout the too many invalid tiles message.
     */
    public static void printTooManyInvalidTiles() {
        System.out.println(ErrorMessages.TOO_MANY_INVALID_TILES);
    }

    /**
     * Method printInvalidTileToBlock, prints to stdout the invalid tile to block message.
     */
    public static void printInvalidTileToBlock() {
        System.out.println(ErrorMessages.INVALID_TILE_TO_BLOCK);
    }

    /**
     * Method printImpossibleBlock, prints to stdout the impossible block message.
     */
    public static void printImpossibleBlock() {
        System.out.println(ErrorMessages.IMPOSSIBLE_BLOCK);
    }
}
