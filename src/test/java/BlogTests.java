import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class BlogTests extends BaseUI {
    String currentUrlBlog;

    @Test
    public void testBlogTab() {
        getBlogPage(Locators.LINK_BLOG);
        currentUrlBlog = driver.getCurrentUrl();

//        Example of Implicit wait:

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        String blogTitle = driver.findElement(Locators.BLOG_TITLE).getText();

        String blogTitle =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BLOG_TITLE))
                        .getText();
        Assert.assertEquals(currentUrlBlog, Data.expectedUrlBlog);
        Assert.assertEquals(Data.expectedBlogPageTitle, blogTitle);
    }
}
