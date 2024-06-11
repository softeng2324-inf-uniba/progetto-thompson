package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.FormatterC;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.ErrorMessage;
import it.uniba.app.Thompson.game.util.PawnFigure;


/**
 * {@literal << Boundary >>}
 * Class to communicate errors.
 */
public final class CommunicateErrorB {

    /**
     * Attributes of the class CommunicateErrorB.
     */
    private static final FormatterC FORMATTER_CONTROL = new FormatterC();

    /**
     * Constructor for the class CommunicateErrors.
     */
    private CommunicateErrorB() { }

    /**
     * Method printMatchNotNull, prints to stdout the match not null message.
     */
    public static void printMatchNotNull() {
        System.out.println(ErrorMessage.MATCH_NOT_NULL);
    }

    /**
     * Method printMatchNull, prints to stdout the match null message.
     */
    public static void printMatchNull() {
        System.out.println(ErrorMessage.SUGGEST_MATCH_INIT);
    }

    /**
     * Method printInvalidPlayer, prints to stdout the invalid player message.
     */
    public static void printInvalidPlayer() {
        System.out.println(ErrorMessage.INVALID_PLAYER);
    }

    /**
     * Method printInvalidChoice, prints to stdout the invalid choice message.
     */
    public static void printInvalidChoice() {
        System.out.println(ErrorMessage.INVALID_CHOICE);
    }

    /**
     * Method printSuggestMatchInit, prints to stdout the suggest match init message.
     */
    public static void printSuggestMatchInit() {
        System.out.println(ErrorMessage.SUGGEST_MATCH_INIT);
    }

    /**
     * Method printCommandNotFound, prints to stdout the command not found message.
     */
    public static void printCommandNotFound() {
        System.out.println(ErrorMessage.COMMAND_NOT_FOUND);
    }

    /**
     * Method printArgumentNotFound, prints to stdout the argument not found message.
     * @param parameter The parameter that was not found
     */
    public static void printArgumentNotFound(final String parameter) {
        System.out.println(parameter + "\t\t " + ErrorMessage.ARGUMENT_NOT_FOUND);
    }

    /**
     * Method printGenericError, prints to stdout the generic error message.
     */
    public static void printGenericError() {
        System.out.println(ErrorMessage.GENERIC_ERROR);
    }

    /**
     * Method printInvalidArguments, prints to stdout the invalid arguments message.
     */
    public static void printInvalidArguments() {
        System.out.println(ErrorMessage.INVALID_ARGUMENTS);
    }

    /**
     * Method printInvalidMove, prints to stdout the invalid move message.
     */
    public static void printInvalidMove() {
        System.out.println(ErrorMessage.INVALID_MOVE);
    }

    /**
     * Method printInvalidStart, prints to stdout the invalid start message.
     */
    public static void printInvalidStart() {
        System.out.println(ErrorMessage.INVALID_START);
    }

    /**
     * Method printInvalidBlock, prints to stdout the wrong player message.
     * @param player The player that should make a move
     */
    public static void printWrongPlayer(final PawnFigure player) {
        System.out.println(FORMATTER_CONTROL.formatText(ErrorMessage.WRONG_PLAYER
                + (player == PawnFigure.BLACK_PAWN ? "nero" : "bianco"), Color.ORANGE));
    }

    /**
     * Method printTooManyInvalidTiles, prints to stdout the too many invalid tiles message.
     */
    public static void printTooManyInvalidTiles() {
        System.out.println(ErrorMessage.TOO_MANY_INVALID_TILES);
    }

    /**
     * Method printInvalidTileToBlock, prints to stdout the invalid tile to block message.
     */
    public static void printInvalidTileToBlock() {
        System.out.println(ErrorMessage.INVALID_TILE_TO_BLOCK);
    }

    /**
     * Method printImpossibleMove, prints to stdout the impossible move message.
     */
    public static void printImpossibleMove() {
        System.out.println(ErrorMessage.IMPOSSIBLE_MOVE);
    }

    /**
     * Method printImpossibleBlock, prints to stdout the impossible block message.
     */
    public static void printImpossibleBlock() {
        System.out.println(ErrorMessage.IMPOSSIBLE_BLOCK);
    }

    /**
     * Method printTileAlreadyBlocked, prints to stdout the tile already blocked message.
     */
    public static void printTileAlreadyBlocked() {
        System.out.println(ErrorMessage.TILE_ALREADY_BLOCKED);
    }

    /**
     * Method printCoordinateNotValid, prints to stdout the coordinate not valid message.
     */
    public static void printCoordinateNotValid() {
        System.out.println(ErrorMessage.COORDINATE_NOT_VALID);
    }

    /**
     * Method printNegativeTime, prints to stdout the negative time message.
     */
    public static void printNegativeTime() {
        System.out.println(ErrorMessage.NEGATIVE_TIME);
    }

    /**
     * Method printInvalidPawn, prints to stdout the invalid pawn message.
     */
    public static void printTileOccupied() {
        System.out.println(ErrorMessage.TILE_OCCUPIED);
    }
}
