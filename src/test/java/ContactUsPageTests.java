import com.romanceabroad.ui.Algos.Data;
import org.testng.annotations.Test;

public class ContactUsPageTests extends BaseUI {
    @Test
    public void testCompleteContactForm() {
        contactUsPage.completeContactForm();
    }

    @Test
    public void testCompleteContactForm1() {
        contactUsPage.completeContactForm1(Data.userNameContactUs, Data.userEmailContactUs, Data.subjectText, Data.messageText);
    }
}

