import org.testng.annotations.Test;

public class MediaTests extends BaseUI {

    @Test
    public void testPhotosSorting() {
        mediaPage.PhotosSorting();
    }

    @Test
    public void testAddPhotoButton() {
        mediaPage.AddPhotoButton();
    }
}
