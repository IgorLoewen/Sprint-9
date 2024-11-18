package tests;

import data.OrderData;
import flows.OrderFlow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageTest extends TestsSetUp {

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String station;

    private OrderFlow orderFlow;

    // Конструктор для параметров
    public OrderPageTest(String name, String surname, String address, String phone, String station) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.station = station;
    }

    // Динамическое управление выбором массива параметров
    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Collection<Object[]> testData() {
        // Берём все массивы из OrderData.TEST_DATA
        return Arrays.asList(OrderData.TEST_DATA.toArray(new Object[0][]));
    }

    @Test // Проверяем нажатие кнопки
    public void testClickOrderButton() {
        orderFlow = new OrderFlow(driver);

        // Используем статический параметр для кнопки
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);
        System.out.println("Тест номер 2 для кнопки 'Заказать' сработал :)");
    }

    @Test // Заполняем форму заказа
    public void testFillOrderForm() {
        orderFlow = new OrderFlow(driver);

        // Используем статический параметр для кнопки
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);

        // Заполняем форму с использованием параметров из массива
        orderFlow.fillOrderForm(name, surname, address, phone, station, OrderData.CALENDAR_DATE);
        System.out.println("Тест формы заказа номер 3 сработал тоже успешно :)");
    }

    @Test // Проверяем всплывающее окно
    public void testOrderConfirmation() {
        orderFlow = new OrderFlow(driver);

        // Используем статический параметр для кнопки
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);

        // Заполняем форму с использованием параметров из массива
        orderFlow.fillOrderForm(name, surname, address, phone, station, OrderData.CALENDAR_DATE);

        // Проверяем видимость всплывающего окна
        boolean isVisible = orderFlow.isOrderConfirmationVisible();
        assertTrue("Всплывающее окно не появилось!", isVisible);
        System.out.println("Тест о завершении удачного заказа номер 4 сработал тоже на Ура :)");
    }
}
