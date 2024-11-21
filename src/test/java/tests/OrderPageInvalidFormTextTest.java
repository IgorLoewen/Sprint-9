package tests;

import flows.OrderFlow;
import org.junit.Test;
import pages.OrderPage;

import static org.junit.Assert.assertTrue;

public class OrderPageInvalidTest extends TestsSetUp {

    @Test
    public void testInvalidOrderFormValidation() {
        driver.get(OrderPage.Order_URL);
        OrderFlow orderFlow = new OrderFlow(driver);
        boolean allErrorsVisible = orderFlow.fillOrderFormWithInvalidData();
        assertTrue("Ошибки не отображаются корректно!", allErrorsVisible);
    }
}
