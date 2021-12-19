package upload;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest {

    @Test
    public void testFileUpload() {
        var fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("C:\\Users\\QATester\\IdeaProjects\\TAU_Selenium\\resources\\test.txt");

        assertEquals(fileUploadPage.getTextUploadedFile(), "test.txt", "Uploaded files incorrect");
    }
}
