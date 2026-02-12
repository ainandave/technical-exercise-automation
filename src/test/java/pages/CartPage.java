package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private By newNumberOption = By.xpath("//input[@data-testid='number-option-1']/following-sibling::span[1]");
    private By physicalSimOption = By.xpath("//input[@value='USIM']/ancestor::label");
    private By checkoutButton = By.xpath("//a[@data-testid='product-checkout-button']");

    public CartPage pickNewNumber() {
        click(newNumberOption);
        return this;
    }

    public CartPage selectPhysicalSim() {
        click(physicalSimOption);
        return this;
    }

    public CheckoutPage clickCheckout() {
        click(checkoutButton);
        return new CheckoutPage();
    }
}
