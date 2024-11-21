package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    // ========================= Константы =========================
    // Статическая переменная для базового URL
    public static final String Order_URL = "https://qa-scooter.praktikum-services.ru/order";

    // ========================= Конструктор =========================
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // ========================= Локаторы =========================
    // Поля для ввода данных
    private static final By nameField = By.cssSelector("input[type='text'][placeholder='* Имя']");
    private static final By surnameField = By.cssSelector("input[type='text'][placeholder='* Фамилия']");
    private static final By addressField = By.cssSelector("div.Order_Form__17u6u > div:nth-child(3) > input");
    private static final By phoneField = By.cssSelector("div.Order_Form__17u6u > div:nth-child(5) > input");
    private static final By stationField = By.cssSelector("input[placeholder='* Станция метро']");

    // Кнопки
    private static final By nextButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");
    private static final By placeOrderButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
    private static final By confirmOrderButton = By.xpath("//button[text()='Да']");

    // Поле для ввода даты аренды
    private static final By calendarDateField = By.cssSelector("div > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div > input");

    // Срок аренды
    private static final By rentalTermField = By.xpath("//div[@class='Dropdown-placeholder' and contains(text(), 'Срок аренды')]");
    private static final By rentalOptionThreeDays = By.xpath("//div[text()='трое суток']");

    // Заголовок окна подтверждения заказа
    private static final By orderConfirmationHeader = By.xpath("//div[contains(@class, 'Order_ModalHeader') and text()='Заказ оформлен']");

    // Локаторы для текстов ошибок
    private static final By NAME_ERROR = By.xpath("//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректное имя']");
    private static final By SURNAME_ERROR = By.xpath("//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректную фамилию']");
    private static final By ADDRESS_ERROR = By.xpath("//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректный адрес']");
    private static final By PHONE_ERROR = By.xpath("//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректный номер']");

    // ========================= Методы =========================

    // ---------- Ввод данных в поля ----------
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

    // ---------- Работа с кнопками ----------
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

    // ---------- Работа с датой аренды ----------
    public void enterCalendarDate(String date) {
        WebElement calendarField = driver.findElement(calendarDateField);
        calendarField.click();
        calendarField.sendKeys(date);
        calendarField.sendKeys(Keys.ENTER);
    }

    public void selectRentalTermThreeDays() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement rentalField = wait.until(ExpectedConditions.elementToBeClickable(rentalTermField));
        rentalField.click();
        WebElement optionThreeDays = wait.until(ExpectedConditions.visibilityOfElementLocated(rentalOptionThreeDays));
        optionThreeDays.click();
    }

    // ---------- Проверка ----------
    public boolean isOrderConfirmationHeaderVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationHeader)).isDisplayed();
    }

    public boolean isErrorVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean areAllErrorsVisible() {
        return isErrorVisible(NAME_ERROR) &&
                isErrorVisible(SURNAME_ERROR) &&
                isErrorVisible(ADDRESS_ERROR) &&
                isErrorVisible(PHONE_ERROR);
    }
}
