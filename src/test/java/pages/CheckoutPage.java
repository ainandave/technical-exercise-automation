package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    //Personal Information
    private By titleDropdown = By.xpath("//input[@name='title']");
    private By titleMrOption = By.xpath("//li[@role='option']//div[text()='Mr']");

    private By firstNameField = By.xpath("//input[@name='firstName']");
    private By lastNameField = By.xpath("//input[@name='lastName']");
    private By dateOfBirthField = By.xpath("//input[@name='dateOfBirth']");

    private By emailField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By contactNumberField = By.xpath("//input[@name='contactNumber']");
    private By addressField = By.xpath("//label[contains(.,'home or work address')]/following::input[1]");
    private By firstAddressSuggestion = By.xpath("//li[@role='option' and @data-suggestion-index='0']");

    //Payment Section
    private By paymentsIframe = By.cssSelector("iframe[title='Secure payment input frame']");
    private By cardPaymentOption = By.xpath("//button[@data-testid='card']");
    private By cardNumberField = By.xpath("//input[@id='payment-numberInput']");
    private By expiryField = By.xpath("//input[@id='payment-expiryInput']");
    private By cvvField = By.xpath("//input[@id='payment-cvcInput']");
    private By termsCheckbox = By.xpath("//input[@name='acceptTermsAndConditions']/ancestor::label");
    private By payButton = By.xpath("//button[@form='amaysim-stripe-payment-element-form']");

    //Error Message
    private By paymentErrorHeader = By.xpath("//strong[contains(.,'Credit Card payment failed')]");
    private By paymentErrorMessage = By.xpath("//span[contains(.,'attempt to pay via Credit Card has failed')]");

    public CheckoutPage fillPersonalDetails(String firstName, String lastName, String dateOfBirth) {
        click(titleDropdown);
        click(titleMrOption);

        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(dateOfBirthField, dateOfBirth);

        return this;
    }

    public CheckoutPage fillOtherDetails(String email, String password, String contactNumber, String address) {
        type(emailField, email);
        type(passwordField, password);
        type(contactNumberField, contactNumber);
        type(addressField, address);

        click(firstAddressSuggestion);

        return this;
    }

    public CheckoutPage selecCardPayment() {
        switchToFrame(paymentsIframe);
        click(cardPaymentOption);
        switchToDefaultContent();
        return this;
    }

    public CheckoutPage enterCardDetails(String cardNumber, String expiry, String cvv) {
        switchToFrame(paymentsIframe);
        type(cardNumberField, cardNumber);
        type(expiryField, expiry);
        type(cvvField, cvv);

        switchToDefaultContent();
        return this;
    }

    public CheckoutPage acceptTerms() {
        click(termsCheckbox);
        return this;
    }

    public CheckoutPage submitPayment() {
        click(payButton);
        return this;
    }

    public boolean isPaymentErrorDisplayed() {
        return isDisplayed(paymentErrorMessage);
    }

    public String getPaymentErrorHeader() {
        return getText(paymentErrorHeader);
    }
}
