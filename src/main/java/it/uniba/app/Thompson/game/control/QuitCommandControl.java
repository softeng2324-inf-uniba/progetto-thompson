package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.boundary.UserInputBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.util.PawnFigure;

import java.util.Arrays;

/**
 * << Control >>
 * Command to quit the current match.
 */
public final class QuitCommandControl extends CommandControl {
        /**
         * Attributes of QuitCommandControl.
         */
        private static final String COMMAND = "/abbandona";
        private static final String DESCRIPTION = "Abbandona la partita corrente";
        private static final QuitCommandControl INSTANCE = new QuitCommandControl();

        /**
         * Constructor for QuitCommandControl.
         */
        private QuitCommandControl() { }

        /**
         * Method that returns the instance of QuitCommandControl.
         * @return INSTANCE The instance of QuitCommandControl.
         */
        public static QuitCommandControl getInstance() {
            return INSTANCE;
        }

        /**
         * Method that returns command.
         * @return COMMAND Name of the command.
         */
        @Override
        public String getCommand() {
            return COMMAND;
        }

        /**
         * Return description of command.
         * @return DESCRIPTION Description of the command.
         */
        @Override
        public String getDescription() {
            return DESCRIPTION;
        }

        /**
         * Method that executes the quitting of a match.
         * @return Instance of CommandStatus.
         */
        @Override
        public CommandStatus executeCommand() {
            if (MainControl.getMatch() == null) {
                CommunicateErrorsBoundary.printMatchNull();
            } else {
                this.askToQuitGame();
            }

            return CommandStatus.SUCCESSFUL;
        }

        private void askToQuitGame() {
            CommunicateInteractionMessagesBoundary.printQuittingPlayer();
            String whichPlayer = UserInputBoundary.getInput().trim().toLowerCase();
            String[] acceptableResponse = new String[] { "n", "b" };

            if(Arrays.stream(acceptableResponse).noneMatch(a -> a.equals(whichPlayer))) {
                CommunicateErrorsBoundary.printInvalidPlayer();

                return;
            }

            this.askConfirmation(whichPlayer);
        }

        private void askConfirmation(String player) {
            CommunicateInteractionMessagesBoundary.printSureToQuit();
            String confirmation = UserInputBoundary.getInput().trim().toLowerCase();
            String[] acceptableResponse = new String[] { "n", "s" };

            if(Arrays.stream(acceptableResponse).noneMatch(a -> a.equals(confirmation))) {
                CommunicateErrorsBoundary.printInvalidChoice();

                return;
            }

            if (confirmation.equals("s")) {
                this.quitGame(player.equals("b") ? PawnFigure.BLACK_PAWN : PawnFigure.WHITE_PAWN);
            } else {
                CommunicateInteractionMessagesBoundary.printAbortedQuit();
            }
        }

        private void quitGame(PawnFigure winnerPawn) {
            CommunicateInteractionMessagesBoundary.printWinner(
                    winnerPawn,
                    MainControl.getMatch().getBoard().countPawns(winnerPawn),
                    0
            );

            MainControl.removeMatch();
        }
}
