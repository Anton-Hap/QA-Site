package framework.driverpackage;

import framework.utilpackage.manager.OptionManager;
import framework.utilpackage.logger.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import framework.utilpackage.manager.ConfigManager;

public class BrowserFactory {

    public static WebDriver createDriver() {
        switch (ConfigManager.getBrowser()) {
            case "Chrome" -> {
                Log.getLogger().info("ChromeDriver was created");
                WebDriverManager.chromedriver().setup();
                OptionManager.setSizeWindowChrome(ConfigManager.getWidthWindow(), ConfigManager.getHeightWindow());
                return new ChromeDriver(OptionManager.getChromeOptions());
            }
            case "Edge" -> {
                Log.getLogger().info("EdgeDriver was created");
                WebDriverManager.edgedriver().setup();
                OptionManager.setSizeWindowEdge(ConfigManager.getWidthWindow(), ConfigManager.getHeightWindow());
                return new EdgeDriver(OptionManager.getEdgeOptions());
            }
            case "FireFox" -> {
                Log.getLogger().info("FireFoxDriver was created");
                WebDriverManager.firefoxdriver().setup();
                OptionManager.setSizeWindowFireFox(ConfigManager.getWidthWindow(), ConfigManager.getHeightWindow());
                return new FirefoxDriver(OptionManager.getFirefoxOptions());
            }
            default -> {
                throw new RuntimeException(ConfigManager.getBrowser() + " is unknown browser");
            }
        }
    }
}
