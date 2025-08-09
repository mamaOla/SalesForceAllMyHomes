
package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Picklist {

    WebDriver driver;
    WebDriverWait wait;
    String label;

    public Picklist(WebDriver driver, WebDriverWait wait, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = wait;
    }

    public void select(String option) {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//label[text()='%s']//ancestor::lightning-picklist//button",
                        label)))).click();
//        driver.findElement(By.xpath(String.format
//                ("//label[text()='%s']//ancestor::lightning-picklist//button", label))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//label[text()='%s']//ancestor::lightning-picklist//lightning-base-combobox-item//span[text()='%s']",
                        label, option)))).click();
//        driver.findElement(By.xpath
//                (String.format("//label[text()='%s']//ancestor::lightning-picklist" +
//                        "//lightning-base-combobox-item//span[text()='%s']", label, option))).click();
    }
}

