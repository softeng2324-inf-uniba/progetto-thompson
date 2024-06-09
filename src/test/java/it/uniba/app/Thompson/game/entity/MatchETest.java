package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.Coordinate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import it.uniba.app.Thompson.game.error.NegativeTime;
import java.util.Queue;

class MatchETest {
    static MatchE match;

    @BeforeAll
    static void setUp() {
        BoardE startingBoard = new BoardE(true);
        match = new MatchE(startingBoard);
    }

    @Test
    @DisplayName("switchTurn: tests if the turn is correctly switched")
    void testSwitchTurn() {
        match.switchTurn();
        assertEquals(PawnFigure.WHITE_PAWN, match.getCurrentTurn(), "Turn is correctly switched");
    }

    @Test
    @DisplayName("formatMillis: tests if the milliseconds are correctly formatted in case of a positive number")
    void testFormatMillis() {
        try {
            assertEquals("00:00:06", MatchE.formatMillis(6000), "Millis are correctly formatted");
        } catch (NegativeTime e) {
            System.out.println("Something went wrong with the time formatting");
        }
    }

    @Test
    @DisplayName("formatMillis: tests if the method throws an exception in case of a negative number")
    void testFormatMillisNegative() {
        assertThrows(NegativeTime.class, () -> MatchE.formatMillis(-6000),
                "Negative millis throw negative time exception");
    }

    @Test
    @DisplayName("formatMillis: tests if the milliseconds are correctly formatted in case of zero milliseconds")
    void testFormatMillisZero() {
        try {
            assertEquals("00:00:00", MatchE.formatMillis(0), "Millis are correctly formatted");
        } catch (NegativeTime e) {
            System.out.println("Somethign went wrong with the time formatting");
        }
    }

    @Test
    @DisplayName("formatMillis: tests if the milliseconds are correctly formatted in case of the upper limit of long type")
    void testFormatMillisUpperLimit() {
        try {
            assertNotNull(MatchE.formatMillis(Long.MAX_VALUE), "Long upper limit millis are formatted");
        } catch (NegativeTime e) {
            System.out.println("Something went wrong with the time formatting");
        }
    }

    @Test
    @DisplayName("formatMillis: tests if the method throws an exception in case of a the under the limit of the long type")
    void testFormatMillisUnderLimit() {
        assertThrows(NegativeTime.class, () -> MatchE.formatMillis(Long.MIN_VALUE), "Long under limit millis throws negative time exception");
    }

    @Test
    @DisplayName("getMoves: tests if the moves are correctly returned")
    void testGetMoves() {
        Coordinate from = new Coordinate(0, 0);
        Coordinate to = new Coordinate(1, 1);
        MoveE move = new MoveE(from, to);
        Coordinate from2 = new Coordinate(1, 1);
        Coordinate to2 = new Coordinate(2, 2);
        MoveE move2 = new MoveE(from2, to2);

        match.pushMove(move);
        match.pushMove(move2);

        Queue<MoveE> moves = match.getMoves();
        MoveE expectedMove = moves.remove();
        MoveE expectedMove2 = moves.remove();

        boolean flag = expectedMove.getFrom() == move.getFrom()
                && expectedMove.getTo() == move.getTo()
                && expectedMove2.getFrom() == move2.getFrom()
                && expectedMove2.getTo() == move2.getTo();

        assertTrue(flag, "Moves are correctly returned");
    }

    @Test
    @DisplayName("matchE: tests if the matchE copy constructor works correctly")
    void testMatchECopyConstructor() {
        MatchE matchCopy = new MatchE(match.getBoard(), match.getMoves(), match.getCurrentTurn());
        MoveE move = match.getMoves().remove();
        MoveE move2 = match.getMoves().remove();
        MoveE moveCopy = matchCopy.getMoves().remove();
        MoveE move2Copy = matchCopy.getMoves().remove();

        boolean flag = match.getCurrentTurn() == matchCopy.getCurrentTurn()
                  && move.getFrom() == moveCopy.getFrom()
                  && move.getTo() == moveCopy.getTo()
                  && move2.getFrom() == move2Copy.getFrom()
                  && move2.getTo() == move2Copy.getTo()
                  && boardEquals(match.getBoard(), matchCopy.getBoard());

        assertTrue(flag, "MatchE copy constructor works correctly");
    }

    private boolean boardEquals(BoardE board1, BoardE board2) {
        int i = 0;
        boolean isEqual = true;
        TileE[] tiles1 = board1.getTiles();
        TileE[] tiles2 = board2.getTiles();

        if (tiles1.length != tiles2.length) {
            isEqual = false;
        }

        while (i < (board1.getSize() * board2.getSize()) - 1 && isEqual) {
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
}
