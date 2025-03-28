package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorB;
import it.uniba.app.Thompson.game.entity.BoardE;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.VariantMove;
import java.util.Arrays;
import java.util.Queue;

/**
 * {@literal << Control >>}
 * Class to manage the verification of the moves.
 */
public final class VerifyMovesC {

    /**
     * Attributes of the class VerifyMovesC.
     */
    private static final Coordinate[][] AVAILABLE_MOVES = VariantMove.getStandard();

    /**
     * Constructor for the class VerifyMovesC.
     */
    private VerifyMovesC() {

    }

    /**
     * Method verifyMovesSinglePawn, to verify the moves of a single pawn.
     * @param board The current board
     * @param from The starting coordinate
     * @param to The ending coordinate
     * @return exists The boolean value of the move
     */
    public static boolean movesSinglePawn(final BoardE board, final Coordinate from, final Coordinate to) {
        Coordinate diff = Coordinate.abs(from, to);
        boolean exists = false;
        PawnFigure turn = MainControl.getMatch().getCurrentTurn();
        if (board.getTile(to).isInvalid()) {
            CommunicateErrorB.printImpossibleMove();
        } else if (board.getTile(from).isOccupied()) {
            PawnFigure colorFrom = board.getTile(from).getPawn().getFigure();

            exists |= Arrays.asList(AVAILABLE_MOVES[0]).contains(diff);
            exists |= Arrays.asList(AVAILABLE_MOVES[1]).contains(diff);

            if ((turn != colorFrom)) {
                exists = false;
                CommunicateErrorB.printWrongPlayer(turn);
            } else if (!(BoardE.isGenerable(to, board) == 1 || BoardE.isJumpable(to, board) == 2)
                    || !board.isAdjacent(from, to)) {
                exists = false;
            }
        } else {
            CommunicateErrorB.printInvalidStart();
        }

        return exists;
    }

    /**
     * Method verifyMovesAllPawns, to verify the moves of all pawns.
     * @param currentBoard The current board
     * @param player The player
     * @return mask The mask of the moves
     */
    public static int[][] verifyMovesAllPawns(final BoardE currentBoard, final PawnFigure player) {
        final int dimension = currentBoard.getSize();

        int[][] mask = new int[dimension][dimension];
        Queue<Coordinate> pawnsPositions = currentBoard.getCoordsOfPawns(player);
        Coordinate[][] availableMoves = VariantMove.getStandard();

        while (!pawnsPositions.isEmpty()) {
            Coordinate pawnCoordinate = pawnsPositions.peek();

            for (int i = 0; i < availableMoves[0].length; i++) {
                Coordinate newCoordinate = Coordinate.plus(pawnCoordinate, availableMoves[0][i]);
                int valid = BoardE.isGenerable(newCoordinate, currentBoard);
                if (valid != 0) {
                    mask[newCoordinate.getX()][newCoordinate.getY()] |= valid;
                }
            }

            for (int j = 0; j < availableMoves[1].length; j++) {
                Coordinate newCoordinate = Coordinate.plus(pawnCoordinate, availableMoves[1][j]);
                int valid = BoardE.isJumpable(newCoordinate, currentBoard);
                if (valid != 0) {
                    mask[newCoordinate.getX()][newCoordinate.getY()] |= valid;
                }
            }

            pawnsPositions.remove();
        }
        return mask;
    }

    /**
     * Method isMaskEmpty.
     * @param mask The mask of the moves
     * @return Returns true if the mask is empty, false otherwise
     */
    public static boolean isMaskEmpty(final int[][] mask) {
        for (int[] row : mask) {
            for (int cell : row) {
                if (cell != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method MoveType.
     * @param from The starting coordinate
     * @param to The ending coordinate
     * @return type The type of the move
     */
    public static boolean moveType(final Coordinate from, final Coordinate to) {
        boolean type = false;
        Coordinate diff = Coordinate.abs(from, to);

        if (Arrays.asList(AVAILABLE_MOVES[0]).contains(diff)) {
            type = true;
        }
        if (Arrays.asList(AVAILABLE_MOVES[1]).contains(diff)) {
            type = false;
        }
        return type;
    }
}
