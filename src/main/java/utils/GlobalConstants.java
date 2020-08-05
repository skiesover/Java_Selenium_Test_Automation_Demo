package utils;

/* This class stores global constants */
public class GlobalConstants {

    // test groups
    public static final String UI = "ui";
    public static final String SMOKE = "smoke";


    // user credentials
    public static final String TEST_USER = "skiesover";
    public static final String PASSWORD = "password";
    public static final String TEST_USER_FIRST_NAME = "Ildar";
    public static final String TEST_USER_LAST_NAME = "Lutfullin";

    // other constants
    public static final String PARABANK_URL = "https://parabank.parasoft.com/";
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String VALUE_CSS = "value";
    public static final int PAYEE_ACCOUNT = 111;
    public static final long ONE_SEC = 1000;
    public static final long SEC_15 = 15;

    // account ids
    public enum AccountId {
        ACCOUNT_27330(27330),
        ACCOUNT_27108(27108);

        private int accountId;

        AccountId(int accountId) {
            this.accountId = accountId;
        }

        public int getAccountId() {
            return accountId;
        }
    }

    // account types
    public enum AccountType {
        CHECKING,
        SAVINGS
    }
}
