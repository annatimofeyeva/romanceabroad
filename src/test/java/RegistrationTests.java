import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RegistrationTests extends BaseUI {

    @DataProvider(name="Registration")
    public static Object[][] testRegisration() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("SearchGifts.cvs")).stream().forEach(s-> {
            String[] data = s.split(",");
            out.add(new Object[]{data[0]});
        });
        return out.toArray(new Object[out.size()][]);
    }

    @Test(dataProvider = "Registration")
    public void testRegistration(String email) {
        System.out.println(email);
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(Data.email, Data.password);
        mainPage.completeSecondPartOfRegistration(mainPage.generateUniqueUserName(Data.userName, 5), Data.month, Data.day,
                Data.year, Data.phone, Data.city, Data.location);
    }
}

