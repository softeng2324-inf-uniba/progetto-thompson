package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.entity.Board;
import it.uniba.app.Thompson.game.entity.Tile;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.UnicodePawn;
import it.uniba.app.Thompson.game.util.MoveTypes;

/**
 * << Boundary >>
 * Class for printing the board.
 */
public final class PrintBoardBoundary {
    private PrintBoardBoundary() {
    }
    /**
     * Prints the board.
     * @param board Board to print
     */
    public static void printBoard(final Board board) {
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
                Tile currentTile = board.getTile(new Coordinate(i, j));
                if (currentTile.isOccupied()) {
                    System.out.print(" " + UnicodePawn.getPawnUnicode(currentTile.getPawn().getFigure()) + " |");
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
     * Prints the colored board.
     * @param board Board to print
     */
    public static void printBoard(final Board board, final int[][] mask) {
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
                Tile currentTile = board.getTile(new Coordinate(i, j));
                if (currentTile.isOccupied()) {
                    System.out.print(" " + UnicodePawn.getPawnUnicode(currentTile.getPawn().getFigure()) + " ");
                } else {
                    MoveTypes moveType = MoveTypes.values()[mask[i][j]];
                    switch (moveType) {
                        case GENERATE:
                            System.out.print(" 🟨");  // Add explanation for clarity
                            break;
                        case JUMP:
                            System.out.print(" 🟧");    // Add explanation for clarity
                            break;
                        case BOTH:
                            System.out.print(" 🟪");    // Add explanation for clarity
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



