package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BaseClass;
import utils.GlobalConstants.AccountType;

import static utils.GlobalConstants.ONE_SEC;

public class AccountDetailsBlock extends BaseClass {

    private static final By ACCOUNT_ID_TEXT = By.cssSelector("#accountId");
    private static final By ACCOUNT_TYPE_TEXT = By.cssSelector("#accountType");
    private static final By ACCOUNT_BALANCE_TEXT = By.cssSelector("#balance");

    public int getAccountId() {
        try {
            Thread.sleep(ONE_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(driver.findElement(ACCOUNT_ID_TEXT).getText());
    }

    public double getAccountBalance() {
        try {
            Thread.sleep(ONE_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Double.parseDouble(driver.findElement(ACCOUNT_BALANCE_TEXT).getText().split("\\$")[1]);
    }

    public AccountDetailsBlock verifyAccountType(AccountType accountType) {
        WebElement accountTypeText = driver.findElement(ACCOUNT_TYPE_TEXT);
        Assert.assertEquals(accountTypeText.getText(), accountType.toString());
        return this;
    }
}
