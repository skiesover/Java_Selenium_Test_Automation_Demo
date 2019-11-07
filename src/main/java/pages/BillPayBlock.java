package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BaseClass;
import utils.GlobalConstants.AccountId;

import static utils.GlobalConstants.ONE_SEC;

public class BillPayBlock extends BaseClass {

    private static final By PAYEE_NAME_FIELD = By.cssSelector("input[ng-model='payee.name']");
    private static final By ADDRESS_FIELD = By.cssSelector("input[ng-model='payee.address.street']");
    private static final By CITY_FIELD = By.cssSelector("input[ng-model='payee.address.city']");
    private static final By STATE_FIELD = By.cssSelector("input[ng-model='payee.address.state']");
    private static final By ZIP_CODE_FIELD = By.cssSelector("input[ng-model='payee.address.zipCode']");
    private static final By PHONE_NUMBER_FIELD = By.cssSelector("input[ng-model='payee.phoneNumber']");
    private static final By ACCOUNT_FIELD = By.cssSelector("input[ng-model='payee.accountNumber']");
    private static final By VERIFY_ACCOUNT_FIELD = By.cssSelector("input[ng-model='verifyAccount']");
    private static final By AMOUNT_FIELD = By.cssSelector("input[ng-model='amount']");
    private static final By FROM_ACCOUNT_DROPDOWN = By.cssSelector("select[ng-model='accountId']");
    private static final By SEND_PAYMENT_BUTTON = By.cssSelector("input.button");
    private static final By SUCCESS_TITLE = By.cssSelector("div[ng-show='showResult']>h1.title");


    public BillPayBlock enterPayeeName(String payeeName) {
        driver.findElement(PAYEE_NAME_FIELD).sendKeys(payeeName);
        return this;
    }

    public BillPayBlock enterAddress(String address) {
        driver.findElement(ADDRESS_FIELD).sendKeys(address);
        return this;
    }

    public BillPayBlock enterCity(String city) {
        driver.findElement(CITY_FIELD).sendKeys(city);
        return this;
    }

    public BillPayBlock enterState(String state) {
        driver.findElement(STATE_FIELD).sendKeys(state);
        return this;
    }

    public BillPayBlock enterZipCode(String zipCode) {
        driver.findElement(ZIP_CODE_FIELD).sendKeys(zipCode);
        return this;
    }

    public BillPayBlock enterPhoneNumber(int phoneNumber) {
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(String.valueOf(phoneNumber));
        return this;
    }

    public BillPayBlock enterAccountId(int accountId) {
        driver.findElement(ACCOUNT_FIELD).sendKeys(String.valueOf(accountId));
        return this;
    }

    public BillPayBlock enterVerifyAccountId(int accountId) {
        driver.findElement(VERIFY_ACCOUNT_FIELD).sendKeys(String.valueOf(accountId));
        return this;
    }

    public BillPayBlock enterAmount(double amount) {
        driver.findElement(AMOUNT_FIELD).sendKeys(String.valueOf(amount));
        return this;
    }

    public BillPayBlock selectFromAccount(AccountId accountId) {
        Select fromAccountDropdown = new Select(driver.findElement(FROM_ACCOUNT_DROPDOWN));
        fromAccountDropdown.selectByVisibleText(String.valueOf(accountId.getAccountId()));
        return this;
    }

    public BillPayBlock clickSendPaymentButton() {
        driver.findElement(SEND_PAYMENT_BUTTON).click();
        return this;
    }

    public BillPayBlock checkPaymentSuccessText() {
        try {
            Thread.sleep(ONE_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(driver.findElement(SUCCESS_TITLE).getText(), "Bill Payment Complete");
        return this;
    }
}
