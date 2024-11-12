// TestsSetUp.java в пакете tests
package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.BrowserChoose;

public class TestsSetUp {
    protected WebDriver driver;

    @Before
    public void setUp() {
        // Получаем параметр браузера из системных переменных
        String browser = System.getProperty("browser", "chrome");
        // Команда для запуска с Firefox: "mvn test -Dbrowser=firefox"
        // Или можно указать браузер напрямую, если не передавать параметр

        // Инициализация WebDriver с выбранным браузером
        driver = BrowserChoose.createDriver(browser);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
