// MainPageTest.java в пакете tests
package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        // Инициализация WebDriver и переход на страницу
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void testClickAllQuestionButtons() {
        // Цикл для нажатия на все 8 кнопок
        for (int i = 0; i < 8; i++) {
            mainPage.clickQuestionButton(i); // Нажимаем на каждую кнопку
            // Здесь можно добавить проверки для каждого вопроса, если требуется
        }
    }

    @After
    public void tearDown() {
        // Закрываем браузер после выполнения тестов
        driver.quit();
    }
}
