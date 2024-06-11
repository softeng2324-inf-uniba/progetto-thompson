package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.UnicodeColor;
import it.uniba.app.Thompson.game.util.Style;
import it.uniba.app.Thompson.game.util.UnicodeStyle;

/**
 * {@literal << Control >>}
 * Class to format the text.
 */
public final class FormatterC {

    /**
     * Constants of the class FormatterC.
     */
    private static final String RESET = "\u001B[0m";

    /**
     * Method formatText.
     * @param text Text that will be formatted
     * @param color Color of the returned string
     * @return Returns the formatted text
     */
   public String formatText(final String text, final Color color) {
        return UnicodeColor.getColorUnicode(color) + text + RESET;
   }

    /**
     * Method formatText.
     * @param text Text that will be formatted
     * @param style Style of the returned string
     * @return Returns the formatted text
     */
    public String formatText(final String text, final Style style) {
        return UnicodeStyle.getStyleUnicode(style) + text + RESET;
    }

    /**
     * Method formatText.
     * @param text Text that will be formatted
     * @param color Color of the returned string
     * @param style Style of the returned string
     * @return Returns the formatted text
     */
    public String formatText(final String text, final Color color, final Style style) {
        return UnicodeStyle.getStyleUnicode(style) + UnicodeColor.getColorUnicode(color) + text + RESET;
    }
}
