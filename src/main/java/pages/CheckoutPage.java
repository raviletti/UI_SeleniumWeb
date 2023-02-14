package pages;

import io.qameta.allure.Step;
import models.Consumer;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/** Страница ввода информации о покупателе */
public class CheckoutPage extends SwagLabsBasePage {

    private WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
    private WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
    private WebElement postalCode = driver.findElement(By.xpath("//input[@id='postal-code']"));
    private WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));


    @Step("Заполнить контактную информацию")
    public void inputInfo(Consumer consumer){
        firstName.sendKeys(consumer.getFirstName());
        lastName.sendKeys(consumer.getLastName());
        postalCode.sendKeys(String.valueOf(consumer.getPostalCode()));
        continueButton.click();

    }


}
