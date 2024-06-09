package it.uniba.app.control;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.entity.MoveE;
import it.uniba.app.Thompson.game.util.Coordinate;
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

    @Test
    @DisplayName("MainControlTest : push a move into main match")
    void pushMoveTest() {
        MainControl.initMatch();
        MainControl.pushMoveQueue(new MoveE((new Coordinate(1,1)), (new Coordinate(2,2))));

        Assertions.assertEquals(MainControl.getMatch().getMoves().toArray().length, 1, "MainControlTest");
    }

    @Test
    @DisplayName("MainControlTest : try to execute a not available command")
    void executeCommandNotFoundTest() {
        Assertions.assertThrows(CommandNotFound.class, () -> MainControl.findAndExecuteCommand(new String[]{"dummy"}, MainControl.getCommands()), "MainControlTest");
    }


//
//    @Test
//    @DisplayName("MainControlTest : vince il bianco e perde il ner")
//

}
