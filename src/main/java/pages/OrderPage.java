// OrderPage.java в пакете pages
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    // Конструктор
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор для поля "Имя"
    private By nameField = By.className("Input_Input__1iN_Z Input_Error__1Tx5d Input_Responsible__1jDKN");

    // Локатор для поля "Фамилия"
    private By lastNameField = By.className("Input_Input__1iN_Z Input_Responsible__1jDKN");

    // Локатор для поля "Адрес"
    private By addressField = By.className("Input_Input__1iN_Z Input_Responsible__1jDKN");

    // Локатор для поля "Станция метро"
    private By metroStationField = By.className("select-search__input");

    // Локатор для поля "Телефон"
    private By phoneField = By.xpath("//input[@name='* Телефон: на него позвонит курьер']");

    // Локатор для кнопки "Далее"
    private By nextButton = By.className("Button_Button__ra12g.Button_Middle__1CSJM");

    // Метод для ввода данных в поля
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    // Метод для выбора станции метро
    public void selectMetroStation(String stationName) {
        driver.findElement(metroStationField).click(); // Открываем выпадающий список
        By stationLocator = By.xpath("//div[text()='" + stationName + "']");

        // Явное ожидание, пока нужная станция метро станет видимой
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement station = wait.until(ExpectedConditions.visibilityOfElementLocated(stationLocator));
        station.click();
    }

    // Метод для нажатия на кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}
