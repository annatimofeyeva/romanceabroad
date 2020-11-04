import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GiftsPage extends  BaseActions{
    public GiftsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void giftsSearch() {
        driver.findElement(Locators.LINK_GIFTS).click();
    }

    public void bestsellerPurchase() {
        driver.findElement(Locators.LINK_GIFTS).click();
    }
}
