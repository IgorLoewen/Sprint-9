package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

public class SimpleFirefoxTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver"); // Проверь, что путь верный
        driver = new FirefoxDriver();
    }

    @Test
    public void openAndCheckTitleTest() {
        driver.get("https://example.com"); // Используем страницу, которая точно откроется
        String pageTitle = driver.getTitle(); // Получаем заголовок страницы
        assertEquals("Example Domain", pageTitle); // Проверяем, что заголовок совпадает с ожидаемым
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
