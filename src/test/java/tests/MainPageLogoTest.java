package tests;

import org.junit.Test;
import pages.OrderPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MainPageLogoTest extends TestsSetUp {

    @Test // Тестирование перехода на главную страницу, при нажатии на логотип Самоката
    public void testClickLogoSamokat() {
        driver.get(OrderPage.Order_URL);
        new MainPage(driver).clickButton(MainPage.scooterLogo);
        assertEquals(MainPage.BASE_URL, driver.getCurrentUrl());
    }

    @Test// Тестирование перехода на главную страницу Яндекса, при нажатии на логотип Яндекса
    public void testClickLogoYandex() {
        driver.get(OrderPage.Order_URL);
        new MainPage(driver).clickButton(MainPage.yandexLogo);
        String newWindow = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(newWindow);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(driver -> driver.getCurrentUrl().equals("https://dzen.ru/?yredirect=true"));
        assertEquals("https://dzen.ru/?yredirect=true", driver.getCurrentUrl());
    }









}
