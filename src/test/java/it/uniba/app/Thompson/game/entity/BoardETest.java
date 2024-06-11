package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorB;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.error.InvalidMove;
import it.uniba.app.Thompson.game.error.PawnBlocked;
import it.uniba.app.Thompson.game.error.TileAlreadyBlocked;
import it.uniba.app.Thompson.game.error.TileIsOccupied;
import it.uniba.app.Thompson.game.error.ExcessBlockedTile;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


class BoardETest {

    private BoardE board;
    private static final int SIZE = 7;
    private static final int TEST_PLACEMENTS = 7;
    private static final int MAX_BLOCKED_TILES = 9;
    private static final int CONSTANT_THREE = 3;
    private static final int CONSTANT_FOUR = 4;
    private static final int CONSTANT_FIVE = 5;
    private static final int CONSTANT_SIX = 6;


    @BeforeEach
    void setupEach() {
        board = new BoardE(true);
    }

    @Test
    @DisplayName("setInitialPawns: Tests to check if "
            + "the initial pawns are correctly set, it also tests initial pawns with true parameter")
    void testSetInitalPawns() {
        BoardE expected = new BoardE(false);
        expected.getTile(new Coordinate(0, 0)).placePawn(PawnFigure.BLACK_PAWN);
        expected.getTile(new Coordinate(CONSTANT_SIX, CONSTANT_SIX)).placePawn(PawnFigure.BLACK_PAWN);
        expected.getTile(new Coordinate(0, CONSTANT_SIX)).placePawn(PawnFigure.WHITE_PAWN);
        expected.getTile(new Coordinate(CONSTANT_SIX, 0)).placePawn(PawnFigure.WHITE_PAWN);

        Assertions.assertTrue(boardEquals(expected, board), "The initializations are equal, correct");
    }

    @Test
    @DisplayName("countPawns: Tests to check if the method counts correctly the pawns of a certain color in the board")
    void testCountPawns() {
        boolean expected = true;
        Coordinate[] coordinates = {
                new Coordinate(1, 2),
                new Coordinate(CONSTANT_THREE, CONSTANT_FOUR),
                new Coordinate(CONSTANT_FIVE, CONSTANT_SIX),
                new Coordinate(2, CONSTANT_FOUR),
                new Coordinate(CONSTANT_THREE, CONSTANT_THREE),
        };
        for (Coordinate coordinate : coordinates) {
            board.getTile(coordinate).placePawn(PawnFigure.WHITE_PAWN);
        }
        if (board.countPawns(PawnFigure.WHITE_PAWN) != TEST_PLACEMENTS) {
            expected = false;
        }
        Assertions.assertTrue(expected, "The counter is correct");
    }

    @Test
    @DisplayName("getCoordsOfPawns: Tests if the method returns the right queue of coordinates of the pawns")
    void testGetCoordsOfPawns() {
        boolean isEqual = true;
        PawnFigure testTurn = PawnFigure.BLACK_PAWN;
        Queue<Coordinate> expectedCoordinates = new LinkedList<>();
        Queue<Coordinate> actualCoordinates;
        expectedCoordinates.add(new Coordinate(0, 0));

        Coordinate[] coordinates = {
                new Coordinate(1, 2),
                new Coordinate(2, CONSTANT_FOUR),
                new Coordinate(CONSTANT_THREE, CONSTANT_THREE),
                new Coordinate(CONSTANT_THREE, CONSTANT_FOUR),
                new Coordinate(CONSTANT_FIVE, CONSTANT_SIX),
        };
        for (Coordinate coordinate : coordinates) {
            board.getTile(coordinate).placePawn(testTurn);
            expectedCoordinates.add(coordinate);
        }
        expectedCoordinates.add(new Coordinate(CONSTANT_SIX, CONSTANT_SIX));

        actualCoordinates = board.getCoordsOfPawns(testTurn);
        if (expectedCoordinates.size() != actualCoordinates.size()) {
            isEqual = false;
        } else {
            for (int i = 0; i < expectedCoordinates.size(); i++) {
                if (!expectedCoordinates.remove().equals(actualCoordinates.remove())) {
                    isEqual = false;
                }
            }
        }
        Assertions.assertTrue(isEqual, "The resulting queues with placed pawns coordinates are equal");
    }

    @Test
    @DisplayName("isJumpable: Tests if the method returns success in a correct case")
    void testIsJumpableSuccess() {
        Coordinate correctCoordinate = new Coordinate(0, 1);
        Assertions.assertEquals(2, board.isJumpable(correctCoordinate, board),
                "The condition says success and control works correctly");
    }

    @Test
    @DisplayName("isJumpable: Tests if the method returns failure in the case the tile is occupied")
    void testIsJumpableFailureOccupied() {
        Coordinate occupiedCoordinate = new Coordinate(0, 0);
        Assertions.assertEquals(0, board.isJumpable(occupiedCoordinate, board),
                "The condition says wrong and control works correctly");
    }

    @Test
    @DisplayName("isJumpable: Tests if the method returns failure in the case the tile is invalid")
    void testIsJumpableFailureInvalid() {
        Coordinate invalidCoordinate = new Coordinate(1, 1);
        board.getTile(invalidCoordinate).setInvalid();
        Assertions.assertEquals(0, board.isJumpable(invalidCoordinate, board),
                "The condition says wrong and control works correctly");
    }

    @Test
    @DisplayName("isGenerable: Tests if the method returns success in a correct case")
    void testIsGenerableSuccess() {
        Coordinate correctCoordinate = new Coordinate(0, 1);
        Assertions.assertEquals(1, board.isGenerable(correctCoordinate, board),
                "The condition says success and control works correctly");
    }

    @Test
    @DisplayName("isGenerable: Tests if the method returns failure in the case the tile is occupied")
    void testIsGenerableFailureOccupied() {
        Coordinate occupiedCoordinate = new Coordinate(0, 0);
        Assertions.assertEquals(0, board.isGenerable(occupiedCoordinate, board),
                "The condition says wrong and control works correctly");
    }

    @Test
    @DisplayName("isGenerable: Tests if the method returns failure in the case the tile is invalid")
    void testIsGenerableFailureInvalid() {
        Coordinate invalidCoordinate = new Coordinate(1, 1);
        board.getTile(invalidCoordinate).setInvalid();
        Assertions.assertEquals(0, board.isJumpable(invalidCoordinate, board),
                "The condition says wrong and control works correctly");
    }

    @Test
    @DisplayName("isInBoard: Tests if the method returns success in a correct case")
    void testIsInBoardSuccess() {
        Coordinate correctCoordinate = new Coordinate(CONSTANT_THREE, CONSTANT_THREE);
        Assertions.assertTrue(board.isInBoard(correctCoordinate),
                "The condition says wrong and control works correctly");
    }

    @Test
    @DisplayName("isInBoard: Tests if the method returns failure in a wrong case")
    void testIsInBoardFailure() {
        Coordinate wrongCoordinate = new Coordinate(MAX_BLOCKED_TILES, MAX_BLOCKED_TILES);
        Assertions.assertFalse(board.isInBoard(wrongCoordinate),
                "The condition says wrong and control works correctly");
    }

    @Test
    @DisplayName("countBlockedTiles: Tests if the method correctly counts all the blocked tiles")
    void testCountBlockedTiles() {
        int expected = CONSTANT_FIVE;
        Coordinate[] coordinates = {
                new Coordinate(1, 2),
                new Coordinate(2, CONSTANT_FOUR),
                new Coordinate(CONSTANT_THREE, CONSTANT_THREE),
                new Coordinate(CONSTANT_THREE, CONSTANT_FOUR),
                new Coordinate(CONSTANT_FIVE, CONSTANT_SIX),
        };
        for (Coordinate coordinate : coordinates) {
            board.getTile(coordinate).setInvalid();
        }
        try {
            Method callPrivateMethod = BoardE.class.getDeclaredMethod("countBlockedTiles");
            callPrivateMethod.setAccessible(true);
            int actuallyBlocked = (int) callPrivateMethod.invoke(board);
            Assertions.assertEquals(expected, actuallyBlocked, "It counts correctly");
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | SecurityException e) {
            System.out.println("Errore nella chiamata reflection del metodo privato in board");
        }
    }

    @Test
    @DisplayName("blockTile: Tests if the method actually blocks blockableTiles")
    void testBlockTile() {
        Coordinate lockable = new Coordinate(CONSTANT_THREE, CONSTANT_THREE);
        try {
            board.blockTile(lockable);
            Assertions.assertTrue(board.getTile(lockable).isInvalid(),
                    "The tile is correctly blocked");
        } catch (TileAlreadyBlocked e) {
            CommunicateErrorB.printTileAlreadyBlocked();
        } catch (ExcessBlockedTile e) {
            CommunicateErrorB.printTooManyInvalidTiles();
        } catch (PawnBlocked e) {
            CommunicateErrorB.printImpossibleBlock();
        } catch (TileIsOccupied e) {
            CommunicateErrorB.printTileOccupied();
        }
    }


    @Test
    @DisplayName("blockTile: Tests the throw of the right exception in the case the tile is already blocked")
    void testBlockTileAlreadyBlocked() {
        Coordinate alreadyBlocked = new Coordinate(CONSTANT_THREE, CONSTANT_THREE);
        board.getTile(alreadyBlocked).setInvalid();
        Assertions.assertThrows(TileAlreadyBlocked.class, () -> board.blockTile(alreadyBlocked),
                "The check works correctly and throws the exception");
    }

    @Test
    @DisplayName("blockTile: Tests the throw of the right exception in the case the tile is already occupied")
    void testBlockTileOccupied() {
        Coordinate occupied = new Coordinate(CONSTANT_SIX, CONSTANT_SIX);
        Assertions.assertThrows(TileIsOccupied.class, () -> board.blockTile(occupied),
                "The check works correctly and throws the exception");
    }

    @Test
    @DisplayName("blockTile: Tests the throw"
            + " of the right exception if the user tries to block more than MAX_BLOCKED_TILES tiles")
    void testBlockTileExcessLimit() {
        Coordinate exceedingLimit = new Coordinate(CONSTANT_FIVE, CONSTANT_FIVE);
        Coordinate[] legitBlocks = {
                new Coordinate(1, 2),
                new Coordinate(1, CONSTANT_FOUR),
                new Coordinate(2, CONSTANT_FIVE),
                new Coordinate(2, CONSTANT_FOUR),
                new Coordinate(CONSTANT_THREE, CONSTANT_THREE),
                new Coordinate(CONSTANT_THREE, CONSTANT_FOUR),
                new Coordinate(CONSTANT_FOUR, CONSTANT_FOUR),
                new Coordinate(CONSTANT_FIVE, CONSTANT_SIX),
                new Coordinate(CONSTANT_SIX, 1),
        };
        for (Coordinate element : legitBlocks) {
            board.getTile(element).setInvalid();
        }
        assertThrows(ExcessBlockedTile.class, () -> board.blockTile(exceedingLimit),
                "The check works correctly and throws the exception");
    }

    @Test
    @DisplayName("blockTile: Tests the throw"
            + " of the right exception in the case the user tries to completely block a pawn off")
    void testBlockPawnBlocked() {
        Coordinate blockingPawn = new Coordinate(1, 2);
        Coordinate[] legitBlocks = {
                new Coordinate(0, 1),
                new Coordinate(0, 2),
                new Coordinate(1, 0),
                new Coordinate(1, 1),
                new Coordinate(2, 0),
                new Coordinate(2, 1),
                new Coordinate(2, 2),
        };
        for (Coordinate element : legitBlocks) {
            board.getTile(element).setInvalid();
        }
        assertThrows(PawnBlocked.class, () -> board.blockTile(blockingPawn),
                "The check works correctly and throws the exception");
    }


    public boolean boardEquals(final BoardE board1, final BoardE board2) {
        int i = 0;
        boolean isEqual = true;
        TileE[] tiles1 = board1.getTiles();
        TileE[] tiles2 = board2.getTiles();
        if (tiles1.length != tiles2.length) {
            isEqual = false;
        }
        while (i < (SIZE * SIZE) - 1 && isEqual) {
            if (tiles1[i].isOccupied() && tiles2[i].isOccupied()) {
                if ((tiles1[i].getPawn().getFigure() != tiles2[i].getPawn().getFigure())) {
                    isEqual = false;
                }
            } else if ((tiles1[i].isOccupied() != tiles2[i].isOccupied())
                    || (tiles1[i].isInvalid() != tiles2[i].isInvalid())) {
                isEqual = false;
            }
            i++;
        }
        return isEqual;
    }

    @Test
    @DisplayName("movePawn: Tests if the method "
            + "correctly generates the new pawn")
    void testMovePawnGenerate() {
        MainControl.initMatch();
        BoardE newboard = MainControl.getMatch().getBoard();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(1, 1);

        try {
            newboard.movePawn(start, end);

            boolean flag = false;

            if (PawnFigure.BLACK_PAWN == newboard.getTile(end).getPawn().getFigure()
                    && PawnFigure.BLACK_PAWN == newboard.getTile(start).getPawn().getFigure()) {

                flag = true;
            }

            Assertions.assertTrue(flag, "The new pawn is correctly generated");
        } catch (InvalidMove e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("movePawn: Tests if the "
            + "method correctly moves the pawn")
    void testMovePawnMove() {
        MainControl.initMatch();
        BoardE newboard = MainControl.getMatch().getBoard();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(2, 2);

        try {
            newboard.movePawn(start, end);

            boolean flag = false;

            if (PawnFigure.BLACK_PAWN == newboard.getTile(end).getPawn().getFigure()
                    && !newboard.getTile(start).isOccupied()) {
                flag = true;
            }

            Assertions.assertTrue(flag, "The pawn is correctly moved");
        } catch (InvalidMove e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("movePawn: Tests if "
           + "the method correctly attacks the pawn")
    void testMovePawnAttack() {
        MainControl.initMatch();
        BoardE testingBoard = MainControl.getMatch().getBoard();
        Coordinate start = new Coordinate(CONSTANT_THREE, CONSTANT_THREE);
        Coordinate end = new Coordinate(CONSTANT_FIVE, 1);
        Coordinate attacked = new Coordinate(CONSTANT_SIX, 0);
        testingBoard.getTile(start).placePawn(PawnFigure.BLACK_PAWN);

        try {
            testingBoard.movePawn(start, end);
        } catch (InvalidMove e) {
            System.out.println(e.getMessage());
        }

        assertEquals(PawnFigure.BLACK_PAWN,
                testingBoard.getTile(attacked).getPawn().getFigure(),
                "The method attack correctly attacked the pawn");
    }


        @Test
    @DisplayName("movePawn: Tests if "
            + "the method doesn't attack the pawn if the pawn is not in the right position")
    void testMovePawnAttackFail() {
        MainControl.initMatch();
        BoardE testingBoard = MainControl.getMatch().getBoard();
        Coordinate start = new Coordinate(CONSTANT_THREE, CONSTANT_THREE);
        Coordinate end = new Coordinate(CONSTANT_THREE, 1);

        Queue<Coordinate> oldWhitePawns = testingBoard.getCoordsOfPawns(PawnFigure.WHITE_PAWN);
        Queue<Coordinate> oldBlackPawns = testingBoard.getCoordsOfPawns(PawnFigure.BLACK_PAWN);

        testingBoard.getTile(start).placePawn(PawnFigure.BLACK_PAWN);

        try {
            testingBoard.movePawn(start, end);
        } catch (InvalidMove e) {
            System.out.println(e.getMessage());
        }

        Queue<Coordinate> newWhitePawns = testingBoard.getCoordsOfPawns(PawnFigure.WHITE_PAWN);
        Queue<Coordinate> newBlackPawns = testingBoard.getCoordsOfPawns(PawnFigure.BLACK_PAWN);

        for (Coordinate c : oldWhitePawns) {
            newWhitePawns.remove(c);
        }

        for (Coordinate c : oldBlackPawns) {
            newBlackPawns.remove(c);
        }

        newBlackPawns.removeIf(c -> c.equals(end));

        assertTrue(newWhitePawns.isEmpty() && newBlackPawns.isEmpty(), "No pawn has been attacked");
    }

    @Test
    @DisplayName("movePawn: Tests if "
          + "the method throws an InvalidMove exception when the move is invalid")
    void testMovePawnInvalidMove() {
        MainControl.initMatch();
        BoardE testingBoard = MainControl.getMatch().getBoard();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(CONSTANT_THREE, CONSTANT_THREE);

        assertThrows(InvalidMove.class, () -> testingBoard.movePawn(start, end), "The move is invalid");
    }

    @Test
    @DisplayName("isAdjacent: Tests if "
            + "the method returns true when the two coordinates are adjacent and attached")
    void testIsAdjacentTrueAttached() {
        Coordinate coordinate1 = new Coordinate(0, 0);
        Coordinate coordinate2 = new Coordinate(0, 1);

        assertTrue(board.isAdjacent(coordinate1, coordinate2), "The two coordinates are adjacent and attached");
    }

    @Test
    @DisplayName("isAdjacent: Tests if "
           + "the method returns true when the two coordinates are adjacent and one tile apart")
    void testIsAdjacentTrueApart() {
        Coordinate coordinate1 = new Coordinate(0, 0);
        Coordinate coordinate2 = new Coordinate(2, 2);

        assertTrue(board.isAdjacent(coordinate1, coordinate2), "The two coordinates are adjacent and one tile apart");
    }

    @Test
    @DisplayName("isAdjacent: Tests if "
          +  "the method returns false when the two coordinates are not adjacent")
    void testIsAdjacentFalse() {
        Coordinate coordinate1 = new Coordinate(0, 0);
        Coordinate coordinate2 = new Coordinate(CONSTANT_THREE, CONSTANT_THREE);

        assertFalse(board.isAdjacent(coordinate1, coordinate2), "The two coordinates are not adjacent");
    }

    @Test
    @DisplayName("isBoardFull: Tests if "
           + "the method returns true when the board is full of pawns")
    void testIsBoardFullWithPawns() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board.getTile(new Coordinate(i, j)).placePawn(PawnFigure.BLACK_PAWN);
            }
        }

        assertTrue(board.isBoardFull(), "The board is full");
    }

    @Test
    @DisplayName("isBoardFull: Tests if "
          +  "the method returns true when the board is full of pawns and invalid tiles")
    void testIsBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    board.getTile(new Coordinate(i, j)).placePawn(PawnFigure.BLACK_PAWN);
                } else {
                    board.getTile(new Coordinate(i, j)).setInvalid();
                }
            }
        }

        assertTrue(board.isBoardFull(), "The board is full");
    }

    @Test
    @DisplayName("isBoardFull: Tests if "
           + "the method returns false when the board has empty and valid tiles")
    void testIsBoardFullFalse() {
        assertFalse(board.isBoardFull(), "The board is not full");
    }
}
