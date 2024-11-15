// MainPage.java в пакете pages
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы для кнопок "Заказать"
    private By upperOrderButton = By.xpath("(//button[contains(@class, 'Button_Button__ra12g')])[1]");
    // Верхняя кнопка "Заказать" - Локатор: XPath первого элемента с классом "Button_Button__ra12g"

    private By lowerOrderButton = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");
    // Нижняя кнопка "Заказать" - Локатор: XPath элемента с точным адресом


    // Метод для прокрутки к элементу
    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    // Универсальный метод для клика по кнопке
    public void clickButton(By locator) {
        // Прокрутка к элементу перед кликом
        scrollToElement(locator);

        // Ожидание кликабельности кнопки
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        // Клик по кнопке
        driver.findElement(locator).click();
    }

    // Метод для клика по кнопкам вопросов в цикле
    public void clickQuestionButton(int buttonNumber) {
        By questionButton = By.id("accordion__heading-" + buttonNumber);
        clickButton(questionButton);
    }

    // Метод для клика по верхней кнопке "Заказать"
    public void clickUpperOrderButton() {
        clickButton(upperOrderButton);
    }

    // Метод для клика по нижней кнопке "Заказать"
    public void clickLowerOrderButton() {
        clickButton(lowerOrderButton);
    }

    // Метод для получения текста ответа на вопрос
    public String getAnswerText(int questionNumber) {
        By answerLocator = By.id("accordion__panel-" + questionNumber);

        // Ожидание видимости текста
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));

        // Возвращаем текст ответа
        return driver.findElement(answerLocator).getText();
    }
}
