package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TimeCommandCTest {

    public static final int TIME_THREAD_SLEEP = 5000;
    @BeforeAll
    static void setUp() {
        MainControl.initMatch();
        System.out.println("Setup completed for TimeCommandCTest");
    }

    @Test
    @DisplayName("TimeCommandCTest: test current time in a match")
    void timeCommandCTest() throws InterruptedException, InvalidArguments {
        System.out.println("Starting TimeCommandCTest");
        CommandC timeCommandC = TimeCommandC.getInstance();
        Thread.sleep(TIME_THREAD_SLEEP);

        Assertions.assertEquals(timeCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "TimeCommandCTest");
    }

    @Test
    @DisplayName("TimeCommandCInvalidArgumentsTest: invalid number of arguments")
    void timeCommandCInvalidArgumentsTest() {
        CommandC timeCommandC = ExitCommandC.getInstance();
        String[] dummyArgs = {"dummy1", "dummy2", "dummy3"};

        Assertions.assertThrows(InvalidArguments.class, () -> timeCommandC.executeCommand(dummyArgs),
            "Invalid number of arguments");
    }

}
