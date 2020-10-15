import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MediaTests extends BaseUI {
    private String currentUrlPhotos;

    @Test
    public void testPhotosTab() {
        getMediaPage(Locators.LINK_PHOTOS);
        currentUrlPhotos = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlPhotos, Data.expectedUrlPhotos);
    }

    @Test
    public void testPhotosSorting() {
        getMediaPage(Locators.LINK_PHOTOS);
        WebElement sortingPhotoButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BUTTON_SORTING_PHOTOS));
        sortingPhotoButton.click();
    }

    @Test
    public void testAddPhotoButton() {
        getMediaPage(Locators.LINK_PHOTOS);
        WebElement addPhotoButton = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BUTTON_ADD_PHOTO));
        addPhotoButton.click();
    }
}
