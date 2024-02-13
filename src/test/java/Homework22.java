import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest {
    @Test
    public void renamePlaylist(){
        String updatedPlaylistSuccessMsg = "Updated playlist \"Sample Edited Playlist.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage =new HomePage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewName();
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistSuccessMsg);

    }
}
