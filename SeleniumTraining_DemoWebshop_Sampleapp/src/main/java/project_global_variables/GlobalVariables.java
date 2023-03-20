package project_global_variables;

import java.util.HashMap;

public class GlobalVariables {

    // Default WebDriver
    public static final String DEFAULT_WEB_DRIVER = "chrome";

    // Applications
    public static final String DEMO_WEBSHOP_APPLICATION = "https://demowebshop.tricentis.com/";
    public static final String SAMPLE_APP_APPLICATION = "";

    // Expected Messages
    public static final String CREDENTIALS_ERROR_MESSAGE = "The credentials provided are incorrect";
    public static final String NO_CUSTOMER_ACCOUNT_FOUND = "No customer account found";
    public static final String WRONG_EMAIL_TEXT = "Wrong email";
    public static final String EMAIL_LESS_THAN_5_CHARACTERS_TEXT = "The password should have at least 6 characters.";
    public static final String CONFIRM_PASSWORD_WRONG_TEXT = "The password and confirmation password do not match.";
    public static final String WISHLIST_EMPTY_MESSAGE = "The wishlist is empty!";
    public static final String KEY_CART_QUANTITY = "CART_QUANTITY";

    public static final String KEY_EXTRA_CART_STEPS = "EXTRA_CART_STEPS";
    public static HashMap<String,String> GLOBAL_HASHMAP = new HashMap<>();

}
