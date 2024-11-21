package tests;

import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class OrderStatusTest extends TestsSetUp {

    @Test // Проверяем ввод неверного номера заказа и отображение сообщения "Такого заказа нет"
    public void testInvalidOrderNumber() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickStatusOrderButton();
        mainPage.enterOrderNumber("ывапывапвпа");
        mainPage.clickGoButton();
        assertTrue(mainPage.isOrderNotFoundMessageVisible());
    }

}
