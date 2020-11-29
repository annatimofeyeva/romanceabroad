import org.testng.Assert;
import org.testng.annotations.Test;

public class BlogTests extends BaseUI {
    @Test
    public void testVerifyBlogLinkUrl() {
        Assert.assertEquals(blogPage.verifyBlogLinkUrl(), Data.expectedUrlBlog);
    }
}



