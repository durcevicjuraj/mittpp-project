package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContextMenuPage {
    private WebDriver driver;

    private By hotSpotLocator = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHotSpot() {
        return driver.findElement(hotSpotLocator);
    }
}
