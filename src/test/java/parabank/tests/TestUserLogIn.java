package parabank.tests;

import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Services;

import static utils.GlobalConstants.*;

/*
Test Case: TestUserLogIn

1. Login to Parabank website
2. Verify that:
    - Logged In Success text is displayed ("Welcome [first name] [last name]")
    - Log Out link is displayed
*/

@Test(groups = {UI, SMOKE}, description = "TestUserLogIn")
public class TestUserLogIn extends BaseClass {

    public void testUserLogIn() {

        new Services()
                .loginToParabankAsUser(TEST_USER)
                .checkLoggedInSuccessText(TEST_USER)
                .checkLogOutLinkDisplayed();
    }
}
