package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница логина */
public class LogSwagPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement user;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(css = "[type='submit']")
    private WebElement loginButton;

    public LogSwagPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Авторизация пользователя")
    public LogSwagPage login(String user, String password) {
        setUser(user);
        setPassword(password);
        clickOnLoginButton();
        return this;
    }

    @Step("Ввести логин {user}")
    private void setUser(String user) {
        this.user.sendKeys(user);
    }

    @Step("Ввести пароль")
    private void setPassword(String password) {
        this.password.sendKeys(password);
    }

    @Step("Нажать кнопку авторизации")
    private void clickOnLoginButton() {
        this.loginButton.click();
    }
}
