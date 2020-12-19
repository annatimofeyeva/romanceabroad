import com.romanceabroad.ui.Algos.Data;
import com.romanceabroad.ui.Algos.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftsTests extends BaseUI {


    @Test (dataProvider = "Gifts Search", dataProviderClass = DataProviders.class)
    public void testGiftSearch(String gift) {
        giftsPage.giftSearch(gift);
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
