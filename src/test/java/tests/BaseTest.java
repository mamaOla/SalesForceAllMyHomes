
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.MainPage;
import pages.NewAccountModal;
import pages.NewAccountPage;
import steps.AccountStep;
import steps.LoginStep;

import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    NewAccountModal newAccountModal;
    NewAccountPage newAccountPage;
    MainPage mainPage;
    SoftAssert softAssert;
    LoginStep loginStep;
    AccountStep accountStep;

    @BeforeMethod(alwaysRun = true, description = "Настройка драйвера")
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);//отключает сервис сохранения паролей
        chromePrefs.put("profile.password_manager_enabled", false);//отключает встроенный менеджер паролей.
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        newAccountModal = new NewAccountModal(driver);
        newAccountPage = new NewAccountPage(driver);
        mainPage = new MainPage(driver);
        loginStep = new LoginStep(driver);
        accountStep = new AccountStep(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown(ITestResult result) {
        softAssert.assertAll();
        driver.quit();
    }
}

