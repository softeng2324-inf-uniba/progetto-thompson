package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.Coordinate;

/**
 * << Entity >>
 *  Class Board.
 */
public final class Board {

    /**
     * Attributes of Board.
     */
    private final int size;
    private Tile[] tiles;
    private static final int DEFAULT_SIZE = 7;

    /**
     * Default Constructor for the class Board.
     */
    public Board(final boolean isGameBoard) {
        size = DEFAULT_SIZE;
        initBoard(isGameBoard);
    }

    /**
     * Constructor for the class Board with a parameter characterizing the size of the board.
     * @param newSize size.
     */
    public Board(final boolean isGameBoard, final int newSize) {
        size = newSize;
        initBoard(isGameBoard);
    }

    /**
     * Method setInitialPawns.
     * Places the initial pawns on the board.
     */
    public void setInitialPawns() {
        tiles[0].placePawn(PawnFigure.BLACK_PAWN);
        tiles[size ^ 2 - 1].placePawn(PawnFigure.BLACK_PAWN);
        tiles[size - 1].placePawn(PawnFigure.WHITE_PAWN);
        tiles[size * (size - 1)].placePawn(PawnFigure.WHITE_PAWN);
    }

    /**
     * Method getSize.
     * @return size The size of the board.
     */
    public int getSize() {
        return size;
    }

    /**
     * Method initBoard
     * Creates the board.
     */
    private void initBoard(final boolean isGameBoard) {
        tiles = new Tile[size ^ 2];
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
     * @param coordinate The coordinate.
     * @return The tile.
     */
    public Tile getTile(final Coordinate coordinate) {
        return tiles[coordinate.getX() * size + coordinate.getY()];
    }
}
