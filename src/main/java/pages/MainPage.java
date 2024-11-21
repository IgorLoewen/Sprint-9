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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionButton(questionNumber)));
        return driver.findElement(questionButton(questionNumber)).getText();
    }

    // Локатор для логотипа "Самокат"
    public static By scooterLogo = By.xpath("//img[@alt='Scooter']");

    // Локатор для логотипа "Яндекс"
    public static By yandexLogo = By.xpath("//img[@alt='Yandex']");

    // Локатор для кнопки "Статус заказа"
    public static final By STATUS_ORDER_BUTTON = By.xpath("//button[text()='Статус заказа']");

    // Локатор для поля ввода номера заказа
    public static final By ORDER_NUMBER_INPUT = By.xpath("//input[@placeholder='Введите номер заказа']");

    // Локатор для кнопки "Go"
    public static final By GO_BUTTON = By.xpath("/html/body/div/div/div/div[1]/div[3]/button");

    // Локатор для сообщения об отсутствии заказа
    public static final By ORDER_NOT_FOUND_MESSAGE = By.cssSelector("#root > div > div.Track_Content__St6Kn > div.Track_NotFound__6oaoY");


    // Метод для нажатия на кнопку "Статус заказа"
    public void clickStatusOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(STATUS_ORDER_BUTTON))
                .click();
    }

    // Метод для ввода номера заказа в поле
    public void enterOrderNumber(String orderNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_NUMBER_INPUT))
                .sendKeys(orderNumber);
    }

    // Метод для нажатия на кнопку "Go"
    public void clickGoButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(GO_BUTTON))
                .click();
    }

    // Метод для проверки отображения сообщения "Такого заказа нет"
    public boolean isOrderNotFoundMessageVisible() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_NOT_FOUND_MESSAGE))
                .isDisplayed();
    }

}
