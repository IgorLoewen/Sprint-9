package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    // ========================= Константы =========================
    // Статическая переменная для базового URL
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    // ========================= Конструктор =========================
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // ========================= Локаторы =========================
    // Кнопки "Заказать"
    private static final By upperOrderButton = By.xpath("(//button[contains(@class, 'Button_Button__ra12g')])[1]");
    private static final By lowerOrderButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");



    // Локаторы FAQ
    private static By questionButton(int questionIndex) {
        return By.id("accordion__heading-" + questionIndex);
    }

    private static By answerLocator(int questionIndex) {
        return By.id("accordion__panel-" + questionIndex);
    }

    // Логотипы
    public static final By scooterLogo = By.xpath("//img[@alt='Scooter']");
    public static final By yandexLogo = By.xpath("//img[@alt='Yandex']");

    // Локаторы статуса заказа
    public static final By STATUS_ORDER_BUTTON = By.xpath("//button[text()='Статус заказа']");
    public static final By ORDER_NUMBER_INPUT = By.xpath("//input[@placeholder='Введите номер заказа']");
    public static final By GO_BUTTON = By.xpath("//button[text()='Go!']");
    public static final By ORDER_NOT_FOUND_MESSAGE = By.xpath("//div[contains(@class, 'Track_Content__St6Kn')]//div[contains(@class, 'Track_NotFound__6oaoY')]");

    // ========================= Методы =========================

    // ---------- Общие методы ----------
    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    public void clickButton(By locator) {
        scrollToElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    // ---------- Методы для кнопок "Заказать" ----------
    public void clickUpperOrderButton() {
        clickButton(upperOrderButton);
    }

    public void clickLowerOrderButton() {
        clickButton(lowerOrderButton);
    }

    // ---------- Методы для FAQ ----------
    public void clickQuestionButton(int questionNumber) {
        clickButton(questionButton(questionNumber));
    }

    public String getAnswerText(int questionNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator(questionNumber)));
        return driver.findElement(answerLocator(questionNumber)).getText();
    }

    public String getQuestionText(int questionNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionButton(questionNumber)));
        return driver.findElement(questionButton(questionNumber)).getText();
    }

    // ---------- Методы для статуса заказа ----------
    public void clickStatusOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(STATUS_ORDER_BUTTON))
                .click();
    }

    public void enterOrderNumber(String orderNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_NUMBER_INPUT))
                .sendKeys(orderNumber);
    }

    public void clickGoButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(GO_BUTTON))
                .click();
    }

    public boolean isOrderNotFoundMessageVisible() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_NOT_FOUND_MESSAGE))
                .isDisplayed();
    }
}
