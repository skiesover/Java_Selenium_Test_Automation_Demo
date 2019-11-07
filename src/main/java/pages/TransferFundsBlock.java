package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.BaseClass;
import utils.GlobalConstants.AccountId;

import static org.testng.Assert.assertEquals;
import static utils.GlobalConstants.ONE_SEC;

public class TransferFundsBlock extends BaseClass {

    private static final By AMOUNT_FIELD = By.cssSelector("#amount");
    private static final By FROM_ACCOUNT_DROPDOWN = By.cssSelector("#fromAccountId");
    private static final By TO_ACCOUNT_DROPDOWN = By.cssSelector("#toAccountId");
    private static final By TRANSFER_BUTTON = By.cssSelector("input[type='submit']");
    private static final By SUCCESS_MESSAGE_TITLE = By.cssSelector("h1.title");

    public TransferFundsBlock enterAmount(double amount) {
        try {
            Thread.sleep(ONE_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(AMOUNT_FIELD).sendKeys(String.valueOf(amount));
        return this;
    }

    public TransferFundsBlock selectFromAccount(AccountId accountId) {
        Select fromAccountDropdown = new Select(driver.findElement(FROM_ACCOUNT_DROPDOWN));
        fromAccountDropdown.selectByVisibleText(String.valueOf(accountId.getAccountId()));
        return this;
    }

    public TransferFundsBlock selectToAccount(AccountId accountId) {
        Select toAccountDropdown = new Select(driver.findElement(TO_ACCOUNT_DROPDOWN));
        toAccountDropdown.selectByVisibleText(String.valueOf(accountId.getAccountId()));
        return this;
    }

    public TransferFundsBlock clickTransferButton() {
        driver.findElement(TRANSFER_BUTTON).click();
        return this;
    }

    public TransferFundsBlock checkFundsTransferredSuccessText() {
        try {
            Thread.sleep(ONE_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(driver.findElement(SUCCESS_MESSAGE_TITLE).getText(), "Transfer Complete!");
        return this;
    }
}
