import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MediaTests extends BaseUI {
    private String currentUrlPhotos;
    private String expectedUrlPhotos = "https://romanceabroad.com/media/index";

    @Test
    public void testPhotosTab() {
        driver.findElement(Locators.LINK_PHOTOS).click();
        currentUrlPhotos = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlPhotos, expectedUrlPhotos);
    }

    @Test
    public void testPhotosSorting() {
        driver.findElement(Locators.LINK_PHOTOS).click();
        WebElement sortingPhotoButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BUTTON_SORTING_PHOTOS));
        sortingPhotoButton.click();
    }

    @Test
    public void testAddPhotoButton() {
        driver.findElement(Locators.LINK_PHOTOS).click();
        WebElement addPhotoButton = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BUTTON_ADD_PHOTO));
        addPhotoButton.click();
    }
}
