package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    // Конструктор для инициализации драйвера
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // ========================= Локаторы =========================

    // Поля для ввода данных
    private By nameField = By.cssSelector("input[type='text'][placeholder='* Имя']");
    private By surnameField = By.cssSelector("input[type='text'][placeholder='* Фамилия']");
    private By addressField = By.cssSelector("div.Order_Form__17u6u > div:nth-child(3) > input");
    private By phoneField = By.cssSelector("div.Order_Form__17u6u > div:nth-child(5) > input");
    private By stationField = By.cssSelector("input[placeholder='* Станция метро']");

    // Кнопки
    private By nextButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");
    private By placeOrderButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
    private By confirmOrderButton = By.xpath("//button[text()='Да']");

    // Поле для ввода даты аренды
    private By calendarDateField = By.cssSelector("div > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div > input");

    // Срок аренды
    private By rentalTermField = By.xpath("//div[@class='Dropdown-placeholder' and contains(text(), 'Срок аренды')]");
    private By rentalOptionThreeDays = By.xpath("//div[text()='трое суток']");

    // Заголовок окна подтверждения заказа
    private By orderConfirmationHeader = By.xpath("//div[contains(@class, 'Order_ModalHeader') and text()='Заказ оформлен']");

    // ========================= Методы =========================

    // Ввод данных в поля
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void selectStation(String station) {
        WebElement stationInput = driver.findElement(stationField);
        stationInput.click();
        stationInput.sendKeys(station);
        stationInput.sendKeys(Keys.ARROW_DOWN);
        stationInput.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(stationField, "value", station));
    }

    // Работа с кнопками
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void clickPlaceOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        driver.findElement(placeOrderButton).click();
    }

    public void clickConfirmOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
    }

    // Работа с датой аренды
    public void enterCalendarDate(String date) {
        WebElement calendarField = driver.findElement(calendarDateField);
        calendarField.click();
        calendarField.sendKeys(date);
        calendarField.sendKeys(Keys.ENTER);
    }
    // Выбор срока аренды
    public void selectRentalTermThreeDays() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement rentalField = wait.until(ExpectedConditions.elementToBeClickable(rentalTermField));
        rentalField.click();
        WebElement optionThreeDays = wait.until(ExpectedConditions.visibilityOfElementLocated(rentalOptionThreeDays));
        optionThreeDays.click();
    }

    // Проверка появления окна подтверждения
    public boolean isOrderConfirmationHeaderVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationHeader)).isDisplayed();
    }

}
