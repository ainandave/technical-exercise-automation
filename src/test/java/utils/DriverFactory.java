package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = ConfigReader.getBrowser();
        boolean headless = ConfigReader.isHeadless();

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }

                driver.set(new ChromeDriver(chromeOptions));
                driver.get().manage().window().setSize(new Dimension(1920, 1080));

                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }

                driver.set(new FirefoxDriver(firefoxOptions));
                driver.get().manage().window().setSize(new Dimension(1920, 1080));

                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
