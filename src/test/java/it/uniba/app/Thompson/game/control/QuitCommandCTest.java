package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.UserInputB;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.charset.StandardCharsets;


class QuitCommandCTest {

    @BeforeEach
     void setUp() {
        MainControl.initMatch();
    }

    @Test
    @DisplayName("QuitCommandCWhiteAcceptedTest : White player wants to quit, then he accepts to quit")
    void quitCommandCWhiteAcceptedTest() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream("b\ns\n".getBytes(StandardCharsets.UTF_8)));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();

        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCBlackAcceptedTest : Black player wants to quit, then he accepts to quit")
    void quitCommandCBlackAcceptedTest() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream("n\ns\n".getBytes(StandardCharsets.UTF_8)));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();

        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCBlackRejectedTest : Black player wants to quit, then he refuses to quit")
    void quitCommandCBlackRejectedTest() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream(("n\nn\n").getBytes(StandardCharsets.UTF_8)));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();

        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCTest : White player wants to quit, then he refuses to quit")
    void quitCommandCWhiteRejectedTest() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream("b\nn\n".getBytes(StandardCharsets.UTF_8)));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();

        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCPlayerInvalidTest : the choice of player is invalid")
    void quitCommandCChoicePlayerInTest() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream("c\n".getBytes(StandardCharsets.UTF_8)));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();

        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCConfirmInvalidTest : the choice to confirm is invalid")
    void quitCommandCConfirmInvalidTest() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream("n\nb\n".getBytes(StandardCharsets.UTF_8)));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();

        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCInvalidArgumentsTest : invalid number of arguments")
    void quitCommandCInvalidArgumentsTest() {
        CommandC quitCommandC = ExitCommandC.getInstance();
        String[] dummyArgs = {"dummy1", "dummy2", "dummy3"};

        Assertions.assertThrows(InvalidArguments.class, () -> quitCommandC.executeCommand(dummyArgs),
        "Invalid number of arguments");
    }
}
