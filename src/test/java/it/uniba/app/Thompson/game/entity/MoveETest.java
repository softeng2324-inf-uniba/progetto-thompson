package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.error.InvalidCoordinate;
import it.uniba.app.Thompson.game.util.Coordinate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoveETest {
    private static final int INVALID_COORDINATE = -2;
    private static final int VALID_COORDINATE = 2;

    @Test
    @DisplayName("toBoardString: tests if the conversion of a valid move to a string is correct")
    void testToBoardStringValid() {
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(2, 2);
        MoveE move = new MoveE(start, end);
        try {
            assertEquals("a1-c3", move.toBoardString(), "From coordinate is correctly returned");
        } catch (InvalidCoordinate e) {
            System.out.println("Invalid coordinate to convert");
        }
    }

    @Test
    @DisplayName("toBoardString: tests if the conversion "
            + "of a move with an invalid start coordinate throws an exception")
    void testToBoardStringInvalidStart() {
        Coordinate start = new Coordinate(-1, -1);
        Coordinate end = new Coordinate(VALID_COORDINATE, VALID_COORDINATE);
        MoveE move = new MoveE(start, end);
        assertThrows(InvalidCoordinate.class, move::toBoardString,
                "Invalid coordinate to convert");
    }

    @Test
    @DisplayName("toBoardString: tests if the conversion of a move with an invalid end coordinate throws an exception")
    void testToBoardStringInvalidEnd() {
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(INVALID_COORDINATE, INVALID_COORDINATE);
        MoveE move = new MoveE(start, end);
        assertThrows(InvalidCoordinate.class, move::toBoardString,
                "Invalid coordinate to convert");
    }

    @Test
    @DisplayName("toBoardString: tests if the conversion of a move with both invalid coordinates throws an exception")
    void testToBoardStringInvalidBoth() {
        Coordinate start = new Coordinate(-1, -1);

        Coordinate end = new Coordinate(INVALID_COORDINATE, INVALID_COORDINATE);
        MoveE move = new MoveE(start, end);
        assertThrows(InvalidCoordinate.class, move::toBoardString,
                "Invalid coordinate to convert");
    }
}
