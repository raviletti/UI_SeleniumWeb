package web;

import elements.Header;
import io.qameta.allure.Step;
import models.Consumer;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SwaglabsUITest {

    private WebDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        loadProperties();
        setupDriver();
    }

    @Step("Загрузить конфигурационные файлы")
    private void loadProperties() throws IOException {
        // Читаем конфигурационные файлы в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
    }

    @Step("Создать экземпляр драйвера")
    private void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AbstractPage.setDriver(driver);


    }

    @Test
    public void createOrderTest() {
        driver.get(System.getProperty("site.url"));
        LogSwagPage logSwagPage = new LogSwagPage();
        logSwagPage.login(System.getProperty("username"),System.getProperty("password"));
        Product product = new Product();
        product.setName("Sauce Labs Backpack");
        ProductsPage productsPage = new ProductsPage();
        productsPage.openAProductPage(product);
        ProductPage productPage = new ProductPage();
        product.setPrice(productPage.getProductPrice());
        product.setDescription(productPage.getProductDescription());
        productPage.clickOnAddToCartButton();
        Header header = new Header(driver);
        header.clickOnCartButton();
        CartPage cartPage = new CartPage();
        cartPage.clickCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.inputInfo(createNewConsumer());
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.checkCart(product);
        checkoutOverviewPage.clickOnFinishButton();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        checkoutCompletePage.checkTheOrderFinished();
    }


    @AfterTest
    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    private Consumer createNewConsumer(){
        Consumer consumer = new Consumer();
        consumer.setFirstName("Bruce");
        consumer.setLastName("Wayne");
        consumer.setPostalCode(103132);
        return consumer;
    }
}
