package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.boundary.UserInputBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.util.PawnFigure;

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
                CommunicateInteractionMessagesBoundary.printQuittingPlayer();
                String whichPlayer = UserInputBoundary.getInput();

                whichPlayer = whichPlayer.trim().toLowerCase();

                if (whichPlayer.equals("n") || whichPlayer.equals("b")) {
                    CommunicateInteractionMessagesBoundary.printSureToQuit();
                    String assurance = UserInputBoundary.getInput();

                    assurance = assurance.trim().toLowerCase();

                    if (assurance.equals("s")) {
                        if (whichPlayer.equals("b")) {
                            CommunicateInteractionMessagesBoundary.printWinner(PawnFigure.BLACK_PAWN,
                                    MainControl.getMatch().getBoard().countPawns(PawnFigure.BLACK_PAWN),
                                    0);
                        } else {
                            CommunicateInteractionMessagesBoundary.printWinner(PawnFigure.WHITE_PAWN,
                                    MainControl.getMatch().getBoard().countPawns(PawnFigure.WHITE_PAWN),
                                    0);
                        }
                        MainControl.removeMatch();
                    } else if (assurance.equals("n")) {
                        CommunicateInteractionMessagesBoundary.printAbortedQuit();
                    } else {
                        CommunicateErrorsBoundary.printInvalidChoice();
                    }
                } else {
                    CommunicateErrorsBoundary.printInvalidPlayer();
                }
            }

            return CommandStatus.SUCCESSFUL;
        }
}
