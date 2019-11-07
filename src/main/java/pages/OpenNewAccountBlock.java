package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;
import utils.GlobalConstants.AccountType;

import static org.testng.Assert.assertEquals;
import static utils.GlobalConstants.ONE_SEC;
import static utils.GlobalConstants.SEC_15;

public class OpenNewAccountBlock extends BaseClass {

    private static final By ACCOUNT_TYPE_DROPDOWN = By.cssSelector("select#type");
    private static final By OPEN_NEW_ACCOUNT_BUTTON = By.cssSelector("input[value='Open New Account']");
    private static final By SUCCESS_MESSAGE_DESCRIPTION_TEXT = By.cssSelector("div[ng-if='showResult']>p");
    private static final By NEW_ACCOUNT_ID_LINK = By.cssSelector("#newAccountId");


    public OpenNewAccountBlock selectAccountType(AccountType accountType) {
        Select accountTypeDropdown = new Select(driver.findElement(ACCOUNT_TYPE_DROPDOWN));
        accountTypeDropdown.selectByVisibleText(accountType.toString());
        return this;
    }

    public OpenNewAccountBlock clickOpenNewAccountButton() {
        try {
            Thread.sleep(ONE_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(OPEN_NEW_ACCOUNT_BUTTON).click();
        return this;
    }

    public AccountDetailsBlock clickNewAccountIdLink() {
        driver.findElement(NEW_ACCOUNT_ID_LINK).click();
        return new AccountDetailsBlock();
    }

    public OpenNewAccountBlock checkAccountOpenedSuccessText() {
        WebDriverWait wait = new WebDriverWait(driver, SEC_15);
        wait.until(ExpectedConditions.presenceOfElementLocated(SUCCESS_MESSAGE_DESCRIPTION_TEXT));

        assertEquals(driver.findElement(SUCCESS_MESSAGE_DESCRIPTION_TEXT).getText(), "Congratulations, your account is now open.");
        return this;
    }

    public int getNewAccountId() {
        WebDriverWait wait = new WebDriverWait(driver, SEC_15);
        wait.until(ExpectedConditions.elementToBeClickable(NEW_ACCOUNT_ID_LINK));

        return Integer.parseInt(driver.findElement(NEW_ACCOUNT_ID_LINK).getText());
    }
}
