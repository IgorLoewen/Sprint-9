package tests;

import org.junit.Test;
import pages.MainPage;
import static org.junit.Assert.assertEquals;

public class MainPageTest extends TestsSetUp {
    private MainPage mainPage;

    @Test
    public void testClickAllQuestionButtons() {
        mainPage = new MainPage(driver);

        for (int i = 0; i < MainPage.EXPECTED_TEXTS.length; i++) {
            mainPage.clickQuestionButton(i); // Нажимаем на кнопку
            String actualText = mainPage.getAnswerText(i); // Получаем текст ответа
            assertEquals("Текст для вопроса по номеру :" + (i + 1) + " не совпадает с заданным", MainPage.EXPECTED_TEXTS[i], actualText);
        }
        System.out.println("Первый тест прошёл по заданию, все ответы верные! :)");
    }

}
