import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GiftsTests extends BaseUI {
    private String currentUrlGifts;

    @Test
    public void testGiftsTab() {
        getGiftsPage(Locators.LINK_GIFTS);
        currentUrlGifts = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlGifts, Data.expectedUrlGifts);
    }

    @Test
    public void testGiftsSearch() {
        getGiftsPage(Locators.LINK_GIFTS);
        WebElement search_textField =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TEXT_FIELD_GIFTS_SEARCH));
        search_textField.sendKeys("Chocolate and fruits");
        driver.findElement(Locators.BUTTON_GIFTS_SEARCH).click();
        String selectedGiftTitle =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.SELECTED_GIFT)).getText();
        //System.out.println(selectedGiftTitle);
        Assert.assertEquals(selectedGiftTitle, Data.selectedGiftTitle);
    }

    @Test
    public void testBestsellerPurchase() {
        getGiftsPage(Locators.LINK_GIFTS);
        WebElement bestseller =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_TO_BESTSELLER_PURCHASE));
        bestseller.click();
        String bestSellerTitle =
                wait.until(ExpectedConditions.elementToBeClickable(Locators.BESTSELLER_TITLE)).getText();
        Assert.assertEquals(bestSellerTitle, Data.bestsellerGiftTitle);
    }
}
