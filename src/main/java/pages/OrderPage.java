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

    // Локатор и метод для ввода числа в календаре с нажатием Enter
    public By calendarDateField = By.cssSelector("div > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div > input");

    public void enterCalendarDate(String date) {
        WebElement calendarField = driver.findElement(calendarDateField); // Находим поле календаря
        calendarField.click(); // Нажимаем на поле
        calendarField.sendKeys(date); // Вводим дату
        calendarField.sendKeys(Keys.ENTER); // Нажимаем клавишу Enter
        System.out.println("Дата " + date + " успешно введена и подтверждена нажатием Enter.");
    }


    // Локаторы и метод для выбора длины аренды
    // Объявляем локаторы
    public By rentalTermField = By.xpath("//div[@class='Dropdown-placeholder' and contains(text(), 'Срок аренды')]");
    public By rentalOptionThreeDays = By.xpath("//div[text()='трое суток']");

    // Метод для выбора "трое суток" в сроке аренды
    public void selectRentalTermThreeDays() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Кликаем на поле "Срок аренды"
        WebElement rentalField = wait.until(ExpectedConditions.elementToBeClickable(rentalTermField));
        rentalField.click();
        System.out.println("Кликнули на поле 'Срок аренды'.");

        // Ждём, пока выпадающий список станет видимым
        WebElement optionThreeDays = wait.until(ExpectedConditions.visibilityOfElementLocated(rentalOptionThreeDays));
        optionThreeDays.click();
        System.out.println("Выбрали опцию 'трое суток'.");

        // Проверяем, что в поле появился текст "трое суток"
        String selectedText = rentalField.getText();
        if (selectedText.equals("трое суток")) {
            System.out.println("Опция 'трое суток' успешно выбрана.");
        } else {
            System.out.println("Ошибка: выбрана другая опция или текст не появился.");
        }
    }















}
