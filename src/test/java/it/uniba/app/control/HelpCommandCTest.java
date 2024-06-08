package it.uniba.app.control;
import it.uniba.app.Thompson.game.control.CommandC;
import it.uniba.app.Thompson.game.control.ExitCommandC;
import it.uniba.app.Thompson.game.control.HelpCommandC;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelpCommandCTest {

    @Test
    @DisplayName("HelpCommandCTest")
    void helpCommandCTest() throws InvalidArguments {
        CommandC helpCommandC = HelpCommandC.getInstance();
        Assertions.assertEquals(helpCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "HelpCommandCTest");
    }

    @Test
    @DisplayName("HelpCommandCInvalidArgumentsTest")
    void helpCommandCInvalidArgumentsTest() {
        CommandC helpCommandC = ExitCommandC.getInstance();
        String[] dummyArgs = {"dummy1", "dummy2", "dummy3"};

        Assertions.assertThrows(InvalidArguments.class, () -> helpCommandC.executeCommand(dummyArgs), "Invalid number of arguments");
    }

}
