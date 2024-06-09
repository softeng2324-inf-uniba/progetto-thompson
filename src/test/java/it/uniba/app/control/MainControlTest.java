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
    void switchTurnTest() {
        MainControl.initMatch();
        MainControl.switchTurn();

        Assertions.assertEquals(MainControl.getMatch().getCurrentTurn(), PawnFigure.WHITE_PAWN, "MainControlTest");
    }

    @Test
    @DisplayName("MainControlTest : init a match")
    void initMatchTest() {
        MainControl.initMatch();

        Assertions.assertNotEquals(MainControl.getMatch(), null, "MainControlTest");
    }


}
