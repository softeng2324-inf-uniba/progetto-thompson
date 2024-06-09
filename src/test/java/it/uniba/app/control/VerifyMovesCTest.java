package it.uniba.app.control;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.control.VerifyMovesC;
import it.uniba.app.Thompson.game.entity.BoardE;
import it.uniba.app.Thompson.game.entity.TileE;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.PawnFigure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VerifyMovesCTest {
    @Test
    @DisplayName("VerifyMovesCTest: test the verification of the moves")
    void verifyMovesCtest(){
        MainControl.initMatch();
        BoardE board = MainControl.getMatch().getBoard();

        Assertions.assertTrue(VerifyMovesC.movesSinglePawn(board, new Coordinate(0,0), new Coordinate(0,1)), "VerifyMovesCTest");
        MainControl.removeMatch();
    }

    @Test
    @DisplayName("VerifyMovesCTest: test the verification of an invalid move")
    void verifyMovesCtestInvalidMove(){
        MainControl.initMatch();
        BoardE board = MainControl.getMatch().getBoard();

        Assertions.assertFalse(VerifyMovesC.movesSinglePawn(board, new Coordinate(0,0), new Coordinate(1,8)), "VerifyMovesCTest");
        MainControl.removeMatch();
    }

    @Test
    @DisplayName("VerifyMovesCTest: test the verification of a move on a blocked tile")
    void verifyMovesCtestBlockedTile()  {
        BoardE board = new BoardE(true);
        board.setTile(new Coordinate(0,1), new TileE(0,1,true));

        MainControl.initMatch();
        MainControl.setMatchBoard(board);
        Assertions.assertFalse(VerifyMovesC.movesSinglePawn(board, new Coordinate(0,0), new Coordinate(0,1)), "VerifyMovesCTest");
        MainControl.removeMatch();
    }

    @Test
    @DisplayName("VerifyMovesCTest: test the verification of a move on a occupied tile")
    void verifyMovesCtestOccupiedTile() {
        BoardE board = new BoardE(true);
        TileE tile = new TileE(0,1);
        tile.placePawn(PawnFigure.BLACK_PAWN);
        board.setTile(new Coordinate(0,1), tile);

        MainControl.initMatch();
        MainControl.setMatchBoard(board);
        Assertions.assertFalse(VerifyMovesC.movesSinglePawn(board, new Coordinate(0,0), new Coordinate(0,1)), "VerifyMovesCTest");
        MainControl.removeMatch();
    }
}
