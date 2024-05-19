package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.FormatterControl;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.Style;

/**
 * {@literal << Boundary >>}
 * Class to print the welcome banner.
 */
public final class WelcomeBannerBoundary {

    /**
     * Attributes of the class WelcomeBannerBoundary.
     */
    private String[] banner;

    /**
     * Constructor for the class WelcomeBannerBoundary.
     */
    public WelcomeBannerBoundary() {
        initBanner(new FormatterControl());
    }

    /**
     * Method printBanner, prints to stdout the welcome banner.
     */
    public void printBanner() {
        for (String i : banner) {
            System.out.println(i);
        }
        System.out.println("Benvenuti, questo è il gioco del gruppo Thompson!!");
    }

    /**
     * Method initBanner.
     * @param fc The FormatterControl to format the banner
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
