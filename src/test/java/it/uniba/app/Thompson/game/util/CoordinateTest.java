package it.uniba.app.Thompson.game.util;
import it.uniba.app.Thompson.game.error.InvalidCoordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateTest {
    private static final int CONSTANT_SIX = 6;
    private static final int CONSTANT_FOUR = 4;
    private static final int CONSTANT_THREE = 3;

    @Test
    @DisplayName("plus: tests if the addition of two coordinates is correct")
    void testPlus() {
        Coordinate x = new Coordinate(1, 2);
        Coordinate y = new Coordinate(CONSTANT_THREE, CONSTANT_FOUR);
        Coordinate result = Coordinate.plus(x, y);
        Coordinate expected = new Coordinate(CONSTANT_FOUR, CONSTANT_SIX);
        assertEquals(expected, result, "Coordinates are correctly calculated");
    }

    @Test
    @DisplayName("abs: tests if the absolute difference between two coordinates is correct")
    void testAbs() {
        Coordinate x = new Coordinate(1, 2);
        Coordinate y = new Coordinate(CONSTANT_THREE, CONSTANT_FOUR);
        Coordinate result = Coordinate.abs(x, y);
        Coordinate expected = new Coordinate(2, 2);

        assertEquals(expected, result, "Coordinates are correctly calculated");
    }

    @Test
    @DisplayName("toCoordinate: tests if the conversion of a string to a coordinate is correct")
    void testToCoordinateValid() {
        String coordinate = "b2";
        try {
            Coordinate result = Coordinate.toCoordinate(coordinate);
            Coordinate expected = new Coordinate(1, 1);
            assertEquals(expected, result, "Coordinates are correctly converted");
        } catch (InvalidCoordinate e) {
            System.out.println("Invalid coordinate to convert");
        }

    }

    @Test
    @DisplayName("toCoordinate: tests if the conversion of an invalid string to a coordinate throws an exception")
    void testToCoordinateInvalid() {
        String coordinate = "invalidCoordinate";
        assertThrows(InvalidCoordinate.class, () -> Coordinate.toCoordinate(coordinate),
                "Invalid coordinate to convert");
    }

    @Test
    @DisplayName("equal: tests if the comparison between two coordinates is true")
    void testEqualsTrue() {
        Coordinate x = new Coordinate(1, 2);
        Coordinate y = new Coordinate(1, 2);

        assertEquals(x, y, "Coordinates are equal");
    }

    @Test
    @DisplayName("equal: tests if the comparison between two different coordinates is false")
    void testEqualsFalse() {
        Coordinate x = new Coordinate(1, 2);
        Coordinate y = new Coordinate(CONSTANT_THREE, CONSTANT_FOUR);
        Assertions.assertNotEquals(x, y, "Coordinates are not equal");
    }

    @Test
    @DisplayName("toBoardString: tests if the conversion of a valid coordinate to a string is correct")
    void testToBoardStringValid() {
        Coordinate coordinate = new Coordinate(1, 1);
        try {
            String result = coordinate.toBoardString();
            assertEquals("b2", result, "Coordinates are correctly converted");
        } catch (InvalidCoordinate e) {
            System.out.println("Invalid coordinate to convert");
        }
    }

    @Test
    @DisplayName("toBoardString: tests if the conversion of an invalid coordinate to a string throws an exception")
    void testToBoardStringInvalidCoordinates() {
        Coordinate coordinate = new Coordinate(-1, -1);
        assertThrows(InvalidCoordinate.class, coordinate::toBoardString,
                "Invalid coordinate to convert");
    }

    @Test
    @DisplayName("toBoardString: tests if the conversion "
            + "of a coordinate with an invalid x value to a string throws an exception")
    void testToBoardStringInvalidFirst() {
        Coordinate coordinate = new Coordinate(1, -1);
        assertThrows(InvalidCoordinate.class, coordinate::toBoardString,
                "Invalid coordinate to convert");
    }

    @Test
    @DisplayName("toBoardString: tests if the conversion "
             + "of a coordinate with an invalid y value to a string throws an exception")
    void testToBoardStringInvalidSecond() {
        Coordinate coordinate = new Coordinate(-1, 1);
        assertThrows(InvalidCoordinate.class, coordinate::toBoardString,
                "Invalid coordinate to convert");
    }
}
