package parabank.tests;

import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Services;

import static utils.GlobalConstants.*;

/*
Test Case: TestAccountsOverview

1. Login to Parabank website
2. Click Accounts Overview link
3. Verify that:
    - First Table Column is "Account"
    - Second Table Column is "Balance*"
    - Third Table Column is "Available Amount"
4. Check account id & available balance for the first account on the table
5. Open first account so Account Details page will be opened
6. Check that account id & available balance info correspond to data from step 4
*/

@Test(groups = {UI, SMOKE}, description = "TestAccountsOverview")
public class TestAccountsOverview extends BaseClass {

    private Services services = new Services();

    public void testAccountsOverview() {

        services
                .loginToParabankAsUser(BEANWORKS_USER, PASSWORD)
                .clickAccountsOverviewLink()
                .verifyAccountOverviewTableHeaders();

        services.openFirstAccountAndVerifyDetails();

    }
}
