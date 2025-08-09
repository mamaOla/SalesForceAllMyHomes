package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class MainPage extends BasePage {
    private final By TITLE = By.xpath("//button[@title='App Launcher']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage open() {
        log.info("Login open page");
        driver.get(MAIN_URL);
        return this;
    }

    @Override
    public MainPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't open");
        }
        return this;
    }

    // Пока нигде не используется
//    public NewAccountModal openAccountsPage() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='App Launcher']"))).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Sales Console']"))).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.//div[text()='New']]"))).click();
//        return new NewAccountModal(driver);
//    }
}