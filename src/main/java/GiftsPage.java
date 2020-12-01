import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftsPage extends BaseActions {
    public GiftsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String giftSearch() {
        getNavigate(Locators.LINK_GIFTS);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TEXT_FIELD_GIFTS_SEARCH));
        driver.findElement(Locators.TEXT_FIELD_GIFTS_SEARCH)
                .sendKeys("Chocolate and fruits");
        driver.findElement(Locators.BUTTON_GIFTS_SEARCH).click();
        String selectedGiftTitle =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.SELECTED_GIFT)).getText();
        return selectedGiftTitle;
    }

    public String bestsellerSelection() {
        getNavigate(Locators.LINK_GIFTS);
        ajaxClick(Locators.LINK_TO_BESTSELLER_PURCHASE);
        String bestSellerTitle =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.BESTSELLER_TITLE)).getText();
        return bestSellerTitle;
    }

    public String bestsellerPurchase() {
        getNavigate(Locators.LINK_GIFTS);
        ajaxClick(Locators.LINK_TO_BESTSELLER_PURCHASE);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_PAY_PAL));
        WebElement payPalButton = driver.findElement(Locators.BUTTON_PAY_PAL);
        if (payPalButton.isEnabled()) {
            System.out.println("It's possible to make payment with PayPal");
        } else {
            System.out.println("Some issues with PauPal payment");
        }
        String payPalButtonText = payPalButton.getText().trim();
        return payPalButtonText;
    }
}
