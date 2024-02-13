import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class Homework23 extends BaseTest{
@Test
    public void playSong(){

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage =new HomePage(driver);
    AllSongsPage allSongsPage = new AllSongsPage(driver);
    loginPage.login();
    homePage.chooseAllSongsList();
    allSongsPage.contextClickFirstSong();
    allSongsPage.choosePlay();
    Assert.assertTrue(allSongsPage.isSongPlaying());
    
}
}
