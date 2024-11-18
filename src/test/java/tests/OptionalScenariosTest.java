package tests;

import data.OrderData;
import flows.OrderFlow;
import org.junit.Test;
import pages.MainPage;
import pages.OptionalScenariosPage;
import static org.junit.Assert.assertEquals;

public class OptionalScenariosTest extends TestsSetUp {
    private MainPage mainPage;
    private OrderFlow orderFlow;

    @Test // Проверяем нажатие кнопки
    public void testClickOrderButton() {
        orderFlow = new OrderFlow(driver);
        mainPage = new MainPage(driver);


        // Используем статический параметр для кнопки
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);

        mainPage.clickButton(OptionalScenariosPage.scooterLogo);

        System.out.println("Дополнительный тест нажатия на логотип 'Самокат' сработал :)");
    }
}