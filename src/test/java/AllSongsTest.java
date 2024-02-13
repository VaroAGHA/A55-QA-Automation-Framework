import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTest extends BaseTest {
    //PlaySong Test using Procedural Programming
    @Test
    public void playSongWithContextClick() {
        //Login
        provideEmail("varag@testpro.io");
        providePassword("te$t$tudent1");
        //loginToKoel();
        //chooseAllSongsList();
        chooseAllSongsList();
        //contextClickFirstSong();
        contextClickFirstSong();
        //choosePlay();
        choosePlay();
        //Assertions();
        Assert.assertTrue(isSongPlaying());
    }
    //PlaySong Test using OOP and Page Factoring
    @Test
    public void playSong() {
        //Login
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginPage.login();

        //BasePage.provideEmail("varag@testpro.io").providePassword("te$t$tudent1").clickSubmit();

        //chooseAllSongsList();
        homePage.chooseAllSongsList();
        //contextClickFirstSong();
        allSongsPage.contextClickFirstSong();
        //choosePlay();
        allSongsPage.choosePlay();
        //Assertions();
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualiazier = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid= 'sound-bar-play']")));
        return soundBarVisualiazier.isDisplayed();
    }

    public void choosePlay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();

    }

    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("Li a.songs"))).click();

    }
}
