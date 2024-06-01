package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.control.VerifyMovesControl;
import it.uniba.app.Thompson.game.error.ExcessBlockedTileError;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.VariantMove;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    private static final int MAX_LOCKABLE_TILES = 9;
    private static final int CONSIDERED_ADJACENT = 2;

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
     * Defensive copy Constructor for the class Board.
     * @param defensiveCopy The copied board
     */
    public Board(final Board defensiveCopy) {
        size = defensiveCopy.getSize();
        tiles = defensiveCopy.getTiles();
    }

    /**
     * Method getTiles.
     * @return newTiles The clone of the tiles array.
     */
    public Tile[] getTiles() {
        Tile[] newTiles = null;
        if (tiles != null) {
            newTiles = new Tile[tiles.length];
            for (int i = 0; i < tiles.length; i++) {
                newTiles[i] = new Tile(tiles[i].getX(), tiles[i].getY(), tiles[i].isInvalid());
                if (tiles[i].isOccupied()) {
                    newTiles[i].placePawn(tiles[i].getPawn().getFigure());
                }
            }
        }
        return newTiles;
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
     * Method setTile.
     * @param coordinate The coordinates of the tile
     * @param tile The tile to be set
     */
    public void setTile(final Coordinate coordinate, final Tile tile) {
        tiles[coordinate.getX() * size + coordinate.getY()] = tile;
    }

    /**
     * Method setTiles.
     * @param newTiles The new tiles array
     */
    public void setTiles(final Tile[] newTiles) {
        Tile[] defensiveCopy = new Tile[newTiles.length];
        for (int i = 0; i < newTiles.length; i++) {
            defensiveCopy[i] = new Tile(newTiles[i].getX(), newTiles[i].getY());
            if (newTiles[i].isOccupied()) {
                defensiveCopy[i].placePawn(newTiles[i].getPawn().getFigure());
            }
        }
        tiles = defensiveCopy;
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

    /**
     * Method getCoordsOfPawns.
     * @param turn The color of the pawns to get the coordinates
     * @return coordinatesOfPawns The coordinates of the pawns of color turn.
     */
    public Queue<Coordinate> getCoordsOfPawns(final PawnFigure turn) {
        Queue<Coordinate> coordinatesOfPawns = new LinkedList<>();

        for (Tile tile : tiles) {
            if (tile.isOccupied() && tile.getPawn().getFigure() == turn) {
                coordinatesOfPawns.add(tile.getCoordinate());
            }
        }

        return coordinatesOfPawns;
    }

    /**
     * Method isJumpable.
     * @param coordinate The coordinate
     * @param board The board
     * @return 2 if the tile is not occupied and is in the board, 0 otherwise.
     */
    public static int isJumpable(final Coordinate coordinate, final Board board) {
        return board.isInBoard(coordinate) && !board.getTile(coordinate).isOccupied()  ? 2 : 0;
    }

    /**
     * Method isGenerable.
     * @param coordinate The coordinate
     * @param board The board
     * @return 1 if the tile is not occupied and is in the board, 0 otherwise.
     */
    public static int isGenerable(final Coordinate coordinate, final Board board) {
        return board.isInBoard(coordinate) && !board.getTile(coordinate).isOccupied()  ? 1 : 0;
    }

    /**
     * Method isInBoard.
     * @param coordinate The coordinate
     * @return true if the coordinate is in the board, false otherwise.
     */
    public Boolean isInBoard(final Coordinate coordinate) {
        return coordinate.getX() >= 0 && coordinate.getX() < size && coordinate.getY() >= 0 && coordinate.getY() < size;
    }

    /**
     * Method countBlockedTiles.
     * @return count The number of blocked tiles.
     */
    private int countBlockedTiles() {
        int count = 0;
        for (Tile tile : tiles) {
            if (tile.isInvalid()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Method blockTile.
     * @param blockedCoordinate The coordinate of the tile to block
     */
    public void blockTile(final Coordinate blockedCoordinate) throws ExcessBlockedTileError {
        if (countBlockedTiles() >= MAX_LOCKABLE_TILES) {
            throw new ExcessBlockedTileError();
        }

        Coordinate[] invalidCoordinates = {
            new Coordinate(1, 1),
            new Coordinate(1, size),
            new Coordinate(size, 1),
            new Coordinate(size, size),
        };

        if (Arrays.stream(invalidCoordinates).anyMatch(invalidCoordinate -> isAdjacent(invalidCoordinate,
                blockedCoordinate))) {
            throw new Error("Adiacente");
        }

        getTile(blockedCoordinate).setInvalid();
    }

    /**
     * Method movePawn.
     * @param from The starting coordinate
     * @param to The ending coordinate
     */
    public void movePawn(final Coordinate from, final Coordinate to) {
        if (VerifyMovesControl.verifyMovesSinglePawn(this, from, to)) {
            boolean type = VerifyMovesControl.moveType(from, to);
            Tile fromTile = getTile(from);
            Tile toTile = getTile(to);
            toTile.placePawn(fromTile.getPawn().getFigure());
            if (!type) {
                fromTile.removePawn();
            }
            this.setTile(from, fromTile);
            this.setTile(to, toTile);
            this.attack(to);
            MainControl.switchTurn();
        }
        int[][] mask = VerifyMovesControl.verifyMovesAllPawns(MainControl.getBoard(),
                MainControl.getMatch().getCurrentTurn());
        if (VerifyMovesControl.isMaskEmpty(mask)) {

            CommunicateInteractionMessagesBoundary.printSkipTurn(MainControl.getMatch().getCurrentTurn());
            MainControl.switchTurn();
        }
    }

    /**
     * Method isAdjacent.
     * Check if coordinate b is adjacent a or is equal to it (max 2 tiles)
     * @param a Fixed coordinate
     * @param b Coordinate to test
     * @return Returns true if b is adjacent a, false otherwise
     */
    private boolean isAdjacent(final Coordinate a, final Coordinate b) {
        return (Math.abs(a.getY() - b.getY()) < CONSIDERED_ADJACENT)
                && (Math.abs(a.getX() - b.getX()) < CONSIDERED_ADJACENT);
    }

    /**
     * Method isBoardFull.
     * @return Returns true if the board is full, false otherwise
     */
    public boolean isBoardFull() {
        for (Tile tile : tiles) {
            if (!tile.isOccupied()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method attack, attacks the pawn in the given coordinate.
     * @param pawn The pawn to attack
     */
    private void attack(final Coordinate pawn) {

        Coordinate[][] moves = VariantMove.getStandard();
        for (int i = 0; i < moves[0].length; i++) {
            Coordinate enemyPawn = Coordinate.plus(pawn, moves[0][i]);
            if (isInBoard(enemyPawn) && getTile(Coordinate.plus(pawn, moves[0][i])).isOccupied()) {
                if (getTile(enemyPawn).getPawn().getFigure() != MainControl.getMatch().getCurrentTurn()) {
                    getTile(enemyPawn).setFigure(MainControl.getMatch().getCurrentTurn());
                }
            }
        }
    }
}
