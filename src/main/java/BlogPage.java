import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogPage extends BaseActions {
    String currentUrlBlog;

    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String verifyBlogLinkUrl() {
        getNavigateToLinkPage(Locators.LINK_BLOG);
        currentUrlBlog = driver.getCurrentUrl();
        return currentUrlBlog;
    }
}
