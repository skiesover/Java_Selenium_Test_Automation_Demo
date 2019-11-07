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
                .loginToParabankAsUser(BEANWORKS_USER, PASSWORD)
                .checkLoggedInSuccessText(BEANWORKS_USER_FIRST_NAME, BEANWORKS_USER_LAST_NAME)
                .checkLogOutLinkDisplayed();
    }
}
