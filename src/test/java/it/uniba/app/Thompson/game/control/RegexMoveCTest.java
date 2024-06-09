package it.uniba.app.Thompson.game.control;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegexMoveCTest {

    @Test
    @DisplayName("RegexMoveCTest: test the regex for a valid block input")
    void regexMoveCTestBlockTrue() {
        RegexMoveC regexMoveC = new RegexMoveC();
        Assertions.assertTrue(regexMoveC.controlInputBlock("d4"), "RegexMoveCTest");
    }

    @Test
    @DisplayName("RegexMoveCTest: test the regex for an invalid block input")
    void regexMoveCTestBlockFalse() {
        RegexMoveC regexMoveC = new RegexMoveC();
        Assertions.assertFalse(regexMoveC.controlInputBlock("a8"), "RegexMoveCTest");
    }

    @Test
    @DisplayName("RegexMoveCTest: test the regex for a valid move input")
    void regexMoveCTestMoveTrue() {
        RegexMoveC regexMoveC = new RegexMoveC();
        Assertions.assertTrue(regexMoveC.controlInputMovement("d4-d5"), "RegexMoveCTest");
    }

    @Test
    @DisplayName("RegexMoveCTest: test the regex for a valid move input")
    void regexMoveCTestMoveFalse() {
        RegexMoveC regexMoveC = new RegexMoveC();
        Assertions.assertFalse(regexMoveC.controlInputMovement("d4-d9"), "RegexMoveCTest");
    }

    @Test
    @DisplayName("RegexMoveCTest: test the regex for a valid generic coordinate input")
    void regexMoveCTestGenericCoordinateTrue() {
        RegexMoveC regexMoveC = new RegexMoveC();
        Assertions.assertTrue(regexMoveC.isGenericCoordinate("d4-d5"), "RegexMoveCTest");
    }

    @Test
    @DisplayName("RegexMoveCTest: test the regex for an invalid generic coordinate input")
    void regexMoveCTestGenericCoordinateFalse() {
        RegexMoveC regexMoveC = new RegexMoveC();
        Assertions.assertFalse(regexMoveC.isGenericCoordinate("d4-%9"), "RegexMoveCTest");
    }
}
