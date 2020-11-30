import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftsTests extends BaseUI {

    @Test
    public void testGiftSearch() {
     String actualGiftTitle = giftsPage.giftSearch();
     Assert.assertEquals(actualGiftTitle, Data.expectedGiftTitle);
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
        softAssert.assertEquals(bestSellerTitle, Data.bestsellerGiftTitle, "Title of selected bestseller is wrong");
        softAssert.assertAll();
    }
}
