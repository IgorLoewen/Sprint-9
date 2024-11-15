// OrderPage.java в пакете pages
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    // Конструктор
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    // Локатор для поля "Имя"
    public By nameField = By.cssSelector("input[type='text'][placeholder='* Имя']");


    // Метод для ввода данных в поля
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);


    }
}