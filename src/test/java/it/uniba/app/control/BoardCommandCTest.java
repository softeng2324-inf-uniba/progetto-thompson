package it.uniba.app.control;

import it.uniba.app.Thompson.game.control.BoardCommandC;
import it.uniba.app.Thompson.game.control.CommandC;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardCommandCTest {

    @Test
    @DisplayName("BoardCommandCTest: print board when the game hasn't started yet")
    void boardCommandCTest() throws InvalidArguments {
        BoardCommandC boardCommandC = BoardCommandC.getInstance();
        Assertions.assertEquals(boardCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "BoardCommandCTest");
    }

    @Test
    @DisplayName("BoardCommandCTest: print board when the game has started")
    void boardCommandCTestOnGoing() throws InvalidArguments {
        MainControl.initMatch();
        BoardCommandC boardCommandC = BoardCommandC.getInstance();
        Assertions.assertEquals(boardCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "BoardCommandCTest");
    }

    @Test
    @DisplayName("BoardCommandCTest: invalid number of arguments")
    void PlayCommandCInvalidArgumentsTest() {
        CommandC boardCommandC = BoardCommandC.getInstance();
        String[] dummyArgs = {"dummy1", "dummy2", "dummy3"};

        Assertions.assertThrows(InvalidArguments.class, () -> boardCommandC.executeCommand(dummyArgs), "Invalid number of arguments");
    }
}
