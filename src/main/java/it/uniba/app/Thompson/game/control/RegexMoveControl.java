package it.uniba.app.Thompson.game.control;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexMoveControl {
    private final String movement = "[a-g|A-G][1-7]-[a-g|A-G][1-7]";
    private final String block    = "[a-g|A-G][1-7]";

    public RegexMoveControl() {
    }

    public boolean ControlInputMovement(String input) {
        Pattern pattern = Pattern.compile(movement);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean ControlInputBlock(String input) {
        Pattern pattern = Pattern.compile(block);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
