package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.UnicodeColor;
import it.uniba.app.Thompson.game.util.Style;
import it.uniba.app.Thompson.game.util.UnicodeStyle;

/**
 * << Control >>
 * Text formatter for colored and styled string.
 */
public final class FormatterControl {
    private static final String RESET = "\u001B[0m";
    /**
     * @param text Text that will be formatted
     * @param color Color of the returned string
     * @return Formatted text
     */
   public String formatText(final String text, final Color color) {
        return UnicodeColor.getUnicodeFromColor(color) + text + RESET;
   }
    /**
     * @param text Text that will be formatted
     * @param style Style of the returned string
     * @return Formatted text
     */
    public String formatText(final String text, final Style style) {
        return UnicodeStyle.getStyleUnicode(style) + text + RESET;
    }
    /**
     * @param text Text that will be formatted
     * @param color Color of the returned string
     * @param style Style of the returned string
     * @return Formatted text
     */
    public String formatText(final String text, final Color color, final Style style) {
        return UnicodeStyle.getStyleUnicode(style) + UnicodeColor.getUnicodeFromColor(color) + text + RESET;
    }
}
