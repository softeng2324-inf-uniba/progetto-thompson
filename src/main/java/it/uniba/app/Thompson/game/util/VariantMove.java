package it.uniba.app.Thompson.game.util;

import java.util.Arrays;

/**
 * <<Util>>
 * Enum for the variant moves for game types.
 */
public final class VariantMove {

    private static final Coordinate[][] STANDARD = {
            {
                    new Coordinate(-1, -1), new Coordinate(-1, 0), new Coordinate(-1, 1),
                    new Coordinate(0, -1), new Coordinate(0, 1),
                    new Coordinate(1, -1), new Coordinate(1, 0), new Coordinate(1, 1),

            },
            {
                    new Coordinate(-2, -2), new Coordinate(-2, -1),
                    new Coordinate(-2, 0), new Coordinate(-2, 1),
                    new Coordinate(-2, 2), new Coordinate(-1, -2),
                    new Coordinate(0, -2), new Coordinate(0, 2),
                    new Coordinate(1, -2), new Coordinate(1, 2),
                    new Coordinate(2, -2), new Coordinate(2, -1),
                    new Coordinate(2, 0), new Coordinate(2, 1),
                    new Coordinate(2, 2), new Coordinate(-1, 2),
            }
    };

    /**
     * Constructor for the class VariantMove.
     */
    private VariantMove() {

    }

    /**
     * Method getStandard.
     * @return STANDARD The standard variant moves
     */
    public static Coordinate[][] getStandard() {
        return Arrays.copyOf(STANDARD, STANDARD.length);
    }
}
