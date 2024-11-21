

/*

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OptionalScenariosPage {
private WebDriver driver;


 //------------------ЛОКАТОРЫ-----------------------

 // Локатор для логотипа "Самокат"
 public static By scooterLogo = By.xpath("//img[@alt='Scooter']");

 // Локатор для логотипа "Яндекс"
 public static By yandexLogo = By.xpath("//img[@alt='Yandex']");

 // Локаторы для текстов ошибок
 public static By nameError = By.xpath("//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректное имя']");
 public static By surnameError = By.xpath("//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректную фамилию']");
 public static By addressError = By.xpath("//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректный адрес']");
 public static By phoneError = By.xpath("//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректный номер']");


 // Методы для получения текста ошибок
 public static String getNameErrorText(WebDriver driver) {
  return driver.findElement(nameError).getText();
 }

 public static String getSurnameErrorText(WebDriver driver) {
  return driver.findElement(surnameError).getText();
 }

 public static String getAddressErrorText(WebDriver driver) {
  return driver.findElement(addressError).getText();
 }

 public static String getPhoneErrorText(WebDriver driver) {
  return driver.findElement(phoneError).getText();
 }


}

*/