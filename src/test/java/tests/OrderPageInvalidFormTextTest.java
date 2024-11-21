package tests;

import flows.OrderFlow;
import org.junit.Test;
import pages.OrderPage;

import static org.junit.Assert.assertTrue;

public class OrderPageInvalidFormTextTest extends TestsSetUp {

    @Test // Проверка ошибок для всех полей формы заказа
    public void testInvalidOrderFormValidation() {
        driver.get(OrderPage.Order_URL);
        OrderFlow orderFlow = new OrderFlow(driver);
        assertTrue(orderFlow.fillOrderFormWithInvalidData());
    }

}
