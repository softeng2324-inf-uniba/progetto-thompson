package it.uniba.app.control;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.control.MovesCommandC;
import it.uniba.app.Thompson.game.entity.MoveE;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.util.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MovesCommandCTest {

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

        Assertions.assertThrows(InvalidArguments.class, () -> movesCommandC.executeCommand(dummyArgs), "Invalid number of arguments");
    }

    @Test
    @DisplayName("MovesCommandCTest: test the command with some moves made")
    void movesCommandCTestStarted() throws InvalidArguments {
        MainControl.initMatch();
        MovesCommandC movesCommandC = MovesCommandC.getInstance();
        MainControl.pushMoveQueue(new MoveE(new Coordinate(0, 0), new Coordinate(1, 1)));
        MainControl.pushMoveQueue(new MoveE(new Coordinate(0, 6), new Coordinate(0, 5)));
        MainControl.pushMoveQueue(new MoveE(new Coordinate(1, 1), new Coordinate(3, 3)));

        Assertions.assertEquals(movesCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "MovesCommandCTest");
        MainControl.removeMatch();
    }
}
