package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayCommandCTest {

    @Test
    @DisplayName("PlayCommandCTest: la partita e' gia' in corso")
    void playCommandCTestOnGoing() throws InvalidArguments {
        MainControl.initMatch();
        CommandC playCommandC = PlayCommandC.getInstance();

        Assertions.assertEquals(playCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "PlayCommandCTest");
    }

    @Test
    @DisplayName("PlayCommandCTest: la partita non e' in corso")
    void playCommandCTestNotGoing() throws InvalidArguments {
        MainControl.removeMatch();
        CommandC playCommandC = PlayCommandC.getInstance();

        Assertions.assertEquals(playCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "PlayCommandCTest");
    }

    @Test
    @DisplayName("PlayCommandCTest: invalid number of arguments")
    void playCommandCInvalidArgumentsTest() {
        CommandC playCommandC = PlayCommandC.getInstance();
        String[] dummyArgs = {"dummy1", "dummy2", "dummy3"};

        Assertions.assertThrows(InvalidArguments.class, () -> playCommandC.executeCommand(dummyArgs),
                    "Invalid number of arguments");
    }
}
