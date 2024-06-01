package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.entity.Board;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.VariantMove;
import java.util.Arrays;
import java.util.Queue;

/**
 * {@literal << Control >>}
 * Class to manage the verification of the moves.
 */
public final class VerifyMovesControl {

    /**
     * Attributes of the class VerifyMovesControl.
     */
    private static final Coordinate[][] AVAILABLE_MOVES = VariantMove.getStandard();

    /**
     * Constructor for the class VerifyMovesControl.
     */
    private VerifyMovesControl() {

    }

    /**
     * Method verifyMovesSinglePawn, to verify the moves of a single pawn.
     * @param board The current board
     * @param from The starting coordinate
     * @param to The ending coordinate
     * @return exists The boolean value of the move
     */
    public static boolean verifyMovesSinglePawn(final Board board, final Coordinate from, final Coordinate to) {
        Coordinate diff = Coordinate.abs(from, to);
        boolean exists = false;
        PawnFigure turn = MainControl.getMatch().getCurrentTurn();
        if (board.getTile(to).isInvalid()) {
            CommunicateErrorsBoundary.printImpossibleMove();
        } else if (board.getTile(from).isOccupied()) {
            PawnFigure colorFrom = board.getTile(from).getPawn().getFigure();

            exists |= Arrays.asList(AVAILABLE_MOVES[0]).contains(diff);
            exists |= Arrays.asList(AVAILABLE_MOVES[1]).contains(diff);

            if ((turn != colorFrom)) {
                exists = false;
                CommunicateErrorsBoundary.printWrongPlayer(turn);
            } else if (!(Board.isGenerable(to, board) == 1 || Board.isJumpable(to, board) == 2)) {
                CommunicateErrorsBoundary.printInvalidMove();
                exists = false;
            }
        } else {
            CommunicateErrorsBoundary.printInvalidStart();
        }

        return exists;
    }

    /**
     * Method verifyMovesAllPawns, to verify the moves of all pawns.
     * @param currentBoard The current board
     * @param player The player
     * @return mask The mask of the moves
     */
    public static int[][] verifyMovesAllPawns(final Board currentBoard, final PawnFigure player) {
        final int dimension = currentBoard.getSize();

        int[][] mask = new int[dimension][dimension];
        Queue<Coordinate> pawnsPositions = currentBoard.getCoordsOfPawns(player);
        Coordinate[][] availableMoves = VariantMove.getStandard();

        while (!pawnsPositions.isEmpty()) {
            Coordinate pawnCoordinate = pawnsPositions.peek();

            for (int i = 0; i < availableMoves[0].length; i++) {
                Coordinate newCoordinate = Coordinate.plus(pawnCoordinate, availableMoves[0][i]);
                int valid = Board.isGenerable(newCoordinate, currentBoard);
                if (valid != 0) {
                    mask[newCoordinate.getX()][newCoordinate.getY()] |= valid;
                }
            }

            for (int j = 0; j < availableMoves[1].length; j++) {
                Coordinate newCoordinate = Coordinate.plus(pawnCoordinate, availableMoves[1][j]);
                int valid = Board.isJumpable(newCoordinate, currentBoard);
                if (valid != 0) {
                    mask[newCoordinate.getX()][newCoordinate.getY()] |= valid;
                }
            }

            pawnsPositions.remove();
        }
        return mask;
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
