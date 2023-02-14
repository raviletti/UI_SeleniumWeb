package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasicPage extends SwagLabsBasePage {

    private WebElement checkoutButton = driver.findElement(By.xpath("//button[@name='checkout']"));


    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
