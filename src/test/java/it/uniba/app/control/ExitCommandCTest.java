package it.uniba.app.control;
import it.uniba.app.Thompson.game.control.CommandC;
import it.uniba.app.Thompson.game.control.ExitCommandC;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExitCommandCTest {

    @BeforeAll
    static void setUp() {
        MainControl.initMatch();
        System.out.println("Setup completed for ExitCommandCTest");
    }

    @Test
    @DisplayName("ExitCommandCTest")
    void exitCommandCTest() throws InvalidArguments {
        CommandC exitCommandC = ExitCommandC.getInstance();
        Assertions.assertEquals(exitCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "ExitCommandCTest");
    }
}
