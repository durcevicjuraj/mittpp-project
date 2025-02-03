package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class FormAuthPage {

    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button.radius");
    private By flashMessage = By.id("flash");

    public FormAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement userField = WaitUtils.waitForVisibility(driver, usernameField);
        userField.clear();
        userField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passField = WaitUtils.waitForVisibility(driver, passwordField);
        passField.clear();
        passField.sendKeys(password);
    }

    public void clickLoginButton() {
        WaitUtils.waitForElementToBeClickable(driver, loginButton).click();
    }

    public void validLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getFlashMessage() {
        return WaitUtils.waitForVisibility(driver, flashMessage).getText();
    }
}
