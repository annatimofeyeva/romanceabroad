import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseUI {

    @Test
    public void testRegistration() {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration();
        mainPage.completeSecondPartOfRegistration();
        WebElement checkboxConformation = driver.findElement(By.cssSelector("input#confirmation"));
//        Assert.assertTrue(!driver.findElement(Locators.LINK_SEARCH).isDisplayed(), "Element is not displayed");
//        checkboxConformation.click();
        if(!driver.findElement(Locators.LINK_SEARCH).isSelected()) {
            checkboxConformation.click();
        }else{
            Assert.fail("Checkbox is already selected");
        }
    }
}
