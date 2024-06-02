package it.uniba.app.Thompson.game.util;

/**
 * {@literal << Util >>}
 * Enum representing the variant moves for game types.
 */
public enum MoveTypes {

        /**
         * INVALID The  impossibility to make the block move.
         */
        INVALID,

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
        BOTH,
}
