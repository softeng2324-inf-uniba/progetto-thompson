package it.uniba.app.control;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.entity.BoardE;
import it.uniba.app.Thompson.game.entity.MoveE;
import it.uniba.app.Thompson.game.entity.TileE;
import it.uniba.app.Thompson.game.error.CommandNotFound;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
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

    @Test
    @DisplayName("MainControlTest : try to execute a not available command")
    void executeCommandInvalidArgumentsTest() {
        Assertions.assertThrows(InvalidArguments.class, () -> MainControl.findAndExecuteCommand(new String[]{"/vuoto", "dummy"}, MainControl.getCommands()), "MainControlTest");
    }

    @Test
    @DisplayName("MainControlTest : execute a valid command")
    void executeCommandValidTest() throws InvalidArguments, CommandNotFound {
        Assertions.assertInstanceOf(CommandStatus.class, MainControl.findAndExecuteCommand(new String[]{"/vuoto"}, MainControl.getCommands()), "MainControlTest");
    }

    @Test
    @DisplayName("MainControlTest : valid move")
    void mainManageMoveValidTest() {
        MainControl.initMatch();
        MainControl.manageMove(new Coordinate(0,0),new Coordinate(1,1));
        BoardE board = MainControl.getMatch().getBoard();
        Assertions.assertTrue(board.getTile(new Coordinate(1,1)).isOccupied());
        MainControl.removeMatch();
    }

    @Test
    @DisplayName("MainControlTest : invalid move")
    void mainManageMoveInvalidTest() {
        MainControl.initMatch();
        MainControl.manageMove(new Coordinate(0,0),new Coordinate(2,4));
        BoardE board = MainControl.getMatch().getBoard();
        Assertions.assertFalse(board.getTile(new Coordinate(1,1)).isOccupied());
        MainControl.removeMatch();
    }

    @Test
    @DisplayName("MainControlTest : black win white lose")
    void blackWinTest() {
        MainControl.initMatch();
        BoardE board = MainControl.getMatch().getBoard();

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++){
                Coordinate coord = new Coordinate(i,j);
                TileE tile = new TileE(i,j);
                tile.placePawn(PawnFigure.BLACK_PAWN);
                board.setTile(coord,tile);
            }
        }
        MainControl.setMatchBoard(board);
        PrintBoardB.printBoard(MainControl.getMatch().getBoard());
        MainControl.endMatch();
        Assertions.assertNull(MainControl.getMatch());
    }

}
