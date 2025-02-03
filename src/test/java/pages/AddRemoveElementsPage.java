package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class AddRemoveElementsPage {

    private WebDriver driver;

    private By addElementButton = By.xpath("//button[text()='Add Element']");

    private By deleteButton = By.cssSelector("button.added-manually");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddElement() {
        WaitUtils.waitForVisibility(driver, addElementButton).click();
    }

    public boolean isDeleteButtonPresent() {
        return !driver.findElements(deleteButton).isEmpty();
    }

    public void clickDeleteButton() {
        WebElement deleteBtn = WaitUtils.waitForVisibility(driver, deleteButton);
        deleteBtn.click();
    }
}
