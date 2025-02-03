package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HomePage {

    private WebDriver driver;

    private By headerLocator = By.tagName("h1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText() {
        return WaitUtils.waitForVisibility(driver, headerLocator).getText();
    }

    public boolean isPageLoaded() {
        String headerText = getHeaderText();
        System.out.println("Header text: " + headerText); // Opcionalno za debug
        return headerText.contains("Welcome");
    }
}
