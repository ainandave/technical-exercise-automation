package utils;

public class TestData {

    public static final String FIRST_NAME = "Test";
    public static final String LAST_NAME = "Test";
    public static final String DOB = "21/10/1990";
    public static final String EMAIL = "test@test.com";
    public static final String PASSWORD = "Password123!";
    public static final String ADDRESS = "Level 6, 17-19 Bridge St, SYDNEY NSW 2000";
    public static final String CARD_NUMBER = "4242424242424242";
    public static final String EXPIRY = "01/27";
    public static final String CVV = "123";
    public static String generatePhoneNumber() {
        int random = (int) (Math.random() * 90000000) + 10000000;
        return "04" + random;
    }
}
