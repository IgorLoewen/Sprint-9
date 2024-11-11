// MainPage.java в пакете pages
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Пример локатора для кнопки
    private By someButton = By.id("accordion__heading-0");

    // Метод для нажатия на кнопку
    public void clickSomeButton() {
        driver.findElement(someButton).click();
    }
}
