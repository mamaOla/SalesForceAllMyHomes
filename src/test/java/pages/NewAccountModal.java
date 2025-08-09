package pages;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.Checkbox;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

@Log4j2
public class NewAccountModal extends BasePage {
    private final By BUTTON = By.xpath("//button[@name='SaveEdit']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal open() {
        log.info("Login open page");
        driver.get(NEW_ACCOUNT_URL);
        return this;
    }

    @Override
    public NewAccountModal isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't open");
        }
        return this;
    }

    @Step("Заполнение карточки компании")
    public NewAccountModal createAccount(Account account) {

        log.info("Rating: {}", account.getRating());
        new Picklist(driver, wait, "Rating").select(account.getRating());
        log.info("Type: {}", account.getType());
        new Picklist(driver, wait, "Type").select(account.getType());
        log.info("Industry: {}", account.getIndustry());
        new Picklist(driver, wait, "Industry").select(account.getIndustry());
        log.info("Ownership: {}", account.getOwnership());
        new Picklist(driver, wait, "Ownership").select(account.getOwnership());
        log.info("Account Name: {}", account.getName());
        new Input(driver, "Account Name").write(account.getName());
        log.info("Phone: {}", account.getPhone());
        new Input(driver, "Phone").write(account.getPhone());
        log.info("Fax: {}", account.getFax());
        new Input(driver, "Fax").write(account.getFax());
        log.info("Website: {}", account.getWebsite());
        new Input(driver, "Website").write(account.getWebsite());
        log.info("Account Number: {}", account.getNumber());
        new Input(driver, "Account Number").write(account.getNumber());
        log.info("Account Site: {}", account.getAccountSite());
        new Input(driver, "Account Site").write(account.getAccountSite());
        log.info("Ticker Symbol: {}", account.getSymbol());
        new Input(driver, "Ticker Symbol").write(account.getSymbol());
        log.info("Employees: {}", account.getEmployees());
        new Input(driver, "Employees").write(account.getEmployees());
        log.info("Annual Revenue: {}", account.getRevenue());
        new Input(driver, "Annual Revenue").write(account.getRevenue());
        log.info("SIC Code: {}", account.getCode());
        new Input(driver, "SIC Code").write(account.getCode());
        log.info("Billing Street: {}", account.getTextBiling());
        new Textarea(driver, "Billing Street").textarea(account.getTextBiling());
        log.info("Shipping Street: {}", account.getTextShiping());
        new Textarea(driver, "Shipping Street").textarea(account.getTextShiping());
        log.info("VIP Client: {}", account.getCheckboxVip());
        new Checkbox(driver, "VIP Client").check(account.getCheckboxVip());
        log.info("TeachMeSkill: {}", account.getCheckboxSkills());
        new Checkbox(driver, "TeachMeSkills").check(account.getCheckboxSkills());
//        return this;
        return this;
    }

    @Step("Клик по кнопке сохранить аккаунт")
    public NewAccountPage saveAccount() {
        log.info("Click save account");
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        return new NewAccountPage(driver);
    }
}
//        String name, String phone, String rating, String fax, String website,
//        String number, String accountSite, String symbol, String employees,
//        String revenue, String code, String textBiling, String textShiping,
//        String type, String industry, String ownership, Boolean checkboxVip, Boolean checkboxSkills
