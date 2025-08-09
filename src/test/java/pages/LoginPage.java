package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class LoginPage extends BasePage {
    private final By LOGIN_FIELD = By.id("username");
    private final By PASSWORD_FIELD = By.id("password");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage open() {
        log.info("Login open page");
        driver.get(BASE_URL);
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FIELD));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't open");
        }
        return this;
    }

    @Step("Авторизация")
    public MainPage login(String user, String password) {
        log.info("Authorization");
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(By.id("Login")).click();
        return new MainPage(driver);
    }
}
//"tborodich@tms.sandbox" "Password003!"
