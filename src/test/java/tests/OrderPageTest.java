package tests;

import org.junit.Test;
import pages.MainPage;
import pages.OrderPage;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPageTest extends TestsSetUp {
    private MainPage mainPage;
    private OrderPage orderPage;

    @Test
    public void testClickUpperOrderButton() {
        orderPage = new OrderPage(driver);
        mainPage = new MainPage(driver);

        // Нажимаем на верхнюю кнопку "Заказать"
        mainPage.clickUpperOrderButton();

        // Проверяем, что поле "Имя" появляется и вводим имя
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderPage.nameField));
        orderPage.enterName("Test Name");
    }
}
