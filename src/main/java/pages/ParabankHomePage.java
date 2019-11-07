package pages;

import org.openqa.selenium.By;
import utils.BaseClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.GlobalConstants.*;

public class ParabankHomePage extends BaseClass {

    private static final By USERNAME_FIELD_ELEMENT = By.cssSelector("input[name='username']");
    private static final By PASSWORD_FIELD_ELEMENT = By.cssSelector("input[name='password']");
    private static final By LOG_IN_BUTTON_ELEMENT = By.cssSelector("input.button[value='Log In']");
    private static final By OPEN_NEW_ACCOUNT_LINK_ELEMENT = By.cssSelector("a[href*='openaccount']");
    private static final By ACCOUNTS_OVERVIEW_LINK_ELEMENT = By.cssSelector("a[href*='overview']");
    private static final By TRANSFER_FUNDS_LINK_ELEMENT = By.cssSelector("a[href*='transfer']");
    private static final By BILL_PAY_LINK_ELEMENT = By.cssSelector("a[href*='billpay']");
    private static final By FIND_TRANSACTIONS_LINK_ELEMENT = By.cssSelector("a[href*='findtrans']");
    private static final By LOG_OUT_LINK_ELEMENT = By.cssSelector("a[href*='logout']");
    private static final By LOGGED_IN_SUCCESS_TEXT = By.cssSelector("#leftPanel>p.smallText");
    private static final By LOGGED_OUT_SUCCESS_TEXT = By.cssSelector("#leftPanel>h2");


    public ParabankHomePage enterUsername(String username) {
        driver.findElement(USERNAME_FIELD_ELEMENT).sendKeys(username);
        return this;
    }

    public ParabankHomePage enterPassword(String password) {
        driver.findElement(PASSWORD_FIELD_ELEMENT).sendKeys(password);
        return this;
    }

    public ParabankHomePage clickLoginButton() {
        driver.findElement(LOG_IN_BUTTON_ELEMENT).click();
        return this;
    }

    public OpenNewAccountBlock clickOpenNewAccountLink() {
        driver.findElement(OPEN_NEW_ACCOUNT_LINK_ELEMENT).click();
        return new OpenNewAccountBlock();
    }

    public AccountsOverviewBlock clickAccountsOverviewLink() {
        driver.findElement(ACCOUNTS_OVERVIEW_LINK_ELEMENT).click();
        return new AccountsOverviewBlock();
    }

    public TransferFundsBlock clickTransferFundsLink() {
        driver.findElement(TRANSFER_FUNDS_LINK_ELEMENT).click();
        return new TransferFundsBlock();
    }

    public BillPayBlock clickBillPayLink() {
        driver.findElement(BILL_PAY_LINK_ELEMENT).click();
        return new BillPayBlock();
    }

    public FindTransactionsBlock clickFindTransactionLink() {
        driver.findElement(FIND_TRANSACTIONS_LINK_ELEMENT).click();
        return new FindTransactionsBlock();
    }

    public ParabankHomePage clickLogOutLink() {
        driver.findElement(LOG_OUT_LINK_ELEMENT).click();
        return this;
    }

    public ParabankHomePage checkLoggedInSuccessText(String firstName, String lastName) {
        String expectedMessage = "Welcome " + firstName + SPACE + lastName;
        assertEquals(driver.findElement(LOGGED_IN_SUCCESS_TEXT).getText(), expectedMessage);

        return this;
    }

    public ParabankHomePage checkLogOutLinkDisplayed() {
        assertTrue(driver.findElement(LOG_OUT_LINK_ELEMENT).isDisplayed(), "Log Out link is not displayed!");
        return this;
    }

    public ParabankHomePage verifyLoggedOutSuccessfully() {
        assertEquals(driver.findElement(LOGGED_OUT_SUCCESS_TEXT).getText(), "Customer Login");
        assertEquals(driver.findElement(USERNAME_FIELD_ELEMENT).getAttribute(VALUE_CSS), EMPTY);
        assertEquals(driver.findElement(PASSWORD_FIELD_ELEMENT).getAttribute(VALUE_CSS), EMPTY);

        assertTrue(driver.findElement(LOG_IN_BUTTON_ELEMENT).isDisplayed());
        return this;
    }
}