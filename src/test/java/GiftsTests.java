import org.testng.annotations.Test;

public class GiftsTests extends BaseUI {

    @Test
    public void testGiftsSearch() {
        giftsPage.giftsSearch();
    }

    @Test
    public void testBestsellerPurchase() {
        giftsPage.bestsellerPurchase();
    }
}
