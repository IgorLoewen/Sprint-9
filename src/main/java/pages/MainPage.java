package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    // Статическая переменная для базового URL
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы для верхней и нижней кнопок ЗАКАЗАТЬ
    private By upperOrderButton = By.xpath("(//button[contains(@class, 'Button_Button__ra12g')])[1]");
    private By lowerOrderButton = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");

    // Локатор для кнопки вопроса по индексу
    private By questionButton(int questionIndex) {
        return By.id("accordion__heading-" + questionIndex);
    }

    // Локатор для текстов ответов FAQ
    private By answerLocator(int questionIndex) {
        return By.id("accordion__panel-" + questionIndex);
    }

    // Метод для прокрутки к элементу
    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    // Универсальный метод для клика по кнопке
    public void clickButton(By locator) {
        scrollToElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    // Методы для клика по кнопкам "Заказать"
    public void clickUpperOrderButton() {
        clickButton(upperOrderButton);
    }

    public void clickLowerOrderButton() {
        clickButton(lowerOrderButton);
    }

    // Метод для клика по кнопке вопроса
    public void clickQuestionButton(int questionNumber) {
        clickButton(questionButton(questionNumber));
    }

    // Метод для получения текста ответа на вопрос
    public String getAnswerText(int questionNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator(questionNumber)));
        return driver.findElement(answerLocator(questionNumber)).getText();
    }

    // Метод для получения текста вопроса
    public String getQuestionText(int questionNumber) {
        // Ожидание видимости кнопки вопроса перед получением текста
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionButton(questionNumber)));
        return driver.findElement(questionButton(questionNumber)).getText();
    }

    // Локатор для логотипа "Самокат"
    public static By scooterLogo = By.xpath("//img[@alt='Scooter']");
}
