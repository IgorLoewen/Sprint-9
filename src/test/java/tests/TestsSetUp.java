package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserChoose;
import java.time.Duration;
import pages.MainPage;

public class TestsSetUp {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = BrowserChoose.createDriver(browser);
        driver.get(MainPage.BASE_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
