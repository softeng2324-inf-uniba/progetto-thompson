package it.uniba.app.Thompson.game.util;
import it.uniba.app.Thompson.game.error.InvalidCoordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateTest {

    @Test
    @DisplayName("Test plus method")
    void testPlus() {
        Coordinate x = new Coordinate(1, 2);
        Coordinate y = new Coordinate(3, 4);
        Coordinate result = Coordinate.plus(x, y);
        Coordinate expected = new Coordinate(4, 6);
        assertEquals(expected, result, "Coordinates are correctly calculated");
    }

    @Test
    @DisplayName("Test abs method")
    void testAbs() {
        Coordinate x = new Coordinate(1, 2);
        Coordinate y = new Coordinate(3, 4);
        Coordinate result = Coordinate.abs(x, y);
        Coordinate expected = new Coordinate(2, 2);

        assertEquals(expected, result, "Coordinates are correctly calculated");
    }

    @Test
    @DisplayName("Test toCoordinate method, valid input")
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
    @DisplayName("Test toCoordinate method, invalid input")
    void testToCoordinateInvalid() {
        String coordinate = "invalidCoordinate";
        assertThrows(InvalidCoordinate.class, () -> Coordinate.toCoordinate(coordinate),
                "Invalid coordinate to convert");
    }

    @Test
    @DisplayName("Test equals method, true case")
    void testEqualsTrue() {
        Coordinate x = new Coordinate(1, 2);
        Coordinate y = new Coordinate(1, 2);

        assertEquals(x, y, "Coordinates are equal");
    }

    @Test
    @DisplayName("Test equals method, false case")
    void testEqualsFalse() {
        Coordinate x = new Coordinate(1, 2);
        Coordinate y = new Coordinate(3, 4);
        Assertions.assertNotEquals(x, y, "Coordinates are not equal");
    }
}
