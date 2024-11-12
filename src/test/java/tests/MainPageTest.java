// MainPageTest.java в пакете tests
package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utils.BrowserChoose;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        // Получаем параметр браузера из системных переменных
        // "mvn test -Dbrowser=firefox" - команда для запуска firefox через терминал!
        // или же можно поменять название браузера прям тут для старта!
        // Синтаксис: System.getProperty(String key, String defaultValue)!

        // Инициализируем драйвер через BrowserChoose
        driver = BrowserChoose.createDriver(browser);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        mainPage = new MainPage(driver);
    }

    @Test
    public void testClickAllQuestionButtons() {
        // Массив ожидаемых текстов для каждого вопроса
        String[] expectedTexts = {
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", // Замените на фактический текст
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области."
        };

        // Цикл для нажатия на все 8 кнопок и проверки текста
        for (int b = 0; b < 8; b++) {
            mainPage.clickQuestionButton(b); // Нажимаем на кнопку

            // Локатор для текста, который появляется после раскрытия
            By answerTextLocator = By.id("accordion__panel-" + b);

            // Явное ожидание для отображения текста
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(answerTextLocator));

            // Получаем текст ответа и сравниваем с ожидаемым
            String actualText = driver.findElement(answerTextLocator).getText();
            assertEquals("Текст для вопроса " + (b + 1) + " не совпадает", expectedTexts[b], actualText);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
