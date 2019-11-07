package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;
import utils.GlobalConstants.AccountId;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static utils.GlobalConstants.ONE_SEC;
import static utils.GlobalConstants.SEC_15;

public class AccountsOverviewBlock extends BaseClass {

    private static final By ACCOUNT_OVERVIEW_TABLE_HEADERS = By.cssSelector("table#accountTable>thead>tr>th");
    private static final By TABLE_FIRST_ROW_ACCOUNT_LINK = By.cssSelector("tr.ng-scope:first-child>td>a");
    private static final By TABLE_FIRST_ROW_BALANCE_TEXT = By.cssSelector("tr.ng-scope:first-child>td.ng-binding");


    public AccountsOverviewBlock verifyAccountOverviewTableHeaders() {
        List<WebElement> headers = driver.findElements(ACCOUNT_OVERVIEW_TABLE_HEADERS);

        assertEquals(headers.get(0).getText(), "Account");
        assertEquals(headers.get(1).getText(), "Balance*");
        assertEquals(headers.get(2).getText(), "Available Amount");

        return this;
    }

    public AccountDetailsBlock clickFirstAccountIdLink() {
        driver.findElement(TABLE_FIRST_ROW_ACCOUNT_LINK).click();
        return new AccountDetailsBlock();
    }

    public AccountDetailsBlock clickAccountIdLink(AccountId accountId) {
        try {
            Thread.sleep(ONE_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//a[contains(text(), '" + accountId.getAccountId() + "')]")).click();
        return new AccountDetailsBlock();
    }

    public int getTableFirstAccountId() {
        WebDriverWait wait = new WebDriverWait(driver, SEC_15);
        wait.until(ExpectedConditions.elementToBeClickable(TABLE_FIRST_ROW_ACCOUNT_LINK));

        return Integer.parseInt(driver.findElement(TABLE_FIRST_ROW_ACCOUNT_LINK).getText());
    }

    public double getTableFirstAccountBalance() {
        return Double.parseDouble(driver.findElement(TABLE_FIRST_ROW_BALANCE_TEXT).getText().split("\\$")[1]);
    }
}
