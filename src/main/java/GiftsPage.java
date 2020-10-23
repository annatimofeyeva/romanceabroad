import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GiftsPage extends  BaseActions{
    public GiftsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void GiftsSearch() {
        driver.findElement(Locators.LINK_GIFTS).click();
        WebElement search_textField =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TEXT_FIELD_GIFTS_SEARCH));
        search_textField.sendKeys("Chocolate and fruits");
        driver.findElement(Locators.BUTTON_GIFTS_SEARCH).click();
        String selectedGiftTitle =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.SELECTED_GIFT)).getText();
        //System.out.println(selectedGiftTitle);
        Assert.assertEquals(selectedGiftTitle, Data.selectedGiftTitle);
    }

    public void BestsellerPurchase() {
        driver.findElement(Locators.LINK_GIFTS).click();
        WebElement bestseller =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_TO_BESTSELLER_PURCHASE));
        bestseller.click();
        String bestSellerTitle =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.BESTSELLER_TITLE)).getText();
        Assert.assertEquals(bestSellerTitle, Data.bestsellerGiftTitle);
    }
}
