package it.uniba.app.control;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.PawnFigure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainControlTest {

    @Test
    @DisplayName("MainControlTest : change turn of the main match")
    void switchTurnTest() throws InvalidArguments {
        MainControl.initMatch();
        MainControl.switchTurn();

        Assertions.assertEquals(MainControl.getMatch().getCurrentTurn(), PawnFigure.WHITE_PAWN, "SwitchTurnTest");
    }


}
