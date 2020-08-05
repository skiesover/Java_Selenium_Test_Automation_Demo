package parabank.tests;

import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Services;

import static utils.GlobalConstants.AccountType.SAVINGS;
import static utils.GlobalConstants.*;

/*
Test Case: TestOpenNewAccount

1. Login to Parabank website
2. Click Open New Account link
3.  - Select "Savings" account type
    - Select any account id (or leave default one)
    - Click "Open New Account" button
4. Check account id & available balance for the first account on the table
5. Click on first account so Account Details page will be opened
6. Check that account id & available balance info correspond to data from step 4
*/

@Test(groups = {UI, SMOKE}, description = "TestOpenNewAccount")
public class TestOpenNewAccount extends BaseClass {

    private Services services = new Services();

    public void testOpenNewAccount() {

        services
                .loginToParabankAsUser(TEST_USER, PASSWORD)
                .clickOpenNewAccountLink()
                .selectAccountType(SAVINGS)
                .clickOpenNewAccountButton()
                .checkAccountOpenedSuccessText();

        services
                .verifyAccountId()
                .verifyAccountType(SAVINGS);
    }
}
