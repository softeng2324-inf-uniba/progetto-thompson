package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.entity.Board;
import it.uniba.app.Thompson.game.util.Coordinate;

public final class PrintBoardBoundary {
    private PrintBoardBoundary() { }

    public static void printBoard(Board board) {
        int size = board.getSize();
        StringBuilder lol = new StringBuilder();

        for (int i = 0; i < size; i++) {
            System.out.println("POP");
            lol.setLength(0);
            System.out.println("POP");
            lol.append(i);
            System.out.println("POP");
            lol.append(" ");
            System.out.println("POP");
            for (int j = 0; j < size; j++) {
                if (board.getTile(new Coordinate(i, j)).isOccupied()) {
                    lol.append(board.getTile(new Coordinate(i, j)).getPawn().getFigure());
                } else {
                    lol.append(" ");
                }
            }
            System.out.println(lol.toString());
        }
    }
}
