import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GiftsTests extends BaseUI {

    @DataProvider(name="Gifts Search")
    public static Object[][] testGifts() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("SearchGifts.cvs")).stream().forEach(s-> {
            String[] data = s.split(",");
            out.add(new Object[]{data[0]});
        });
        return out.toArray(new Object[out.size()][]);
    }

    @Test (dataProvider = "Gifts Search")
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
