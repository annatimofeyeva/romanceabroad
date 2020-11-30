import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MediaPage extends BaseActions{
    public MediaPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void photosSorting() {
        getNavigateToLinkPage(Locators.LINK_PHOTOS);
        WebElement sortingPhotoButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BUTTON_SORTING_PHOTOS));
        sortingPhotoButton.click();
    }

    public void addPhotoButton() {
        getNavigateToLinkPage(Locators.LINK_PHOTOS);
        WebElement addPhotoButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BUTTON_ADD_PHOTO));
        addPhotoButton.click();
    }
}
