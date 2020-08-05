package parabank.tests;

import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Services;

import static org.testng.Assert.assertEquals;
import static utils.GlobalConstants.AccountId.ACCOUNT_27330;
import static utils.GlobalConstants.*;

/*
Test Case: TestBillPay

1. Login to Parabank website
2. Check Account A current balance
3. Pay $7 bill with Account A
4. Verify Payment Success text
5. Check Account A current balance
6. Make sure balance value from step 5 is $7 less that balance value from step 2
*/

@Test(groups = {UI, SMOKE}, description = "TestBillPay")
public class TestBillPay extends BaseClass {

    private Services services = new Services();
    private static final double AMOUNT_7 = 7;
    private double currentBalance;
    private double updatedBalance;

    public void testBillPay() {

        services.loginToParabankAsUser(TEST_USER);

        currentBalance = services
                .checkAccountCurrentBalance(ACCOUNT_27330);

        services
                .payBill(AMOUNT_7, ACCOUNT_27330)
                .checkPaymentSuccessText();

        updatedBalance = services
                .checkAccountCurrentBalance(ACCOUNT_27330);

        verifyAccountUpdatedBalance();

    }

    // private methods
    private void verifyAccountUpdatedBalance() {
        assertEquals(updatedBalance, currentBalance - AMOUNT_7);
    }
}
