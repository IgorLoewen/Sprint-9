package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserChoose {

    public static WebDriver createDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            FirefoxOptions options = new FirefoxOptions();
            return new FirefoxDriver(options);
        } else {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-features=FederatedCredentialManagement");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-gpu");
            return new ChromeDriver(options);
        }
    }
}