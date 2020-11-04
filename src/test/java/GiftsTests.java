import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftsTests extends BaseUI {

    @Test
    public void testGiftsSearch() {
        giftsPage.giftsSearch();
        WebElement search_textField =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TEXT_FIELD_GIFTS_SEARCH));
        search_textField.sendKeys("Chocolate and fruits");
        driver.findElement(Locators.BUTTON_GIFTS_SEARCH).click();
        String selectedGiftTitle =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.SELECTED_GIFT)).getText();
        Assert.assertEquals(selectedGiftTitle, Data.selectedGiftTitle);
    }

    @Test
    public void testBestsellerPurchase() {
        giftsPage.bestsellerPurchase();
        WebElement bestseller =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_TO_BESTSELLER_PURCHASE));
        bestseller.click();
        String bestSellerTitle =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.BESTSELLER_TITLE)).getText();
        Assert.assertEquals(bestSellerTitle, Data.bestsellerGiftTitle);
    }
}
