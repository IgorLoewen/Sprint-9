package flows;

import data.OrderData;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.OrderPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;

public class OrderFlow {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;

    // Конструктор
    public OrderFlow(WebDriver driver) {
        this.driver = driver;
        this.mainPage = new MainPage(driver);
        this.orderPage = new OrderPage(driver);
    }

    // Шаг 1: Нажать на кнопку "Заказать" и проверить URL
    public void clickOrderButton(String buttonType) {
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/order"; // Ожидаемый URL

        // Нажимаем на кнопку в зависимости от типа
        if (buttonType.equals("UPPER")) {
            mainPage.clickUpperOrderButton(); // Нажимаем верхнюю кнопку
            System.out.println("Нажата верхняя кнопка 'Заказать'.");
        } else if (buttonType.equals("LOWER")) {
            mainPage.clickLowerOrderButton(); // Нажимаем нижнюю кнопку
            System.out.println("Нажата нижняя кнопка 'Заказать'.");
        } else {
            throw new IllegalArgumentException("Некорректный параметр кнопки: " + buttonType);
        }

        // Проверяем, что текущий URL соответствует ожидаемому
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ожидание до 10 секунд
        try {
            wait.until(ExpectedConditions.urlToBe(expectedUrl));
            System.out.println("Успешный переход на URL: " + expectedUrl);
        } catch (TimeoutException e) {
            throw new AssertionError("Переход на URL '" + expectedUrl + "' не выполнен. Текущий URL: " + driver.getCurrentUrl());
        }
    }

    // Шаг 2: Заполнить форму заказа
    public void fillOrderForm(String name, String surname, String address, String phone, String station, String calendarDate) {
        orderPage.enterName(name);
        orderPage.enterSurname(surname);
        orderPage.enterAddress(address);
        orderPage.enterPhone(phone);
        orderPage.selectStation(station);
        orderPage.clickNextButton();
        orderPage.enterCalendarDate(calendarDate);
        orderPage.selectRentalTermThreeDays(); // Срок аренды остаётся статическим
        orderPage.clickPlaceOrderButton();
        orderPage.clickConfirmOrderButton();
        System.out.println("Форма заказа полностью заполнена.");
    }

    // Шаг 3: Проверить всплывающее окно
    public boolean isOrderConfirmationVisible() {
        return orderPage.isOrderConfirmationHeaderVisible();
    }
}
