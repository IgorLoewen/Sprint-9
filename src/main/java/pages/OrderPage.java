package pages;

import org.openqa.selenium.*;
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

    // Локатор и метод для ввода числа в календаре
    public By calendarDateField = By.cssSelector("div > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div > input");
    public void enterCalendarDate(String date) {
        driver.findElement(calendarDateField).click(); // Нажимаем на поле
        driver.findElement(calendarDateField).sendKeys(date); // Вводим цифру в поле
    }

    // Локаторы и метод для выбора длины аренды
    public By dropdownField = By.cssSelector("div.Dropdown-root");
    public By dropdownOpen = By.cssSelector("div.Dropdown-root.is-open");
    public By rentalOptionFourDays = By.xpath("//div[contains(@class, 'Dropdown-option') and text()='четверо суток']");
    public void selectRentalTermFourDays() {
        try {driver.findElement(dropdownField).click();} catch (Exception e) {e.printStackTrace();return;}
        try {WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(dropdownOpen));} catch (Exception e) {e.printStackTrace();return;}
        try {driver.findElement(rentalOptionFourDays).click();} catch (Exception e) {e.printStackTrace();}
    }


    // Локатор и метод нажатия на кнопку "Заказать"
    private By orderButton = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and contains(text(), 'Заказать')]");
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }


   /*  //Локатор и Кнопка "Да" для подтверждения оформления заказа
    private By confirmOrderButton = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and contains(text(), 'Да')]");
    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }*/








}
