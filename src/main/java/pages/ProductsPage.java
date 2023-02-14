package pages;

import io.qameta.allure.Step;
import models.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/** �������� �� ������� ������� */
public class ProductsPage extends SwagLabsBasePage {
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productHref;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("������� �������� ������ {product.name}")
    public void openAProductPage(Product product) {
        String name = product.getName();
        productHref.stream()
                .filter(WebElement::isDisplayed)
                .filter(addToCart -> addToCart.getText().contains(name))
                .findFirst()
                .orElseThrow(() -> new AssertionError("�� ������ ������� � ������ " + name))
                .click();
    }

}
