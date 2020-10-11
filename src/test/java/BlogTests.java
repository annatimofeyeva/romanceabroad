import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlogTests extends BaseUI {
    private String currentUrlBlog;
    private String expectedUrlBlog = "https://romanceabroad.com/content/view/blog";
    private String expectedBlogPageTitle = "Blog";
    private By BLOG_TITLE = By.xpath("//h1");
    private By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");

    @Test
    public void testBlogTab() {
        driver.findElement(LINK_BLOG).click();
        currentUrlBlog = driver.getCurrentUrl();
        String blogTitle =
                wait.until(ExpectedConditions.presenceOfElementLocated(BLOG_TITLE))
                        .getText();
        Assert.assertEquals(currentUrlBlog, expectedUrlBlog);
        Assert.assertEquals(expectedBlogPageTitle, blogTitle);
    }
}
