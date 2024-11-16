package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    // Локатор для поля ввода станции метро
    public By stationField = By.cssSelector("input[placeholder='* Станция метро']");

    // Метод для выбора станции
    public void selectStation(String station) {
        WebElement stationInput = driver.findElement(stationField);
        stationInput.click();
        stationInput.sendKeys(station);
        stationInput.sendKeys(Keys.ARROW_DOWN);
        stationInput.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(stationField, "value", station));
    }

    // Локатор и метод для нажатия кнопки "Далее"
    public By nextButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }












    // Универсальный метод для проверки кнопки
    public void checkElementPresence(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Ожидание видимости элемента
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Всё пашет как надо!");
        } catch (Exception e) {
            System.err.println("Ошибка: Элемент не найден!");
        }
    }

    // Метод для вызова проверки кнопки
    public void verifyElementPresence() {
        checkElementPresence(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input"));
    }
}
