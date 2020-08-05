package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pages.*;
import utils.GlobalConstants.AccountId;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static utils.GlobalConstants.PARABANK_URL;
import static utils.GlobalConstants.PAYEE_ACCOUNT;

/* This class stores particular-page-unrelated and utils methods */
public class Services extends BaseClass {

    private ParabankHomePage parabankHomePage = new ParabankHomePage();
    private OpenNewAccountBlock openNewAccountBlock = new OpenNewAccountBlock();
    private AccountsOverviewBlock accountsOverviewBlock = new AccountsOverviewBlock();
    private AccountDetailsBlock accountDetailsBlock = new AccountDetailsBlock();

    public ParabankHomePage loginToParabankAsUser(String userId) {
        User user = getUser(userId);
        String username = user.getUsername();
        String password = user.getPassword();

        this
                .navigateToParabankHomePage()
                .enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();

        return parabankHomePage;
    }

    public static User getUser(String userId) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;
        try {
            users = objectMapper.readValue(new File("users.json"), new TypeReference<List<User>>() {});
            return users.stream()
                    .filter(usr -> userId.equals(usr.getUsername()))
                    .findAny()
                    .orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AccountDetailsBlock verifyAccountId() {

        int expectedAccountId = openNewAccountBlock
                .getNewAccountId();

        int actualAccountId = openNewAccountBlock
                .clickNewAccountIdLink()
                .getAccountId();

        assertEquals(actualAccountId, expectedAccountId, "Account Id deviates from expected!");

        return accountDetailsBlock;
    }

    public AccountDetailsBlock openFirstAccountAndVerifyDetails() {

        int expectedFirstAccountId =
                accountsOverviewBlock.getTableFirstAccountId();

        double expectedFirstAccountBalance =
                accountsOverviewBlock.getTableFirstAccountBalance();

        int actualAccountId = accountsOverviewBlock
                .clickFirstAccountIdLink()
                .getAccountId();

        double actualAccountBalance =
                accountDetailsBlock.getAccountBalance();

        assertEquals(actualAccountId, expectedFirstAccountId);
        assertEquals(actualAccountBalance, expectedFirstAccountBalance);

        return accountDetailsBlock;
    }

    public double checkAccountCurrentBalance(AccountId accountId) {

        return parabankHomePage
                .clickAccountsOverviewLink()
                .clickAccountIdLink(accountId)
                .getAccountBalance();
    }

    public TransferFundsBlock transferFunds(double amount, AccountId fromAccount, AccountId toAccount) {
        parabankHomePage
                .clickTransferFundsLink()
                .enterAmount(amount)
                .selectFromAccount(fromAccount)
                .selectToAccount(toAccount)
                .clickTransferButton();

        return new TransferFundsBlock();
    }

    public BillPayBlock payBill(double amount, AccountId fromAccount) {
        parabankHomePage
                .clickBillPayLink()
                .enterPayeeName("Payee_1")
                .enterAddress("1000 Smith st")
                .enterCity("Vancouver")
                .enterState("British Columbia")
                .enterZipCode("B00 R00")
                .enterPhoneNumber(0000000000)
                .enterAccountId(PAYEE_ACCOUNT)
                .enterVerifyAccountId(PAYEE_ACCOUNT)
                .enterAmount(amount)
                .selectFromAccount(fromAccount)
                .clickSendPaymentButton();

        return new BillPayBlock();
    }

    public FindTransactionsBlock findTransactions(double amount, AccountId account) {
        parabankHomePage
                .clickFindTransactionLink()
                .selectAccount(account)
                .enterAmount(amount)
                .clickFindTransactionButton();

        return new FindTransactionsBlock();
    }

    // private methods
    private ParabankHomePage navigateToParabankHomePage() {
        driver.get(PARABANK_URL);
        return new ParabankHomePage();
    }
}
