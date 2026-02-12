package pages;

import org.openqa.selenium.By;

public class HomePage extends  BasePage {

    private By simPlansLink = By.xpath("//a[@aria-label='SIM plans']");

    public SimPlansPage clickSimPlans() {
        click(simPlansLink);
        System.out.println("Element visible");
        return new SimPlansPage();
    }
}
