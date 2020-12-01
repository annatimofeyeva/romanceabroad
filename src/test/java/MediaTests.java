import org.testng.Assert;
import org.testng.annotations.Test;

public class MediaTests extends BaseUI {

    @Test
    public void testSortingPhotosByViewsCount() {
        String actualSortingValueText = mediaPage.sortingPhotosByViewsCount();
        Assert.assertEquals(actualSortingValueText, Data.expectedSortingValueText);
    }
}

