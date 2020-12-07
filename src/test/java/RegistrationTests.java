import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseUI {

    @Test
    public void testRegistration() {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(Data.email, Data.password);
        mainPage.completeSecondPartOfRegistration(Data.month, Data.day, Data.year, Data.phone, Data.city);
        WebElement checkboxConformation = driver.findElement(Locators.CHECK_BOX_CONFIRMATION);
//        Assert.assertTrue(!driver.findElement(Locators.LINK_SEARCH).isDisplayed(), "Element is not displayed");
//        checkboxConformation.click();
//        if (!driver.findElement(Locators.LINK_SEARCH).isSelected()) {
//            checkboxConformation.click();
//        } else {
//            Assert.fail("Checkbox is already selected");
//        }
        mainPage.clickUnselectedCheckbox(checkboxConformation);
    }
}

