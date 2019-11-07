package parabank.tests;

import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Services;

import static utils.GlobalConstants.AccountId.ACCOUNT_27108;
import static utils.GlobalConstants.AccountId.ACCOUNT_27330;
import static utils.GlobalConstants.*;

/*
Test Case: TestFindTransactionsByAmount

1. Login to Parabank website
2. Transfer $3 from Account B to Account A
3. Navigate to Find Transaction page
4. Select Account A dropdown value and $3 amount & click Find by Amount button
5. Verify that:
    - More that 0 transfers present in search results list
    - All transfers have Transfer Amount value equal to $3
*/

@Test(groups = {UI, SMOKE}, description = "TestFindTransactionsByAmount")
public class TestFindTransactionsByAmount extends BaseClass {

    private Services services = new Services();
    private static final double AMOUNT_3 = 3;

    public void testFindTransactionsByAmount() {

        services.loginToParabankAsUser(BEANWORKS_USER, PASSWORD);

        services.transferFunds(AMOUNT_3, ACCOUNT_27108, ACCOUNT_27330);

        services
                .findTransactions(AMOUNT_3, ACCOUNT_27330)
                .verifyTransfersExist()
                .verifyTransfersAmounts(AMOUNT_3);
    }
}
