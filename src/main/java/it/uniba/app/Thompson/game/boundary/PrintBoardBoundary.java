package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.entity.Board;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.UnicodePawn;

/**
 * {@literal << Boundary >>}
 * Class to print the board.
 */
public final class PrintBoardBoundary {

    /**
     * Constructor for the class PrintBoardBoundary.
     */
    private PrintBoardBoundary() { }

    /**
     * Method printBoard.
     * @param board Board to print
     */
    public static void printBoard(final Board board) {
        int size = board.getSize();
        StringBuilder boardRow = new StringBuilder();

        System.out.println("\t A\t B\t C\t D\t E\t F\t G");
        for (int i = 0; i < size; i++) {
            boardRow.setLength(0);
            boardRow.append(i + 1);
            boardRow.append("\t|");
            for (int j = 0; j < size; j++) {
                if (board.getTile(new Coordinate(i, j)).isOccupied()) {
                    boardRow.append(UnicodePawn.getPawnUnicode(
                                    board.getTile(new Coordinate(i, j)).getPawn().getFigure()));
                } else {
                    boardRow.append(" ");
                }
                boardRow.append("\t|");
            }
            System.out.println(boardRow);
        }
    }
}
