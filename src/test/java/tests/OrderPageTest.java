package tests;

import data.OrderData;
import flows.OrderFlow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageTest extends TestsSetUp {

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String station;
    private final String calendarDate;
    private final String buttonType;

    private OrderFlow orderFlow;

    public OrderPageTest(String name, String surname, String address, String phone, String station, String calendarDate, String buttonType) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.station = station;
        this.calendarDate = calendarDate;
        this.buttonType = buttonType;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(OrderData.TEST_DATA.toArray(new Object[0][]));
    }

    @Test // Проверяем нажатие кнопки
    public void testClickOrderButton() {
        orderFlow = new OrderFlow(driver);
        orderFlow.clickOrderButton(buttonType);
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/order";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean urlIsCorrect = wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assertTrue("URL не соответствует ожидаемому после нажатия на кнопку", urlIsCorrect);
    }

    @Test // Проверяем флоу заказа
    public void testFillOrderForm() {
        orderFlow = new OrderFlow(driver);
        orderFlow.clickOrderButton(buttonType);
        boolean isOrderCompleted = orderFlow.fillOrderForm(name, surname, address, phone, station, calendarDate);
        assertTrue("Заказ не завершился успешно!", isOrderCompleted);
    }
}
