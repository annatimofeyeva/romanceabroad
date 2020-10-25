import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MediaPage extends BaseActions{
    public MediaPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void photosSorting() {
        driver.findElement(Locators.LINK_PHOTOS).click();
        WebElement sortingPhotoButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BUTTON_SORTING_PHOTOS));
        sortingPhotoButton.click();
    }

    public void addPhotoButton() {
        driver.findElement(Locators.LINK_PHOTOS).click();
        WebElement addPhotoButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BUTTON_ADD_PHOTO));
        addPhotoButton.click();
    }
}
