package it.uniba.app.control;

import it.uniba.app.Thompson.game.control.*;
import it.uniba.app.Thompson.game.entity.BoardE;
import it.uniba.app.Thompson.game.entity.TileE;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.PawnFigure;
import org.junit.jupiter.api.Test;
import it.uniba.app.Thompson.game.control.CommandC;
import it.uniba.app.Thompson.game.util.CommandStatus;
import org.junit.jupiter.api.*;

public class AvailableMovesCommandCTest {

    @Test
    @DisplayName("AvailableMovesCommandCTest : check the execution of /qualimosse if the game has started")
    void availableMovesCommandCTestOnGoing() throws InvalidArguments {
        MainControl.initMatch();
        CommandC availableMovesCommandC = AvailableMovesCommandC.getInstance();
        Assertions.assertEquals(availableMovesCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "AvailableMovesCommandCTest");
        MainControl.removeMatch();
    }

    @Test
    @DisplayName("AvailableMovesCommandCTest : check the execution of /qualimosse if the game hasn't started")
    void availableMovesCommandCTestNotGoing() throws InvalidArguments {
        CommandC availableMovesCommandC = AvailableMovesCommandC.getInstance();
        Assertions.assertEquals(availableMovesCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "AvailableMovesCommandCTest");
    }

    @Test
    @DisplayName("AvailableMovesCommandCTest : invalid number of arguments")
    void availableMovesCommandCInvalidArgumentsTest() {
        CommandC availableMovesCommandC = AvailableMovesCommandC.getInstance();
        String[] dummyArgs = {"dummy1", "dummy2", "dummy3"};

        Assertions.assertThrows(InvalidArguments.class, () -> availableMovesCommandC.executeCommand(dummyArgs), "Invalid number of arguments");
    }

    @Test
    @DisplayName("AvailableMovesCommandCTest : check the execution of /qualimosse if there are purple tiles")
    void availableMovesCommandCTestPurpleTiles() throws InvalidArguments {
        MainControl.initMatch();
        MainControl.setMatchBoard();
        CommandC availableMovesCommandC = AvailableMovesCommandC.getInstance();
        BoardE aux = MainControl.getMatch().getBoard();
        TileE tile = aux.getTile(new Coordinate(1, 1));
        tile.placePawn(PawnFigure.BLACK_PAWN);
        aux.setTile(new Coordinate(1, 1),tile);

        MainControl.setBoard(aux);
        Assertions.assertEquals(availableMovesCommandC.executeCommand(), CommandStatus.SUCCESSFUL, "AvailableMovesCommandCTest");
        MainControl.removeMatch();
    }
}
