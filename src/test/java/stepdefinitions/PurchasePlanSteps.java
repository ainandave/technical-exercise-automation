package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SimPlansPage;
import utils.TestData;

public class PurchasePlanSteps {

    HomePage homePage = new HomePage();
    SimPlansPage simPlansPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("user is on the homepage")
    public void userIsOnTheHomepage() {
        homePage = new HomePage();
    }

    @When("user selects 7 day sim plan")
    public void userSelectsSevenDayPlan() {
        simPlansPage = homePage.clickSimPlans();
        cartPage = simPlansPage.selectSevenDayPlan();
    }

    @And("user completes checkout with declined credit card")
    public void userCompletesCheckout() {
        checkoutPage = cartPage.pickNewNumber().selectPhysicalSim().clickCheckout();

        checkoutPage
                .fillPersonalDetails(
                        TestData.FIRST_NAME,
                        TestData.LAST_NAME,
                        TestData.DOB)
                .fillOtherDetails(
                        TestData.EMAIL,
                        TestData.PASSWORD,
                        TestData.generatePhoneNumber(),
                        TestData.ADDRESS)
                .selecCardPayment()
                .enterCardDetails(
                        TestData.CARD_NUMBER,
                        TestData.EXPIRY,
                        TestData.CVV)
                .acceptTerms()
                .submitPayment();
    }

    @Then("payment error message should be displayed")
    public void paymentErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(checkoutPage.getPaymentErrorHeader().contains("Credit Card payment failed"));
        Assert.assertTrue(checkoutPage.isPaymentErrorDisplayed());
    }
}
