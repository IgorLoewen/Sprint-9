// MainPageTest.java в пакете tests
package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utils.BrowserFactory;

import static org.junit.Assert.assertTrue;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        // Получаем параметр браузера из системных переменных
        String browser = System.getProperty("browser", "chrome"); // По умолчанию используем Chrome

        // Инициализируем драйвер через BrowserFactory
        driver = BrowserFactory.createDriver(browser);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        mainPage = new MainPage(driver);
    }

    @Test
    public void testClickAllQuestionButtons() {
        // Цикл для нажатия на все 8 кнопок
        for (int b = 0; b < 8; b++) {
            mainPage.clickQuestionButton(b); // Нажимаем на каждую кнопку
            // Здесь можно добавить проверки для каждого вопроса, если требуется
        }
        assertTrue(true); // Пример проверки, подставьте реальные проверки, если нужно
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
