package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    public static Account getAccount
            (String raring, String type, String industry, String ownership, Boolean checkboxVip, Boolean checkboxSkills) {
        Faker faker = new Faker();
        return new Account(
                faker.company().name(), //String name;
                faker.phoneNumber().phoneNumber(), //String phone;
                raring, //String rating;
                faker.phoneNumber().phoneNumber(), //String fax;
                faker.internet().domainName(), //String website;
                faker.number().digit(), //String number;
                faker.internet().emailAddress(), //String accountSite;
                faker.idNumber().invalid(), //String symbol;
                faker.number().digit(), //String employees;
                faker.number().digit(), //String revenue;
                faker.number().digit(), //String code;
                faker.address().streetAddress(), //String textBiling;
                faker.address().streetAddress(), //String textShiping;
                type, //String type;
                industry, //String industry;
                ownership, //String ownership;
                checkboxVip, //checkboxVip
                checkboxSkills //checkboxSkills
        );
    }
}
