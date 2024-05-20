package it.uniba.app.Thompson.game.util;

/**
 * {@literal << Util >>}
 * Class to manage the pawns figure in unicode.
 */
public final class UnicodePawn {

    /**
     * Constructor for the class UnicodePawn.
     */
    private UnicodePawn() { }

    /**
     * Method getPawnUnicode.
     * @param pawn Pawn figure of the returning unicode
     * @return Returns unicode pawn figure based off pawn parameter
     */
    public static String getPawnUnicode(final PawnFigure pawn) {
        switch (pawn) {
            case WHITE_PAWN -> {
                return "\u26C0";
            }
            case BLACK_PAWN -> {
                return "\u26C2";
            }
            default -> {
                return "\u001B[0m";
            }
        }
    }
}
