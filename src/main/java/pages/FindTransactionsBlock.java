package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;
import utils.GlobalConstants.AccountId;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.GlobalConstants.SEC_15;

public class FindTransactionsBlock extends BaseClass {

    private static final By ACCOUNT_DROPDOWN = By.cssSelector("#accountId");
    private static final By FIND_BY_AMOUNT_FIELD = By.cssSelector("#criteria\\.amount");
    private static final By FIND_TRANSACTIONS_BUTTON = By.cssSelector("button[ng-click*='AMOUNT']");
    private static final By TRANSFERS_ELEMENTS = By.xpath("//a[contains(text(), 'Received')]");
    private static final By TRANSFERS_AMOUNTS_ELEMENTS = By.cssSelector("span[ng-if*='Credit']");

    public FindTransactionsBlock selectAccount(AccountId accountId) {
        Select accountDropdown = new Select(driver.findElement(ACCOUNT_DROPDOWN));
        accountDropdown.selectByVisibleText(String.valueOf(accountId.getAccountId()));
        return this;
    }

    public FindTransactionsBlock enterAmount(double amount) {
        driver.findElement(FIND_BY_AMOUNT_FIELD).sendKeys(String.valueOf(amount));
        return this;
    }

    public FindTransactionsBlock clickFindTransactionButton() {
        driver.findElement(FIND_TRANSACTIONS_BUTTON).click();
        return this;
    }

    public FindTransactionsBlock verifyTransfersExist() {
        WebDriverWait wait = new WebDriverWait(driver, SEC_15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TRANSFERS_ELEMENTS));

        assertTrue(driver.findElements(TRANSFERS_ELEMENTS).size() > 0);
        return this;
    }

    public FindTransactionsBlock verifyTransfersAmounts(double amount) {
        List<WebElement> amountsList = driver.findElements(TRANSFERS_AMOUNTS_ELEMENTS);

        for (WebElement transferAmount : amountsList) {
            assertEquals(Double.parseDouble(transferAmount.getText().split("\\$")[1]), amount);
        }

        return this;
    }
}
