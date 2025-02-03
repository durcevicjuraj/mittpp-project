package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class MultipleWindowsPage {
    private WebDriver driver;

    private By clickHereLink = By.linkText("Click Here");

    public MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnClickHere() {
        WebElement link = WaitUtils.waitForVisibility(driver, clickHereLink);
        link.click();
    }
}
