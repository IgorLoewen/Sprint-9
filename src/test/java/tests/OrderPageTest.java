package tests;

import data.OrderData;
import flows.OrderFlow;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class OrderPageTest extends TestsSetUp {

    private OrderFlow orderFlow;

    @Test//Задание 2. Часть первая ... Нажать кнопку «Заказать». На странице две кнопки заказа.
    public void testClickOrderButton() {
        // Тест проверки кнопок "Заказать"
        orderFlow = new OrderFlow(driver);
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);
        System.out.println("Тест кнопки 'Заказать' завершён.");
    }

    @Test//Задание 2. Часть вторая ... Заполнить форму заказа.
    public void testFillOrderForm(){
        // Тест заполнения формы заказа
        orderFlow = new OrderFlow(driver);

        // Нажимаем на кнопку заказать..
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);

        // Заполняем форму заказа
        orderFlow.fillOrderForm();
        System.out.println("Тест заполнения формы заказа завершён.");
    }

    @Test//Задание 2. Часть третяя ... Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.
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
}