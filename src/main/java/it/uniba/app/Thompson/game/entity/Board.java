package it.uniba.app.Thompson.game.entity;
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
    private Board() {
        size = DEFAULT_SIZE;
    }

    /**
     * Constructor for the class Board with a parameter characterizing the size of the board.
     * @param newSize size.
     */
    private Board(final int newSize) {
        size = newSize;
    }

    /**
     * Method getSize.
     * @return size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Method initBoard
     * Creates the board.
     */
    private void initBoard() {
        tiles = new Tile[size ^ 2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i * size + j] = new Tile(i, j);
            }
        }
    }

    /**
     * Method getTile.
     * @param coordinate the coordinate.
     * @return the tile.
     */
    public Tile getTile(final Coordinate coordinate) {
        return tiles[coordinate.getX() * size + coordinate.getY()];
    }
}
