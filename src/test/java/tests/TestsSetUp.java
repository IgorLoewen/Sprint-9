// TestsSetUp.java в пакете tests
package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserChoose;

import java.time.Duration;

public class TestsSetUp {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        // Получаем параметр браузера из системных переменных
        String browser = System.getProperty("browser", "chrome");
        // Команда для запуска с Firefox: "mvn test -Dbrowser=firefox"
        // Или можно указать браузер напрямую, если не передавать параметр

        // Инициализация WebDriver с выбранным браузером
        driver = BrowserChoose.createDriver(browser);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Инициализация WebDriverWait для управления явными ожиданиями
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
