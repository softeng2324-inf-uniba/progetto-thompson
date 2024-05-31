package it.uniba.app.Thompson.game.control;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * {@literal << Control >>}
 * Class to manage the regular expressions for the movement control.
 */
public class RegexMoveControl {
    private static final String movement = "[a-g|A-G][1-7]-[a-g|A-G][1-7]";
    private static final String block    = "[a-g|A-G][1-7]";

    /**
     * Constructor for the class RegexMoveControl.
     */
    public RegexMoveControl() {
    }

    /**
     * Method controlInputMovement.
     * @param input The input of the movement
     * @return matcher The boolean value of the movement
     */
    public boolean controlInputMovement(final String input) {
        Pattern pattern = Pattern.compile(movement);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /**
     * Method controlInputBlock.
     * @param input The input of the block
     * @return matcher The boolean value of the block
     */
    public boolean controlInputBlock(final String input) {
        Pattern pattern = Pattern.compile(block);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
