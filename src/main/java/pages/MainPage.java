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

    // Локаторы для кнопок вопросов в разделе "Вопросы о важном"

    private By priceAndPaymentButton = By.id("accordion__heading-0");
    // Кнопка "Сколько это стоит? И как оплатить?" - Локатор: ID элемента "accordion__heading-0"

    private By multipleScootersButton = By.id("accordion__heading-1");
    // Кнопка "Хочу сразу несколько самокатов! Так можно?" - Локатор: ID элемента "accordion__heading-1"

    private By rentalTimeButton = By.id("accordion__heading-2");
    // Кнопка "Как рассчитывается время аренды?" - Локатор: ID элемента "accordion__heading-2"

    private By orderForTodayButton = By.id("accordion__heading-3");
    // Кнопка "Можно ли заказать самокат прямо на сегодня?" - Локатор: ID элемента "accordion__heading-3"

    private By extendOrReturnButton = By.id("accordion__heading-4");
    // Кнопка "Можно ли продлить заказ или вернуть самокат раньше?" - Локатор: ID элемента "accordion__heading-4"

    private By chargerIncludedButton = By.id("accordion__heading-5");
    // Кнопка "Вы привозите зарядку вместе с самокатом?" - Локатор: ID элемента "accordion__heading-5"

    private By cancelOrderButton = By.id("accordion__heading-6");
    // Кнопка "Можно ли отменить заказ?" - Локатор: ID элемента "accordion__heading-6"

    private By outsideMKADDeliveryButton = By.id("accordion__heading-7");
    // Кнопка "Я живу за МКАДом, привезёте?" - Локатор: ID элемента "accordion__heading-7"

    // Метод для прокрутки к элементу
    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    // Универсальный метод для нажатия на любую кнопку по её номеру (от 0 до 7)
    public void clickQuestionButton(int buttonNumber) {
        By questionButton = By.id("accordion__heading-" + buttonNumber);

        // Прокрутка к элементу перед кликом
        scrollToElement(questionButton);

        // Явное ожидание, пока элемент не станет видимым и кликабельным
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionButton));
        wait.until(ExpectedConditions.elementToBeClickable(questionButton));

        // Клик по элементу
        driver.findElement(questionButton).click();


    }


}
