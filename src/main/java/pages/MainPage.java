// MainPage.java в пакете pages
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы для кнопок вопросов в разделе "Вопросы о важном"

    // Кнопка "Сколько это стоит? И как оплатить?"
    private By priceAndPaymentButton = By.id("accordion__heading-0");

    // Кнопка "Хочу сразу несколько самокатов! Так можно?"
    private By multipleScootersButton = By.id("accordion__heading-1");

    // Кнопка "Как рассчитывается время аренды?"
    private By rentalTimeButton = By.id("accordion__heading-2");

    // Кнопка "Можно ли заказать самокат прямо на сегодня?"
    private By orderForTodayButton = By.id("accordion__heading-3");

    // Кнопка "Можно ли продлить заказ или вернуть самокат раньше?"
    private By extendOrReturnButton = By.id("accordion__heading-4");

    // Кнопка "Вы привозите зарядку вместе с самокатом?"
    private By chargerIncludedButton = By.id("accordion__heading-5");

    // Кнопка "Можно ли отменить заказ?"
    private By cancelOrderButton = By.id("accordion__heading-6");

    // Кнопка "Я живу за МКАДом, привезёте?"
    private By outsideMKADDeliveryButton = By.id("accordion__heading-7");

    // Универсальный метод для нажатия на любую кнопку по её номеру (от 0 до 7)
    public void clickQuestionButton(int buttonNumber) {
        By questionButton = By.id("accordion__heading-" + buttonNumber);
        driver.findElement(questionButton).click();
    }
}
