package main.java.it.uniba.app.Thompson.game.boundary;
/**
 * << Boundary >>
 * Class to print the welcome banner.
 */
public final class WelcomeBanner {
    /**
     * Banner to print.
     */
    private static String[] banner = new String[]{
        "    // | |  /__  ___/ // | |  \\ \\/ /   \\ \\/ / ",
        "   //__| |    / /    //__| |   \\/ /     \\/ /    ",
        "  // __| |   / /    / ___  |   / /\\     / /\\    ",
        " //    | |  / /    //    | |  / /\\ \\   / /\\ \\ ",
        "//     | | / /    //     | | / /  \\ \\ / /  \\ \\",
    };
    /**
     * Constructor for WelcomeBanner.
     */
    private WelcomeBanner() { }
    /**
     * Print banner.
     * Print the banner to stdout.
     */
    public static void printBanner() {
        for (String i : banner) {
            System.out.println(i);
        }
        System.out.println("Benvenuti, questo è il gioco del gruppo Thompson!!");
    }
}
