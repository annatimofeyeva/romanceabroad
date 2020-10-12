import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlogTests extends BaseUI {
    private String currentUrlBlog;
    private String expectedUrlBlog = "https://romanceabroad.com/content/view/blog";
    private String expectedBlogPageTitle = "Blog";

    @Test
    public void testBlogTab() {
        driver.findElement(Locators.LINK_BLOG).click();
        currentUrlBlog = driver.getCurrentUrl();
        String blogTitle =
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.BLOG_TITLE))
                        .getText();
        Assert.assertEquals(currentUrlBlog, expectedUrlBlog);
        Assert.assertEquals(expectedBlogPageTitle, blogTitle);
    }
}
