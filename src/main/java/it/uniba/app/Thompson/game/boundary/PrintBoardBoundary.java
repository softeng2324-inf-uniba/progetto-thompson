package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.entity.Board;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.UnicodePawn;

public final class PrintBoardBoundary {
    private PrintBoardBoundary() { }

    public static void printBoard(Board board) {
        int size = board.getSize();
        StringBuilder lol = new StringBuilder();

        System.out.println("\t A\t B\t C\t D\t E\t F\t G");
        for (int i = 0; i < size; i++) {
            lol.setLength(0);
            lol.append(i + 1);
            lol.append("\t|");
            for (int j = 0; j < size; j++) {
                if (board.getTile(new Coordinate(i, j)).isOccupied()) {
                    lol.append(UnicodePawn.getPawnUnicode(board.getTile(new Coordinate(i, j)).getPawn().getFigure()));
                } else {
                    lol.append(" ");
                }
                lol.append("\t|");
            }
            System.out.println(lol.toString());
        }
    }
}
