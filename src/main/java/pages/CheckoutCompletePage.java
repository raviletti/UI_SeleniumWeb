package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
/** Страница с информацией о завершении оформления заказа **/
public class CheckoutCompletePage extends SwagLabsBasePage {

    private WebElement completeHeader = driver.findElement(By.xpath("//h2[@class='complete-header']"));

    @Step("Проверить успешность оформления заказа")
    public void checkTheOrderFinished(){
        Assert.assertTrue(completeHeader.isDisplayed());
    }
}
