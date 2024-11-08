package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class SimpleFirefoxTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver"); // Убедитесь, что путь к geckodriver верный
        driver = new FirefoxDriver();
    }

    @Test
    public void openPageAndCheckTitle() {
        driver.get("https://www.example.com");
        String title = driver.getTitle();
        assertEquals("Example Domain", title);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
