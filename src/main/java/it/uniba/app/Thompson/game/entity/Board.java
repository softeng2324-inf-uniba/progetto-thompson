package it.uniba.app.Thompson.game.entity;

/**
 * <<Entity>>
 *  Class Board.
 */

public final class Board {

    /**
     * Attributes of Board.
     */
    private int size;
    private Tile[] caselle;
    private static final int DEFAULT_SIZE = 7;

    /**
     * Costructor for Board.
     */
    private Board() {
        this.size = DEFAULT_SIZE;
    }

    /**
     * Costructor for Board.
     *
     * @param newsize size
     */
    private Board(final int newsize) {
        this.size = newsize;
    }

    /**
     * Method getSize.
     *
     * @return size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Method setSize.
     * TODO:
     * Discutere dell'utilità di questo avendo già il costruttore.
     */
    public void setSize(final int newsize) {
        this.size = newsize;
    }

    /**
     * Method initBoard.
     * Creates the board.
     */
    public void initBoard() {
        Tile[] tiles= new Tile[size ^ 2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i * size + j] = new Tile(i, j);
            }
        }
    }

    /**
     * Method getTile.
     *
     * @param x x.
     * @param y y.
     * @return caselle[x * size + y].
     */
    public Tile getTile(final int x, final int y) {
        return caselle[x * size + y];
    }
}
