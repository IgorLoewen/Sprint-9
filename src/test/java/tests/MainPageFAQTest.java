package tests;

import data.FAQData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MainPageFAQTest extends TestsSetUp {

    private final int questionIndex;
    private final String expectedQuestion;
    private final String expectedAnswer;

    public MainPageFAQTest(int questionIndex, String expectedQuestion, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.expectedQuestion = expectedQuestion;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters(name = "Тест на вопрос номер {0}")
    public static Collection<Object[]> testData() {
        return Arrays.stream(FAQData.QUESTIONS)
                .map(question -> new Object[]{
                        Arrays.asList(FAQData.QUESTIONS).indexOf(question),
                        question, // Текст вопроса
                        FAQData.EXPECTED_TEXTS[Arrays.asList(FAQData.QUESTIONS).indexOf(question)]
                })
                .collect(Collectors.toList());
    }

    @Test // Тест на соответствие текста вопросов и ответов
    public void testFAQAnswerAndQuestion() {
        MainPage mainPage = new MainPage(driver);
        assertEquals(expectedQuestion, mainPage.getQuestionText(questionIndex));
        mainPage.clickQuestionButton(questionIndex);
        assertEquals(expectedAnswer, mainPage.getAnswerText(questionIndex));
    }

}
