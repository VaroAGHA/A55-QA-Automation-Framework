import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest {
    @Test
    public void playSongWithContextClick() {
        //Login
        provideEmail("varag@testpro.io");
        providePassword("te$t$tudent1");
        loginToKoel();
        //chooseAllSongsList();
        chooseAllSongsList();
        //contextClickFirstSong();
        contextClickFirstSong();
        //choosePlay();
        choosePlay();
        //Assertions();
        Assert.assertTrue(isSongPlaying());
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
