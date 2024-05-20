package it.uniba.app.Thompson.game.control;

import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.boundary.PrintBoardBoundary;
import it.uniba.app.Thompson.game.entity.Board;
import it.uniba.app.Thompson.game.entity.Match;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.VariantMove;

import java.util.Queue;

/**
 * {@literal << Control >>}
 * Class to manage the command available moves.
 */
public final class AvailableMovesCommandControl extends CommandControl {

    /**
     * Attributes of the class AvailableMovesCommandControl.
     */
    private static final String COMMAND = "/qualimosse";
    private static final String DESCRIPTION = "Stampa le mosse disponibili del giocatore corrente per ogni pedina.";
    private static final AvailableMovesCommandControl INSTANCE = new AvailableMovesCommandControl();

    /**
     * Constructor for the class AvailableMovesCommandControl.
     */
    private AvailableMovesCommandControl() { }

    /**
     * Method getInstance.
     * @return INSTANCE The instance of the AvailableMovesCommandControl.
     */
    public static AvailableMovesCommandControl getInstance() {
        return INSTANCE;
    }

    /**
     * Method getDescription.
     * Override of the getDescription method of the abstract class CommandControl.
     * @return DESCRIPTION The command description.
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Method getCommand.
     * Override of the getCommand method of the abstract class CommandControl.
     * @return COMMAND The command.
     */
    @Override
    public String getCommand() {
        return COMMAND;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return Returns the status of the command.
     */
    @Override
    CommandStatus executeCommand() {
        if (MainControl.getMatch() == null) {
            CommunicateErrorsBoundary.printSuggestMatchInit();
        } else {
            Match match = MainControl.getMatch();
            Board currentBoard = match.getBoard();
            final int dimension = currentBoard.getSize();


            int[][] mask = new int[dimension][dimension];
            Queue<Coordinate> pawnsPositions = currentBoard.getCoordsOfPawns(PawnFigure.BLACK_PAWN);
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
            CommunicateInteractionMessagesBoundary.printTitle("MOSSE DISPONIBILI PER IL GIOCATORE 1");
            PrintBoardBoundary.printBoard(currentBoard, mask);
        }
        return CommandStatus.SUCCESSFUL;
    }
}
