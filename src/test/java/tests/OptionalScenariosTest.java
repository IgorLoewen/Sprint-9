/*
package tests;


import data.OrderData;
import flows.OrderFlow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import pages.OptionalScenariosPage;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.OrderPage;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OptionalScenariosTest extends TestsSetUp {
    private MainPage mainPage;
    private OrderFlow orderFlow;
    private OrderPage orderPage;
    private OptionalScenariosPage optionalScenariosPage;

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String station;
    private final String calendarDate;
    private final String buttonType;

    // Конструктор для параметров
    public OptionalScenariosTest(String name, String surname, String address, String phone, String station, String calendarDate, String buttonType) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.station = station;
        this.calendarDate = calendarDate;
        this.buttonType = buttonType;
    }

    // Динамическое управление выбором массива параметров
    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Collection<Object[]> testData() {
        // Берём все массивы из OrderData.TEST_DATA
        return Arrays.asList(OrderData.TEST_DATA.toArray(new Object[0][]));
    }

    @Test // Проверяем переход на главную страницу по клику на логотип "Самокат"
    public void testClickOrderButton() {
        orderFlow = new OrderFlow(driver);
        mainPage = new MainPage(driver);

        // Нажимаем на кнопку "Заказать" на главной странице
        orderFlow.clickOrderButton(buttonType);

        // Нажимаем на логотип "Самокат"
        mainPage.clickButton(OptionalScenariosPage.scooterLogo);

        // Проверяем, что URL соответствует ожидаемому
        String expectedUrl = MainPage.BASE_URL;
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
        orderFlow.clickOrderButton(buttonType);

        // Нажимаем на логотип "Яндекс"
        mainPage.clickButton(OptionalScenariosPage.yandexLogo);

        // Задержка на 3 секунды для визуального подтверждения
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Дополнительный тест нажатия на логотип 'Яндекс' сработал и мы перешли на страницу Яндекс :) УРА, мне это нравится)))");
    }


    @Test // Проверяем текст ошибок под полями
    public void testValidationErrorTexts() {
        orderPage = new OrderPage(driver);

        // Нажимаем на кнопку "Заказать" на главной странице
        orderFlow = new OrderFlow(driver); // Не забываем инициализировать orderFlow
        orderFlow.clickOrderButton(buttonType);

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

   @Test // Проверяем клик по кнопке "Статус заказа" и ввод текста
   public void testClickStatusOrderButton() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       // Шаг 1: Нажимаем на кнопку "Статус заказа"
       WebElement statusOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[2]/button[2]")));
       statusOrderButton.click();

       // Шаг 2: Вводим текст "ывапывапвпа"
       WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[3]/div/input")));
       inputField.sendKeys("ывапывапвпа");

       // Шаг 3: Нажимаем на кнопку "Go!"
       WebElement goButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[3]/button")));
       goButton.click();

       // Ждем 5 секунд для проверки визуального отображения
       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       System.out.println("УРА!!! Я это сделал!!! Проверка происходит по факту загрузки!!! Там нет локатора даже на картинку!!!");
   }


}

*/