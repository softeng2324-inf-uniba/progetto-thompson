package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.entity.MoveE;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.util.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class MovesCommandCTest {
    private static final int CONSTANT_SIX = 6;
    private static final int CONSTANT_FIVE = 5;
    private static final int CONSTANT_THREE = 3;

    @Test
    @DisplayName("MovesCommandCTest: test the command if the game has started")
    void movesCommandCTest() throws InvalidArguments {
        MainControl.initMatch();
        MovesCommandC movesCommandC = MovesCommandC.getInstance();

        Assertions.assertEquals(movesCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "MovesCommandCTest");
        MainControl.removeMatch();
    }

    @Test
    @DisplayName("MovesCommandCTest: test the command if the game has not started")
    void movesCommandCTestNotStarted() throws InvalidArguments {
        MovesCommandC movesCommandC = MovesCommandC.getInstance();

        Assertions.assertEquals(movesCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "MovesCommandCTest");
    }

    @Test
    @DisplayName("MovesCommandCTest: wrong number of arguments")
    void movesCommandCTestWrongArguments() {
        MovesCommandC movesCommandC = MovesCommandC.getInstance();
        String[] dummyArgs = {"dummy1", "dummy2", "dummy3"};

        Assertions.assertThrows(InvalidArguments.class, () -> movesCommandC.executeCommand(dummyArgs),
                "Invalid number of arguments");
    }

    @Test
    @DisplayName("MovesCommandCTest: test the command with some moves made")
    void movesCommandCTestStarted() throws InvalidArguments {
        MainControl.initMatch();
        MovesCommandC movesCommandC = MovesCommandC.getInstance();
        MainControl.pushMoveQueue(new MoveE(new Coordinate(0, 0), new Coordinate(1, 1)));
        MainControl.pushMoveQueue(new MoveE(new Coordinate(0, CONSTANT_SIX), new Coordinate(0, CONSTANT_FIVE)));
        MainControl.pushMoveQueue(new MoveE(new Coordinate(1, 1), new Coordinate(CONSTANT_THREE, CONSTANT_THREE)));

        Assertions.assertEquals(movesCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "MovesCommandCTest");
        MainControl.removeMatch();
    }
}
