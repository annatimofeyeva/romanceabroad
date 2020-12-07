import org.testng.annotations.Test;

public class ContactUsPageTests extends BaseUI {
    @Test
    public void testCompleteContactForm() {
        contactUsPage.completeContactForm();
    }
}
