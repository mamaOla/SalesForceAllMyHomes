package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    final String BASE_URL = "https://tms9-dev-ed.develop.lightning.force.com/";
    final String MAIN_URL = "https://tms9-dev-ed.develop.lightning.force.com/lightning/setup/SetupOneHome/home";
    final String NEW_ACCOUNT_URL = "https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new";
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public abstract BasePage open();

    public abstract BasePage isPageOpened();

    public void write(String label, String text) {
        driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-input//input", label)))
                .sendKeys(text);
    }
}