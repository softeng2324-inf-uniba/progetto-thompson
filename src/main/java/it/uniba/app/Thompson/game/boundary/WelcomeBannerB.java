package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.FormatterC;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.Style;

/**
 * {@literal << Boundary >>}
 * Class to print the welcome banner.
 */
public final class WelcomeBannerB {

    /**
     * Attributes of the class WelcomeBannerB.
     */
    private String[] banner;

    /**
     * Constructor for the class WelcomeBannerB.
     */
    public WelcomeBannerB() {
        initBanner(new FormatterC());
    }

    /**
     * Method printBanner, prints to stdout the welcome banner.
     */
    public void printBanner() {
        for (String i : banner) {
            System.out.println(i);
        }
        System.out.println("Benvenuti in Ataxx, sviluppato dal gruppo Thompson");
    }

    /**
     * Method initBanner.
     * @param fc The FormatterC to format the banner
     */
    void initBanner(final FormatterC fc) {
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
