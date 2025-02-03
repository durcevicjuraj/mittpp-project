package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage {
    private WebDriver driver;

    private By checkboxesLocator = By.cssSelector("input[type='checkbox']");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCheckboxes() {
        return driver.findElements(checkboxesLocator);
    }

    public void checkCheckbox(int index) {
        List<WebElement> checkboxes = getCheckboxes();
        if (index < checkboxes.size()) {
            WebElement checkbox = checkboxes.get(index);
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public void uncheckCheckbox(int index) {
        List<WebElement> checkboxes = getCheckboxes();
        if (index < checkboxes.size()) {
            WebElement checkbox = checkboxes.get(index);
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }
}
