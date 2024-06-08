package it.uniba.app.control;
import it.uniba.app.Thompson.game.control.CommandC;
import it.uniba.app.Thompson.game.control.VoidCommandC;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VoidCommandCTest {

    @Test
    @DisplayName("VoidCommandCTest")
    void voidCommandCTest() throws InvalidArguments {
        CommandC voidCommandC = VoidCommandC.getInstance();
        Assertions.assertEquals(voidCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "VoidCommandCTest");
    }

    @Test
    @DisplayName("VoidCommandCInvalidArgumentsTest")
    void voidCommandCInvalidArgumentsTest() {
        CommandC voidCommandC = VoidCommandC.getInstance();
        String[] dummyArgs = {"dummy1", "dummy2", "dummy3"};

        Assertions.assertThrows(InvalidArguments.class, () -> voidCommandC.executeCommand(dummyArgs), "Invalid number of arguments");
    }

}
