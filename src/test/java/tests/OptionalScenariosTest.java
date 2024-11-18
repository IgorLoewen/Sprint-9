package tests;

import data.OrderData;
import flows.OrderFlow;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import pages.OptionalScenariosPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.ui.WebDriverWait;
import pages.OrderPage;

import java.time.Duration;

public class OptionalScenariosTest extends TestsSetUp {
    private MainPage mainPage;
    private OrderFlow orderFlow;
    private OrderPage orderPage;
    private OptionalScenariosPage optionalScenariosPage;

  /*  @Test // Проверяем переход на главную страницу по клику на логотип "Самокат"
    public void testClickOrderButton() {
        orderFlow = new OrderFlow(driver);
        mainPage = new MainPage(driver);

        // Нажимаем на кнопку "Заказать" на главной странице
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);

        // Нажимаем на логотип "Самокат"
        mainPage.clickButton(OptionalScenariosPage.scooterLogo);

        // Проверяем, что URL соответствует ожидаемому
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        // Проверяем, что текущий URL соответствует ожидаемому
        String actualUrl = driver.getCurrentUrl();
        assertEquals("После нажатия на логотип 'Самокат' не произошел переход на ожидаемую страницу!", expectedUrl, actualUrl);

        System.out.println("Дополнительный тест нажатия на логотип 'Самокат' сработал и мы перешли на главную страницу Самоката :)");
    }

    @Test // Проверяем переход на страницу "Яндекс" по клику на логотип
    public void testClickYandexLogo() {
        orderFlow = new OrderFlow(driver);
        mainPage = new MainPage(driver);

        // Нажимаем на кнопку "Заказать" на главной странице
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);

        // Нажимаем на логотип "Яндекс"
        mainPage.clickButton(OptionalScenariosPage.yandexLogo);

        // Задержка на 3 секунды для визуального подтверждения
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Дополнительный тест нажатия на логотип 'Яндекс' сработал и мы перешли на страницу Яндекс :) УРА, мне это нравится)))");
    } */


    @Test // Проверяем текст ошибок под полями
    public void testValidationErrorTexts() {
        orderPage = new OrderPage(driver);

        // Нажимаем на кнопку "Заказать" на главной странице
        orderFlow = new OrderFlow(driver); // Не забываем инициализировать orderFlow
        orderFlow.clickOrderButton(OrderData.ORDER_BUTTON);

        // Вводим невалидные данные
        orderPage.enterName("5645674567");
        orderPage.enterSurname("6e57767");
        orderPage.enterAddress("56766755674745eurhdfghtdfgh");
        orderPage.enterPhone("5675677567");

        // Нажимаем "Далее" для отображения ошибок
        orderPage.clickNextButton();

        // Проверяем тексты ошибок
        assertEquals("Введите корректное имя", OptionalScenariosPage.getNameErrorText(driver));
        assertEquals("Введите корректную фамилию", OptionalScenariosPage.getSurnameErrorText(driver));
        assertEquals("Введите корректный адрес", OptionalScenariosPage.getAddressErrorText(driver));
        assertEquals("Введите корректный номер", OptionalScenariosPage.getPhoneErrorText(driver));

        System.out.println("Тест на проверку текстов ошибок выполнен зачётнО :) !");
    }


}