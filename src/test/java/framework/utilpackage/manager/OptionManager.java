package framework.utilpackage.manager;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {

    private static final ChromeOptions chromeOptions = new ChromeOptions();
    private static final EdgeOptions edgeOptions = new EdgeOptions();
    private static final FirefoxOptions firefoxOptions = new FirefoxOptions();

    public static ChromeOptions getChromeOptions() {
        return chromeOptions;
    }

    public static EdgeOptions getEdgeOptions() {
        return edgeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        return firefoxOptions;
    }

    public static void setSizeWindowChrome(int width, int height) {
        chromeOptions.addArguments(String.format("Window-size=%d,%d", width, height));
        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    }

    public static void setSizeWindowEdge(int width, int height) {
        edgeOptions.addArguments(String.format("Window-size=%d,%d", width, height));
        edgeOptions.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
    }

    public static void setSizeWindowFireFox(int width, int height) {
        firefoxOptions.addArguments(String.format("Window-size=%d,%d", width, height));
        firefoxOptions.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
    }
}
