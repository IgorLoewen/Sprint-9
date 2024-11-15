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

    // Локатор и метод для "Имя"
    public By nameField = By.cssSelector("input[type='text'][placeholder='* Имя']");
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // Локатор и метод для "Фамилия"
    public By surnameField = By.cssSelector("input[type='text'][placeholder='* Фамилия']");
    public void enterSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    // Локатор и метод для "Адрес"
    public By addressField = By.cssSelector("div.Order_Form__17u6u > div:nth-child(3) > input");
    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    // Локатор и метод для "Телефон"
    public By phoneField = By.cssSelector("div.Order_Form__17u6u > div:nth-child(5) > input");
    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    // Локатор для поля ввода станции
    public By stationField = By.cssSelector("input[placeholder='* Станция метро']");

    // Метод для выбора станции
    public void selectStation(String station) {
        // Нажимаем на поле ввода станции
        WebElement stationInput = driver.findElement(stationField);
        stationInput.click();

        // Вводим название станции
        stationInput.sendKeys(station);

        // Ждём появления выпадающего списка с нужной станцией
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By stationOption = By.xpath("//div[contains(@class, 'select-search__row') and text()='" + station + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(stationOption));

        // Кликаем по станции
        driver.findElement(stationOption).click();

        // Проверяем, что поле ввода содержит выбранную станцию
        wait.until(ExpectedConditions.attributeToBe(stationField, "value", station));
    }

    // Локатор и метод для нажатия кнопки "Далее"
    public By nextButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");
    public void clickNextButton() {
        // Нажимаем на кнопку "Далее"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        driver.findElement(nextButton).click();
    }
}
