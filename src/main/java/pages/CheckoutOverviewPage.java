package pages;

import io.qameta.allure.Step;
import models.Consumer;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/** Страница предпросмотра заказа */
public class CheckoutOverviewPage extends SwagLabsBasePage {

    private WebElement productName = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
    private WebElement productDescription = driver.findElement(By.xpath("//div[@class='inventory_item_desc']"));
    private WebElement productPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
    private WebElement finishButton = driver.findElement(By.xpath("//button[@id='finish']"));

    @Step("Проверить значение полей на странице оформления заказа")
    public void checkCart(Product product) {
        Assert.assertEquals(productName.getText(), product.getName(), "Название продукта не соответствует");
        Assert.assertEquals(productPrice.getText().substring(1), String.valueOf(product.getPrice()), "Цена продукта не соответствует");
        Assert.assertEquals(productDescription.getText(), product.getDescription(), "Email тикета не соответствует");
    }

    @Step("Нажать кнопку оформления заказа")
    public void clickOnFinishButton(){
        finishButton.click();
    }
}
