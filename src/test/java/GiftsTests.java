import org.testng.annotations.Test;

public class GiftsTests extends BaseUI {

    @Test
    public void testGiftsSearch() {
        giftsPage.GiftsSearch();
    }

    @Test
    public void testBestsellerPurchase() {
        giftsPage.BestsellerPurchase();
    }
}
