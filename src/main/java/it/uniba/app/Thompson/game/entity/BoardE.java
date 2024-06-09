package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.control.VerifyMovesControl;
import it.uniba.app.Thompson.game.error.ExcessBlockedTile;
import it.uniba.app.Thompson.game.error.InvalidMove;
import it.uniba.app.Thompson.game.error.PawnBlocked;
import it.uniba.app.Thompson.game.error.TileAlreadyBlocked;
import it.uniba.app.Thompson.game.error.TileIsOccupied;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.VariantMove;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * {@literal << Entity >>}
 *  Class representing the board entity.
 */
public final class BoardE {

    /**
     * Attributes of the class BoardE.
     */
    private final int size;
    private TileE[] tiles;
    private static final int DEFAULT_SIZE = 7;
    private static final int MAX_LOCKABLE_TILES = 9;
    private static final int CONSIDERED_ADJACENT = 2;
    private static final int SURROUNDING_LIMIT = 7;

    /**
     * Default Constructor for the class BoardE.
     * @param isGameBoard The boolean determining if the pawns must be placed or not
     */
    public BoardE(final boolean isGameBoard) {
        size = DEFAULT_SIZE;
        initBoard(isGameBoard);
    }

    /**
     * Size parameterized Constructor for the class BoardE.
     * @param isGameBoard The boolean determining if the pawns must be placed or not
     * @param newSize The board size
     */
    public BoardE(final boolean isGameBoard, final int newSize) {
        size = newSize;
        initBoard(isGameBoard);
    }

    /**
     * Defensive copy Constructor for the class BoardE.
     * @param defensiveCopy The copied board
     */
    public BoardE(final BoardE defensiveCopy) {
        size = defensiveCopy.getSize();
        tiles = defensiveCopy.getTiles();
    }

    /**
     * Method getTiles.
     * @return newTiles The clone of the tiles array.
     */
    public TileE[] getTiles() {
        TileE[] newTiles = null;
        if (tiles != null) {
            newTiles = new TileE[tiles.length];
            for (int i = 0; i < tiles.length; i++) {
                newTiles[i] = new TileE(tiles[i].getX(), tiles[i].getY(), tiles[i].isInvalid());
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
        tiles = new TileE[(int) (Math.pow(size, 2))];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i * size + j] = new TileE(i, j);
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
    public TileE getTile(final Coordinate coordinate) {
        return tiles[coordinate.getX() * size + coordinate.getY()];
    }

    /**
     * Method setTile.
     * @param coordinate The coordinates of the tile
     * @param tile The tile to be set
     */
    public void setTile(final Coordinate coordinate, final TileE tile) {
        tiles[coordinate.getX() * size + coordinate.getY()] = tile;
    }

    /**
     * Method setTiles.
     * @param newTiles The new tiles array
     */
    public void setTiles(final TileE[] newTiles) {
        TileE[] defensiveCopy = new TileE[newTiles.length];
        for (int i = 0; i < newTiles.length; i++) {
            defensiveCopy[i] = new TileE(newTiles[i].getX(), newTiles[i].getY(), newTiles[i].isInvalid());
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
        for (TileE tile : tiles) {
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

        for (TileE tile : tiles) {
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
    public static int isJumpable(final Coordinate coordinate, final BoardE board) {
        return board.isInBoard(coordinate) && !board.getTile(coordinate).isOccupied()
                && !board.getTile(coordinate).isInvalid()  ? 2 : 0;
    }

    /**
     * Method isGenerable.
     * @param coordinate The coordinate
     * @param board The board
     * @return 1 if the tile is not occupied and is in the board, 0 otherwise.
     */
    public static int isGenerable(final Coordinate coordinate, final BoardE board) {
        return board.isInBoard(coordinate) && !board.getTile(coordinate).isOccupied()
                && !board.getTile(coordinate).isInvalid()  ? 1 : 0;
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
        for (TileE tile : tiles) {
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
    public void blockTile(final Coordinate blockedCoordinate) throws TileAlreadyBlocked,
            ExcessBlockedTile, PawnBlocked, TileIsOccupied {
        BoardE board = MainControl.getBoard();

        if (board.getTile(blockedCoordinate).isOccupied()) {
            throw new TileIsOccupied();
        }

        if (getTile(blockedCoordinate).isInvalid()) {
            throw new TileAlreadyBlocked();
        }

        if (countBlockedTiles() >= MAX_LOCKABLE_TILES) {
            throw new ExcessBlockedTile();
        }

        Coordinate[] invalidCoordinates = {
                new Coordinate(0, 0),
                new Coordinate(0, size - 1),
                new Coordinate(size - 1, 0),
                new Coordinate(size - 1, size - 1),
        };

        Coordinate pawnTile = Arrays.stream(invalidCoordinates)
            .filter(invalidCoordinate -> isAdjacent(invalidCoordinate, blockedCoordinate))
            .findFirst()
            .orElse(null);

        if (pawnTile != null) {
            int count = 0;

            for (TileE tile : tiles) {
                if (isAdjacent(pawnTile, tile.getCoordinate()) && tile.isInvalid()) {
                    count++;
                }
            }

            if (count >= SURROUNDING_LIMIT) {
                throw new PawnBlocked();
            }
        }

        getTile(blockedCoordinate).setInvalid();
    }

    /**
     * Method movePawn.
     * @param from The starting coordinate
     * @param to The ending coordinate
     */
    public void movePawn(final Coordinate from, final Coordinate to) throws InvalidMove {
        if (!VerifyMovesControl.verifyMovesSinglePawn(this, from, to)) {
            throw new InvalidMove();
        }

        boolean type = VerifyMovesControl.moveType(from, to);
        TileE fromTile = getTile(from);
        TileE toTile = getTile(to);
        toTile.placePawn(fromTile.getPawn().getFigure());
        if (!type) {
            fromTile.removePawn();
            this.attack(to);
        }
        this.setTile(from, fromTile);
        this.setTile(to, toTile);
        this.attack(to);
    }

    /**
     * Method isAdjacent.
     * Check if coordinate b is adjacent a or is equal to it (max 2 tiles)
     * @param a Fixed coordinate
     * @param b Coordinate to test
     * @return Returns true if b is adjacent to a, false otherwise
     */
    public boolean isAdjacent(final Coordinate a, final Coordinate b) {
        return (Math.abs(a.getY() - b.getY()) <= CONSIDERED_ADJACENT)
                && (Math.abs(a.getX() - b.getX()) <= CONSIDERED_ADJACENT);
    }

    /**
     * Method isBoardFull.
     * @return Returns true if the board is full, false otherwise
     */
    public boolean isBoardFull() {
        for (TileE tile : tiles) {
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
