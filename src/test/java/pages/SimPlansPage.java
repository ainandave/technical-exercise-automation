package pages;

import org.openqa.selenium.By;

public class SimPlansPage extends BasePage {

    private By sevenDayBuyNowButton = By.xpath("//a[@href='/mobile/cart/7-day-10gb']");

    public CartPage selectSevenDayPlan() {
        click(sevenDayBuyNowButton);

        return new CartPage();
    }
}
