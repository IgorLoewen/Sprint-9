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
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver); // Создаём объект MainPage для использования локаторов и методов
    }

    @Test
    public void testSomeButton() {
        mainPage.clickSomeButton(); // Используем метод из MainPage для нажатия на кнопку
        // Здесь можно добавить утверждения, чтобы проверить результат
    }

    @After
    public void tearDown() {
        driver.quit(); // Завершаем сессию после выполнения теста
    }
}
