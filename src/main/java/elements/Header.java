package elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Главное меню (блок элементов) */
public class Header {
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartButton;


    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать кнопку \"Cart\"")
    public void clickOnCartButton() {
        cartButton.click();
    }


}
