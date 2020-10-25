import org.testng.annotations.Test;

public class LogInTests extends BaseUI {
    @Test
    public void testLogInInvalidCredentials() {
        loginPage.loginInvalidCredentials();
    }
}
