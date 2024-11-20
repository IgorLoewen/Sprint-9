package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MainPageFAQTest extends TestsSetUp {

    private final int questionIndex;
    private final String expectedAnswer;

    public MainPageFAQTest(int questionIndex, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters(name = "Тест на вопрос номер {0}")
    public static Object[][] testData() {
        Object[][] data = new Object[MainPage.EXPECTED_TEXTS.length][2];
        for (int i = 0; i < MainPage.EXPECTED_TEXTS.length; i++) {
            data[i][0] = i;
            data[i][1] = MainPage.EXPECTED_TEXTS[i];
        }
        return data;
    }

    @Test
    public void testFAQAnswer() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickQuestionButton(questionIndex);
        String actualAnswer = mainPage.getAnswerText(questionIndex);
        assertEquals("Текст ответа для вопроса " + (questionIndex + 1) + " не совпадает с ожидаемым",
                expectedAnswer, actualAnswer);
    }
}
