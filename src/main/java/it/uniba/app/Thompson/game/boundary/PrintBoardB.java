package it.uniba.app.Thompson.game.boundary;

import it.uniba.app.Thompson.game.control.FormatterC;
import it.uniba.app.Thompson.game.entity.BoardE;
import it.uniba.app.Thompson.game.entity.TileE;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.MoveType;
import it.uniba.app.Thompson.game.util.UnicodePawn;

/**
 * {@literal << Boundary >>}
 * Class to print the board.
 */
public final class PrintBoardB {

    /**
     * Constructor for the class PrintBoardB.
     */
    private PrintBoardB() {
    }

    /**
     * Method printBoard.
     * @param board BoardE to print
     */
    public static void printBoard(final BoardE board) {
        int size = board.getSize();
        System.out.println("     A   B   C   D   E   F   G");
        for (int i = 0; i < size; i++) {
            System.out.print("   +");
            for (int k = 0; k < size; k++) {
                System.out.print("---+");
            }
            System.out.println();

            System.out.print((i + 1) + "  |");

            for (int j = 0; j < size; j++) {
                TileE currentTile = board.getTile(new Coordinate(j, i));
                if (currentTile.isOccupied()) {
                    System.out.print(" " + UnicodePawn.getPawnUnicode(currentTile.getPawn().getFigure()) + " |");
                } else if (currentTile.isInvalid()) {
                    FormatterC formatter = new FormatterC();
                    System.out.print(" " + formatter.formatText("\u2B1B", Color.GREY) + "|");
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println();
        }
        System.out.print("   +");
        for (int k = 0; k < size; k++) {
            System.out.print("---+");
        }
        System.out.println();
    }

    /**
     * Method overloaded printBoard.
     * @param board BoardE to print
     * @param mask auxiliary matrix to keep track of the possible moves
     */
    public static void printBoard(final BoardE board, final int[][] mask) {
        int size = board.getSize();
        FormatterC formatter = new FormatterC();

        System.out.println("     A   B   C   D   E   F   G");
        for (int i = 0; i < size; i++) {
            System.out.print("   +");
            for (int k = 0; k < size; k++) {
                System.out.print("---+");
            }
            System.out.println();
            System.out.print((i + 1) + "  |");
            for (int j = 0; j < size; j++) {
                TileE currentTile = board.getTile(new Coordinate(j, i));
                if (currentTile.isInvalid()) {
                    System.out.print(" " + formatter.formatText("\u2B1B", Color.GREY));
                } else if (currentTile.isOccupied()) {
                    System.out.print(" " + UnicodePawn.getPawnUnicode(currentTile.getPawn().getFigure()) + " ");
                } else {
                    MoveType moveType = MoveType.values()[mask[j][i]];
                    switch (moveType) {
                        case GENERATE:
                            System.out.print(" " + formatter.formatText("\u2B1B", Color.YELLOW));
                            break;
                        case JUMP:
                            System.out.print(" " + formatter.formatText("\u2B1B", Color.ORANGE));
                            break;
                        case BOTH:
                            System.out.print(" " + formatter.formatText("\u2B1B", Color.PINK));
                            break;
                        default:
                            System.out.print("   ");
                            break;
                    }
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.print("   +");
        for (int k = 0; k < size; k++) {
            System.out.print("---+");
        }
        System.out.println();
    }
}
