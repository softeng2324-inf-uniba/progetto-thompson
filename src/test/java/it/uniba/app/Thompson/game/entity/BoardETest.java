package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.PawnFigure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.*;
import it.uniba.app.Thompson.game.error.InvalidMove;

class BoardETest {
    private BoardE board;
    private static final int size = 7;

    @BeforeEach
    void setupEach() {
        board = new BoardE(true);
    }

    @Test
    @DisplayName("movePawn: Tests if the method correctly generates the new pawn")
    void testMovePawnGenerate() {
        MainControl.initMatch();
        BoardE board = MainControl.getMatch().getBoard();
        Coordinate start = new Coordinate(0,0);
        Coordinate end = new Coordinate(1,1);

        try {
            board.movePawn(start, end);

            boolean flag = false;

            if (PawnFigure.BLACK_PAWN == board.getTile(end).getPawn().getFigure()
                    && PawnFigure.BLACK_PAWN == board.getTile(start).getPawn().getFigure()) {

                flag = true;
            }

            Assertions.assertTrue(flag, "The new pawn is correctly generated");
        } catch (InvalidMove e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("movePawn: Tests if the method correctly moves the pawn")
    void testMovePawnMove() {
        MainControl.initMatch();
        BoardE board = MainControl.getMatch().getBoard();
        Coordinate start = new Coordinate(0,0);
        Coordinate end = new Coordinate(2,2);

        try {
            board.movePawn(start, end);

            boolean flag = false;

            if (PawnFigure.BLACK_PAWN == board.getTile(end).getPawn().getFigure() && !board.getTile(start).isOccupied()) {
                flag = true;
            }

            Assertions.assertTrue(flag, "The pawn is correctly moved");
        } catch (InvalidMove e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("movePawn: Tests if the method correctly attacks the pawn")
    void testMovePawnAttack() {
        MainControl.initMatch();
        BoardE testingBoard = MainControl.getMatch().getBoard();
        Coordinate start = new Coordinate(3, 3);
        Coordinate end = new Coordinate(5, 1);
        Coordinate attacked = new Coordinate(6, 0);
        testingBoard.getTile(start).placePawn(PawnFigure.BLACK_PAWN);

        try {
            testingBoard.movePawn(start, end);
        } catch (InvalidMove e) {
            System.out.println(e.getMessage());
        }

        assertEquals(PawnFigure.BLACK_PAWN, testingBoard.getTile(attacked).getPawn().getFigure(), "The method attack correctly attacked the pawn");
    }

    @Test
    @DisplayName("movePawn: Tests if the method doesn't attack the pawn if the pawn is not in the right position")
    void testMovePawnAttackFail() {
        MainControl.initMatch();
        BoardE testingBoard = MainControl.getMatch().getBoard();
        Coordinate start = new Coordinate(3,3);
        Coordinate end = new Coordinate(3,1);

        Queue<Coordinate> oldWhitePawns = testingBoard.getCoordsOfPawns(PawnFigure.WHITE_PAWN);
        Queue<Coordinate> oldBlackPawns = testingBoard.getCoordsOfPawns(PawnFigure.BLACK_PAWN);

        testingBoard.getTile(start).placePawn(PawnFigure.BLACK_PAWN);

        try {            testingBoard.movePawn(start, end);
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
    @DisplayName("movePawn: Tests if the method throws an InvalidMove exception when the move is invalid")
    void testMovePawnInvalidMove() {
        MainControl.initMatch();
        BoardE testingBoard = MainControl.getMatch().getBoard();
        Coordinate start = new Coordinate(0,0);
        Coordinate end = new Coordinate(3,3);

        assertThrows(InvalidMove.class, () -> testingBoard.movePawn(start, end), "The move is invalid");
    }

    @Test
    @DisplayName("isAdjacent: Tests if the method returns true when the two coordinates are adjacent and attached")
    void testIsAdjacentTrueAttached() {
        Coordinate coordinate1 = new Coordinate(0, 0);
        Coordinate coordinate2 = new Coordinate(0, 1);

        assertTrue(board.isAdjacent(coordinate1, coordinate2), "The two coordinates are adjacent and attached");
    }

    @Test
    @DisplayName("isAdjacent: Tests if the method returns true when the two coordinates are adjacent and one tile apart")
    void testIsAdjacentTrueApart() {
        Coordinate coordinate1 = new Coordinate(0, 0);
        Coordinate coordinate2 = new Coordinate(2, 2);

        assertTrue(board.isAdjacent(coordinate1, coordinate2), "The two coordinates are adjacent and one tile apart");
    }

    @Test
    @DisplayName("isAdjacent: Tests if the method returns false when the two coordinates are not adjacent")
    void testIsAdjacentFalse() {
        Coordinate coordinate1 = new Coordinate(0, 0);
        Coordinate coordinate2 = new Coordinate(3, 3);

        assertFalse(board.isAdjacent(coordinate1, coordinate2), "The two coordinates are not adjacent");
    }

    @Test
    @DisplayName("isBoardFull: Tests if the method returns true when the board is full of pawns")
    void testIsBoardFullWithPawns() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board.getTile(new Coordinate(i, j)).placePawn(PawnFigure.BLACK_PAWN);
            }
        }

        assertTrue(board.isBoardFull(), "The board is full");
    }

    @Test
    @DisplayName("isBoardFull: Tests if the method returns true when the board is full of pawns and invalid tiles")
    void testIsBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
    @DisplayName("isBoardFull: Tests if the method returns false when the board has empty and valid tiles")
    void testIsBoardFullFalse() {
        assertFalse(board.isBoardFull(), "The board is not full");
    }
}
