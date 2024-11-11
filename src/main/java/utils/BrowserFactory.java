// BrowserFactory.java в пакете utils
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    public static WebDriver createDriver(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            // Убедитесь, что путь к geckodriver (FirefoxDriver) настроен в PATH
            FirefoxOptions options = new FirefoxOptions();
            return new FirefoxDriver(options);
        } else {
            // Указываем путь к ChromeDriver
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            return new ChromeDriver(options);
        }
    }
}
