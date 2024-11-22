package tests;

import flows.OrderFlow;
import org.junit.Test;
import pages.OrderPage;

import static org.junit.Assert.assertTrue;

public class OrderPageInvalidFormTextTest extends TestsSetUp {

    @Test // Проверка ошибки для имени
    public void testNameErrorVisible() {
        driver.get(OrderPage.Order_URL);
        OrderFlow orderFlow = new OrderFlow(driver);
        assertTrue("Ошибка имени не отображается!", orderFlow.isNameErrorVisible());
    }

    @Test // Проверка ошибки для фамилии
    public void testSurnameErrorVisible() {
        driver.get(OrderPage.Order_URL);
        OrderFlow orderFlow = new OrderFlow(driver);
        assertTrue("Ошибка фамилии не отображается!", orderFlow.isSurnameErrorVisible());
    }

    @Test // Проверка ошибки для адреса
    public void testAddressErrorVisible() {
        driver.get(OrderPage.Order_URL);
        OrderFlow orderFlow = new OrderFlow(driver);
        assertTrue("Ошибка адреса не отображается!", orderFlow.isAddressErrorVisible());
    }

    @Test // Проверка ошибки для телефона
    public void testPhoneErrorVisible() {
        driver.get(OrderPage.Order_URL);
        OrderFlow orderFlow = new OrderFlow(driver);
        assertTrue("Ошибка телефона не отображается!", orderFlow.isPhoneErrorVisible());
    }


}
