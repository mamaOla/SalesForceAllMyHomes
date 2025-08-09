package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Account {
    @Builder.Default
    String name = "Test";
    @Builder.Default
    String phone = "";
    @Builder.Default
    String rating = "";
    @Builder.Default
    String fax = "";
    @Builder.Default
    String website = "";
    @Builder.Default
    String number = "";
    @Builder.Default
    String accountSite = "";
    @Builder.Default
    String symbol = "";
    @Builder.Default
    String employees = "";
    @Builder.Default
    String revenue = "";
    @Builder.Default
    String code = "";
    @Builder.Default
    String textBiling = "";
    @Builder.Default
    String textShiping = "";
    @Builder.Default
    String type = "Prospect";
    @Builder.Default
    String industry = "Banking";
    @Builder.Default
    String ownership = "Public";
    @Builder.Default
    Boolean checkboxVip = false;
    @Builder.Default
    Boolean checkboxSkills = false;
}