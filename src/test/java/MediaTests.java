import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MediaTests extends BaseUI {
    private String currentUrlPhotos;
    private String expectedUrlPhotos = "https://romanceabroad.com/media/index";
    private By LINK_PHOTOS = By.xpath("//a[@href='https://romanceabroad.com/media/index']");
    private By BUTTON_ADD_PHOTO = By.cssSelector(".caret");
    private By BUTTON_SORTING_PHOTOS = By.cssSelector(".hidden-xs.fa.fa-arrow-down.pointer.plr5");

    @Test
    public void testPhotosTab() {
        driver.findElement(LINK_PHOTOS).click();
        currentUrlPhotos = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlPhotos, expectedUrlPhotos);
    }

    @Test
    public void testPhotosSorting() {
        driver.findElement(LINK_PHOTOS).click();
        WebElement sortingPhotoButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_SORTING_PHOTOS));
        sortingPhotoButton.click();
    }

    @Test
    public void testAddPhotoButton() {
        driver.findElement(LINK_PHOTOS).click();
        WebElement addPhotoButton = wait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_ADD_PHOTO));
        addPhotoButton.click();
    }
}
