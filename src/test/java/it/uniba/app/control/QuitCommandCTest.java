package it.uniba.app.control;
import it.uniba.app.Thompson.game.boundary.UserInputB;
import it.uniba.app.Thompson.game.control.CommandC;
import it.uniba.app.Thompson.game.control.ExitCommandC;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.control.QuitCommandC;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import org.junit.jupiter.api.*;


class QuitCommandCTest {


    @BeforeEach
     void setUp() {
        MainControl.initMatch();
    }

    @Test
    @DisplayName("QuitCommandCTest : bianco abbandona la partita")
    void quitCommandCTestbs() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream("b\ns\n".getBytes()));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();
        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCTest: nero abbandona la partita")
    void quitCommandCTestns() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream("n\ns\n".getBytes()));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();
        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCTest : nero non abbandona la partita")
    void quitCommandCTestnnn() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream("n\nn\n".getBytes()));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();
        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCTest : bianco non abbandona la partita")
    void quitCommandCTestbbn() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream("b\nn\n".getBytes()));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();
        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCTest : scelta non valida b/n")
    void quitCommandCTestinvalid() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream("c\n".getBytes()));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();
        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCTest : scelta non valida n/s")
    void quitCommandCTestinvalid2() throws InvalidArguments {
        System.setIn(new java.io.ByteArrayInputStream("n\nb\n".getBytes()));
        UserInputB.resetStdin();
        CommandC quitCommandC = QuitCommandC.getInstance();
        Assertions.assertEquals(quitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("QuitCommandCInvalidArgumentsTest")
    void quitCommandCInvalidArgumentsTest() {
        CommandC quitCommandC = ExitCommandC.getInstance();
        String[] dummyArgs = {"dummy1", "dummy2", "dummy3"};

        Assertions.assertThrows(InvalidArguments.class, () -> quitCommandC.executeCommand(dummyArgs), "Invalid number of arguments");
    }
}
