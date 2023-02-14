package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/** Страница с описанием товара */
public class ProductPage extends SwagLabsBasePage {

    // todo: проинициализировать элементы через driver.findElement

    private WebElement name = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']"));
    private WebElement price = driver.findElement(By.xpath("//div[@class='inventory_details_price']"));
    private WebElement description = driver.findElement(By.xpath("//div[@class='inventory_details_desc large_size']"));
    private WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));


    @Step("Получить описание продукта")
    public String getProductDescription() {
        return description.getText();
    }

    @Step("Получить цену продукта")
    public double getProductPrice() {
        return Double.parseDouble(price.getText().substring(1));
    }

    @Step("Нажать кнопку добавления в корзину")
    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }


}
