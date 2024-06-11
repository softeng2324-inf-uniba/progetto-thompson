package it.uniba.app.Thompson.game.control;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * {@literal << Control >>}
 * Class to manage the regular expressions for the movement control.
 */
public class RegexMoveC {
    private static final String MOVEMENT = "[a-g|A-G][1-7]-[a-g|A-G][1-7]";
    private static final String BLOCK = "[a-g|A-G][1-7]";
    private static final String GENERIC_COORDINATE = "[a-z|A-Z][0-9]-[a-z|A-Z][0-9]";
    /**
     * Constructor for the class RegexMoveC.
     */
    public RegexMoveC() {
    }

    /**
     * Method controlInputMovement.
     * @param input The input of the movement
     * @return Returns the boolean value of the control on the movement
     */
    public boolean controlInputMovement(final String input) {
        Pattern pattern = Pattern.compile(MOVEMENT);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /**
     * Method controlInputGenericCoordinate.
     * @param input The input of the generic coordinate
     * @return Returns the boolean value of the control on the generic coordinate
     */
    public boolean isGenericCoordinate(final String input) {
        Pattern pattern = Pattern.compile(GENERIC_COORDINATE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /**
     * Method controlInputBlock.
     * @param input The input of the block
     * @return Returns the boolean value of the control on the block
     */
    public boolean controlInputBlock(final String input) {
        Pattern pattern = Pattern.compile(BLOCK);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
