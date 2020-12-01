import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftsTests extends BaseUI {

    @Test
    public void testGiftSearch() {
        String actualGiftTitle = giftsPage.giftSearch();
        Assert.assertEquals(actualGiftTitle, Data.expectedGiftTitle);
    }

    @Test
    public void testBestsellerSelection() {
        String actualBestSellerTitle = giftsPage.bestsellerSelection();
        Assert.assertEquals(actualBestSellerTitle, Data.expectedBestsellerGiftTitle);
    }

    @Test
    public void testBestsellerPurchase() {
        String actualPayPalButtonText = giftsPage.bestsellerPurchase();
        Assert.assertEquals(actualPayPalButtonText, Data.expectedPayPalButtonText);
    }
}
