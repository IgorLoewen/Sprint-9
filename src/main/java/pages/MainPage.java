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
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru";


    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Ожидаемые тексты ответов на вопросы
    public static final String[] EXPECTED_TEXTS = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

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
}
