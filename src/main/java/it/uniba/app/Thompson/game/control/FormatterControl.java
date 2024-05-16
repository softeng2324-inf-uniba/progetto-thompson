package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.Style;
import it.uniba.app.Thompson.game.util.Colors;
import it.uniba.app.Thompson.game.util.Styles;
/**
 * << Control >>
 * Text formatter for colored and styled string.
 */
public final class FormatterControl {
    private static final String RESET = "\u001B[0m";

    /**
     *
     * @param text Text that will be formatted
     * @param color Color of the returned string
     * @return Colored
     */
   public String formatText(final String text, final Color color) {
        return Colors.getUnicodeFromColor(color) + text + RESET;
    }

    /**
     *
     * @param text
     * @param style
     * @return
     */
    public String formatText(final String text, final Style style) {
        return Styles.getStyleUnicode(style) + Styles.getStyleUnicode(style) + RESET;
    }

    /**
     *
     * @param text
     * @param color
     * @param style
     * @return
     */
    public String formatText(final String text, final Color color, final Style style) {
        return Styles.getStyleUnicode(style) + Colors.getUnicodeFromColor(color) + text + RESET;
    }
}
