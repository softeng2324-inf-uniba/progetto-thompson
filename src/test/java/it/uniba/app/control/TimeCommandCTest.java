package it.uniba.app.control;
import it.uniba.app.Thompson.game.control.CommandC;
import it.uniba.app.Thompson.game.control.ExitCommandC;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.control.TimeCommandC;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.Thread;

public class TimeCommandCTest {

    @BeforeAll
    static void setUp() {
        MainControl.initMatch();
        System.out.println("Setup completed for TimeCommandCTest");
    }

    @Test
    @DisplayName("TimeCommandCTest")
    void timeCommandCTest() throws InterruptedException, InvalidArguments {
        System.out.println("Starting TimeCommandCTest");
        CommandC timeCommandC = TimeCommandC.getInstance();
        Thread.sleep(5000);
        Assertions.assertEquals(timeCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("TimeCommandCInvalidArgumentsTest")
    void timeCommandCInvalidArgumentsTest() {
        CommandC timeCommandC = ExitCommandC.getInstance();
        String[] dummyArgs = {"dummy1", "dummy2", "dummy3"};

        Assertions.assertThrows(InvalidArguments.class, () -> timeCommandC.executeCommand(dummyArgs), "Invalid number of arguments");
    }

}
