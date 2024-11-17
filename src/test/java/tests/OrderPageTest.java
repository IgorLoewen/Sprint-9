package tests;

import data.OrderData;
import flows.OrderFlow;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class OrderPageTest extends TestsSetUp {

    private OrderFlow orderFlow;

    @Test
    public void testClickOrderButton() {
        // Тест проверки кнопок "Заказать"
        orderFlow = new OrderFlow(driver);
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);
        System.out.println("Тест кнопки 'Заказать' завершён.");
    }

    @Test
    public void testFillOrderForm(){
        // Тест заполнения формы заказа
        orderFlow = new OrderFlow(driver);

        // Нажимаем на кнопку заказать..
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);

        // Заполняем форму заказа
        orderFlow.fillOrderForm();
        System.out.println("Тест заполнения формы заказа завершён.");
    }

    @Test
    public void testOrderConfirmation() {
        // Тест проверки полного флоу с подтверждением
        orderFlow = new OrderFlow(driver);

        // Нажимаем на кнопку "Заказать"
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);

        // Заполняем форму заказа
        orderFlow.fillOrderForm();

        // Проверяем всплывающее окно
        boolean isVisible = orderFlow.isOrderConfirmationVisible();
        assertTrue("Всплывающее окно не появилось!", isVisible);
        System.out.println("Тест всплывающего окна завершён.");
    }

   /* @Test
    public void testClickUpperOrderButton() {
        orderPage = new OrderPage(driver);
        mainPage = new MainPage(driver);

        // Нажимаем на верхнюю кнопку "Заказать"
        mainPage.clickUpperOrderButton();
        // Нажимаем на нижнюю кнопку "Заказать" - можно подключать через удаление
        //перед строкой вызова следующего метода, но тогда метод выше надо отключить.
        // только одна их кнопок за флоу должна работать!
        // mainPage.clickLowerOrderButton();


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
        orderPage.clickPlaceOrderButton();

        orderPage.clickConfirmOrderButton();

        orderPage.isOrderConfirmationHeaderVisible();

    } */
}