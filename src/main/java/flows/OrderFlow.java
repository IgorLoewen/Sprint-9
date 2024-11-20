package flows;

import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.OrderPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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
        String expectedUrl = OrderPage.Order_URL;
        switch (buttonType) {
            case "UPPER":
                mainPage.clickUpperOrderButton();
                break;
            case "LOWER":
                mainPage.clickLowerOrderButton();
                break;
            default:
                throw new IllegalArgumentException("Некорректный параметр кнопки: " + buttonType);}
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectedUrl));
    }

    // Шаг 2: Заполнить форму заказа
    public boolean fillOrderForm(String name, String surname, String address, String phone, String station, String calendarDate) {
        orderPage.enterName(name);
        orderPage.enterSurname(surname);
        orderPage.enterAddress(address);
        orderPage.enterPhone(phone);
        orderPage.selectStation(station);
        orderPage.clickNextButton();
        orderPage.enterCalendarDate(calendarDate);
        orderPage.selectRentalTermThreeDays();
        orderPage.clickPlaceOrderButton();
        orderPage.clickConfirmOrderButton();
        return orderPage.isOrderConfirmationHeaderVisible();
    }
}
