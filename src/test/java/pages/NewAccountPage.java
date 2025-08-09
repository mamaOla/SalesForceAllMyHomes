package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class NewAccountPage extends BasePage {
    private final By MESSAGE = By.cssSelector("div[data-key='success']");

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage open() {
        return null;
    }

    @Override
    public NewAccountPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't open");
        }
        return this;
    }

    @Step("Проверка сообщения о создании аккаунта")
    public boolean checkNotification() {
        log.info("Check Notification");
        // Ждем появления уведомления
        String notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-key='success']"))).getText();
        return notification.contains("Account") && notification.contains("was created");
    }
}
