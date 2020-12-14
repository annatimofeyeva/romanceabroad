import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GiftsPage extends BaseActions {
    public GiftsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void giftSearch(String gift) {
        getNavigate(Locators.LINK_GIFTS);
        WebElement searchFiled =  wait.until(ExpectedConditions.elementToBeClickable(Locators.TEXT_FIELD_GIFTS_SEARCH));
        searchFiled.sendKeys(gift);
        WebElement element = driver.findElement(By.xpath("//button[@id='search_friend']"));
        element.click();
    }

    public String bestsellerSelection() {
        getNavigate(Locators.LINK_GIFTS);
        ajaxClick(Locators.LINK_TO_BESTSELLER_PURCHASE);
        String bestSellerTitle =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.BESTSELLER_TITLE)).getText();
        System.out.println(bestSellerTitle);
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
