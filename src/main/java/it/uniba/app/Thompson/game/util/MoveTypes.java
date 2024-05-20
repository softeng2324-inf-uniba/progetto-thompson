package it.uniba.app.Thompson.game.util;

/**
 * {@literal << Util >>}
 * Enum representing the variant moves for game types.
 */
public enum MoveTypes {

        /**
         * IMPOSSIBLE The impossibility to make a move in a certain tile.
         */
        IMPOSSIBLE,

        /**
         * Generate The possibility to make the generate move .
         */
        GENERATE,

        /**
         * JUMP The possibility to make the jump move .
         */
        JUMP,

        /**
         * BOTH The possibility to make both type of moves.
         */
        BOTH
}
