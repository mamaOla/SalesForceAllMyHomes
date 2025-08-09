package tests;

import com.github.javafaker.Faker;
import dto.Account;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test(description = "Создание нового аккаунта компании",
            testName = "Проверка создания нового аккаунта компании")
    public void checkCreateAccount() {
        //Account account = getAccount("Hot","Prospect","Banking","Public", true,false);
        Faker faker = new Faker();
        Account account1 = Account.builder()
                .name(faker.name().name())
                .phone(faker.phoneNumber().phoneNumber())
                .checkboxVip(true)
                .textBiling(faker.address().streetAddress())
                .rating("Cold")
                .fax(faker.phoneNumber().phoneNumber())
                .build();
        loginStep.authorisation("tborodich@tms.sandbox", "Password003!");
        accountStep.createAccount(account1);
        softAssert.assertTrue(newAccountPage.checkNotification(), "Account was created");
    }
}
