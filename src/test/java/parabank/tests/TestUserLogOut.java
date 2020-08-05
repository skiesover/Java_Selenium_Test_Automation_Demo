package parabank.tests;

import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Services;

import static utils.GlobalConstants.*;

/*
Test Case: TestUserLogOut

1. Login to Parabank website
2. Click Log Out link
3. Verify that:
    - Logged Out Success text is displayed
    - Username field is empty
    - Password field is empty
    - Log In button is displayed
*/

@Test(groups = {UI, SMOKE}, description = "TestUserLogOut")
public class TestUserLogOut extends BaseClass {

    public void testUserLogOut() {

        new Services()
                .loginToParabankAsUser(TEST_USER, PASSWORD)
                .clickLogOutLink()
                .verifyLoggedOutSuccessfully();
    }
}
