import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RegistrationTests extends BaseUI {


    @DataProvider(name = "Registration2")
    public static Object[][] testRegistration2() {
        return new Object[][]{
//                {Data.email1, Data.userName, true},
//                {Data.email2, Data.userName, true},
//                {Data.email3, Data.userName, true}
                {Data.email1, Data.userName, true},
                {Data.email2, Data.userName, false},
                {Data.email3, Data.userName, true}
        };
    }

    @Test(dataProvider = "Registration2")
    public void testRegistration2(String email, String nickName, boolean isEmailCorrect) {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, Data.password);
        if (!isEmailCorrect) {
            WebElement element = driver.findElement(Locators.TOOLTIP_ERROR);
            Assert.assertTrue(element.isDisplayed());
            System.out.println("Email is not correct");
        } else {
            mainPage.completeSecondPartOfRegistration(nickName, Data.month, Data.day, Data.phone, Data.year,
                    Data.city, Data.location);
        }
    }

    @DataProvider(name = "Registration")
    public static Object[][] testRegisration() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("Registration.csv")).stream().forEach(s -> {
            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});
        });
        return out.toArray(new Object[out.size()][]);
    }

    @Test(dataProvider = "Registration")
    public void testRegistration(String email, String password, String day, String month, String year, String phone, String city, String location) {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, password);
        mainPage.completeSecondPartOfRegistration(mainPage.generateUniqueUserName(Data.userName, 5), month, day, phone, year, city, location);
    }

}


