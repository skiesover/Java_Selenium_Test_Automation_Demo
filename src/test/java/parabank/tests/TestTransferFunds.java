package parabank.tests;

import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Services;

import static org.testng.Assert.assertEquals;
import static utils.GlobalConstants.AccountId.ACCOUNT_27108;
import static utils.GlobalConstants.AccountId.ACCOUNT_27330;
import static utils.GlobalConstants.*;

/*
Test Case: TestTransferFunds

1. Login to Parabank website
2. Check Account A current balance
3. Transfer $15 from Account B to Account A
4. Verify Funds Transferred Success text
5. Check Account A current balance
6. Make sure balance value from step 5 is $15 greater that balance value from step 2
*/

@Test(groups = {UI, SMOKE}, description = "TestTransferFunds")
public class TestTransferFunds extends BaseClass {

    private Services services = new Services();
    private static final double AMOUNT_15 = 15;
    private double currentBalance;
    private double updatedBalance;

    public void testTransferFunds() {

        services.loginToParabankAsUser(BEANWORKS_USER, PASSWORD);

        currentBalance = services
                .checkAccountCurrentBalance(ACCOUNT_27330);

        services
                .transferFunds(AMOUNT_15, ACCOUNT_27108, ACCOUNT_27330)
                .checkFundsTransferredSuccessText();

        updatedBalance = services
                .checkAccountCurrentBalance(ACCOUNT_27330);

        verifyAccountUpdatedBalance();

    }

    // private methods
    private void verifyAccountUpdatedBalance() {
        assertEquals(updatedBalance, currentBalance + AMOUNT_15);
    }
}
