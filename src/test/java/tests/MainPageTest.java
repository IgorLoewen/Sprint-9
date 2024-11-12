// MainPageTest.java в пакете tests
package tests;

import org.junit.Test;
import pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class MainPageTest extends TestsSetUp { // Наследуем TestsSetUp для использования общих настроек
    private MainPage mainPage;

    @Test
    public void testClickAllQuestionButtons() {
        mainPage = new MainPage(driver);

        // Ожидаемые тексты для каждого вопроса
        String[] expectedTexts = {
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области."
        };

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
}
