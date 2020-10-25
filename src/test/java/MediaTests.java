import org.testng.annotations.Test;

public class MediaTests extends BaseUI {

    @Test
    public void testPhotosSorting() {
        mediaPage.photosSorting();
    }

    @Test
    public void testAddPhotoButton() {
        mediaPage.addPhotoButton();
    }
}
