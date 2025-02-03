package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class EntryAdPage {

    private WebDriver driver;

    private By modalLocator = By.cssSelector("div.modal");

    private By closeButtonLocator = By.cssSelector("div.modal-footer p");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isModalDisplayed() {
        try {
            WebElement modal = driver.findElement(modalLocator);
            return modal.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Klikne gumb za zatvaranje modala.
     */
    public void clickCloseButton() {
        WebElement closeButton = WaitUtils.waitForVisibility(driver, closeButtonLocator);
        closeButton.click();
    }
}
