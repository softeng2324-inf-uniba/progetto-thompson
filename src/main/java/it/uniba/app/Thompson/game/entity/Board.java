package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.Coordinate;

/**
 * {@literal << Entity >>}
 *  Class representing the board entity.
 */
public final class Board {

    /**
     * Attributes of the class Board.
     */
    private final int size;
    private Tile[] tiles;
    private static final int DEFAULT_SIZE = 7;

    /**
     * Default Constructor for the class Board.
     * @param isGameBoard The boolean determining if the pawns must be placed or not
     */
    public Board(final boolean isGameBoard) {
        size = DEFAULT_SIZE;
        initBoard(isGameBoard);
    }

    /**
     * Size parameterized Constructor for the class Board.
     * @param isGameBoard The boolean determining if the pawns must be placed or not
     * @param newSize The board size
     */
    public Board(final boolean isGameBoard, final int newSize) {
        size = newSize;
        initBoard(isGameBoard);
    }

    /**
     * Method setInitialPawns.
     */
    public void setInitialPawns() {
        tiles[0].placePawn(PawnFigure.BLACK_PAWN);
        tiles[(int) (Math.pow(size, 2)) - 1].placePawn(PawnFigure.BLACK_PAWN);
        tiles[size - 1].placePawn(PawnFigure.WHITE_PAWN);
        tiles[size * (size - 1)].placePawn(PawnFigure.WHITE_PAWN);
    }

    /**
     * Method getSize.
     * @return size The board size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Method initBoard.
     * @param isGameBoard The boolean determining if the pawns must be placed or not
     */
    private void initBoard(final boolean isGameBoard) {
        tiles = new Tile[(int) (Math.pow(size, 2))];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i * size + j] = new Tile(i, j);
            }
        }
        if (isGameBoard) {
            setInitialPawns();
        }
    }

    /**
     * Method getTile.
     * @param coordinate The coordinates of the tile
     * @return Returns the tile
     */
    public Tile getTile(final Coordinate coordinate) {
        return tiles[coordinate.getX() * size + coordinate.getY()];
    }

    /**
     * Method countPawns.
     * @param pawn The figure of the pawns to count
     * @return count The number of pawns of the given pawn figure.
     */
    public int countPawns(final PawnFigure pawn) {
        int count = 0;
        for (Tile tile : tiles) {
            if (tile.isOccupied() && tile.getPawn().getFigure() == pawn) {
                count++;
            }
        }

        return count;
    }
}
