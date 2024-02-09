import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylistName() throws InterruptedException {
        //login
        provideEmail("varag@testpro.io");
        providePassword("te$t$tudent1");
        loginToKoel();
        //Thread.sleep(3000);
        //choose Playlist
        choosePlaylist();
        //Thread.sleep(3000);
        //rename name
        renameName();
        //Thread.sleep(3000);

    }

    public void renameName() {
        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));

        playlistName.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistName.sendKeys("Music One");
        playlistName.sendKeys(Keys.ENTER);

    }

    public void choosePlaylist() {
        WebElement plList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(5)")));
        actions.doubleClick(plList).perform();

    }



    //Second option of Homework 21
    @Test
    public void renamePlaylist() {

        // Login
        provideEmail("varag@testpro.io");
        providePassword("te$t$tudent1");
        loginToKoel();

        // Hover over the playlist and click to rename
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(6)")));
        actions.moveToElement(playlist).perform();

        WebElement editBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(6)")));
        editBar.click();
        actions.contextClick().perform();
        WebElement renameOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(6) > nav > ul > li:nth-child(1)")));
        renameOption.click();

        // Rename the playlist
        WebElement playlistInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInput.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInput.sendKeys("New Playlist Name");


        // Assert that the playlist name has been changed successfully
        String newPlaylistName = playlistInput.getAttribute("value");
        Assert.assertEquals("New Playlist Name", newPlaylistName);
    }
    }
