package it.uniba.app.Thompson.game.boundary;

import it.uniba.app.Thompson.game.control.FormatterControl;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.Style;

/**
 * << Boundary >>
 * Class to print the welcome banner.
 */
public final class WelcomeBannerBoundary {

    /**
     * Banner to print.
     */
    private String[] banner;

    /**
     * Constructor for WelcomeBanner.
     */
    public WelcomeBannerBoundary() {
        initBanner(new FormatterControl());
    }

    /**
     * Print banner.
     * Print the banner to stdout.
     */
    public void printBanner() {
        for (String i : banner) {
            System.out.println(i);
        }
        System.out.println("Benvenuti in Ataxx, sviluppato dal gruppo Thompson\n");
    }

    /**
     * Initialize the banner.
     * @param fc FormatterControl
     */
    void initBanner(final FormatterControl fc) {
        this.banner = new String[]{
            fc.formatText("------------------------------------------------", Color.RED, Style.BOLD),
            fc.formatText("-    // | |  /__  ___/ // | |  \\ \\/ /   \\ \\/ / -", Color.RED, Style.BOLD),
            fc.formatText("-   //__| |    / /    //__| |   \\/ /     \\/ /  -", Color.RED, Style.BOLD),
            fc.formatText("-  // __| |   / /    / ___  |   / /\\     / /\\  -", Color.RED, Style.BOLD),
            fc.formatText("- //    | |  / /    //    | |  / /\\ \\   / /\\ \\ -", Color.BLUE, Style.BOLD),
            fc.formatText("-//     | | / /    //     | | / /  \\ \\ / /  \\ \\-", Color.BLUE, Style.BOLD),
            fc.formatText("------------------------------------------------", Color.BLUE, Style.BOLD),
        };
    }
}
