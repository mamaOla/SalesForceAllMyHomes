
package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {

    WebDriver driver;
    String span;

    public Checkbox(WebDriver driver, String span) {
        this.driver = driver;
        this.span = span;
    }

    public void check(Boolean shouldCheck) {
        WebElement checkbox = driver.findElement(
                By.xpath(String.format("//span[text()='%s']//ancestor::lightning-primitive-input-checkbox//input", span)));
        boolean isSelected = checkbox.isSelected();
        if (shouldCheck && !isSelected) {
            checkbox.click();
        } else if (!shouldCheck && isSelected) {
            checkbox.click();
        }
    }
}

