package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.OrderPage;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class OrderPageTest extends TestsSetUp {
    private MainPage mainPage;
    private OrderPage orderPage;

    @Test
    public void testClickUpperOrderButton() {
        orderPage = new OrderPage(driver);
        mainPage = new MainPage(driver);

        // Нажимаем на верхнюю кнопку "Заказать"
        mainPage.clickUpperOrderButton();
                  // Нажимаем на нижнюю кнопку "Заказать" - можно подключать через удаление
         //перед строкой вызова следующего метода, но тогда метод выше надо отключить.
                   // только одна их кнопок за флоу должна работать!
        //mainPage.clickLowerOrderButton();


        // Делаем ввод в поле имя после явного появления элемента
        //wait.until(ExpectedConditions.visibilityOfElementLocated(orderPage.phoneField));
        orderPage.enterName("Игорь");
        orderPage.enterSurname("Лёвэн");
        orderPage.enterAddress("вапыпыавыаыва");
        orderPage.enterPhone("245624563546");
        orderPage.selectStation("Сокольники");
        orderPage.clickNextButton();

        orderPage.enterCalendarDate("5");
        orderPage.selectRentalTermThreeDays();
       // orderPage.clickOrderButton();

       // orderPage.clickConfirmOrderButton();


    }
}
