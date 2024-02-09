import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest {

    String newPlaylistName = "Sample Edited Playlist";

    @Test
    public void hoverOverPlayBtn() {
        //Login
        provideEmail("varag@testpro.io");
        providePassword("te$t$tudent1");
        loginToKoel();
        //Assertions
        Assert.assertTrue(hoverPlay().isDisplayed());
        //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']"))).isDisplayed());
    }

    public WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    @Test
    public void countSongsPlaylist() {
        //login
        provideEmail("varag@testpro.io");
        providePassword("te$t$tudent1");
        loginToKoel();
        //Choose playlist by the name
        choosePlaylistByName("Be aware");
        //displayAllSongs
        displayAllSongs();

        //Assertions
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }

    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found:" + countSongs());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }

    public int countSongs() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    @Test
    public void renamePlaylist() throws InterruptedException {
        String newPlaylistName = "Sample Edited Playlist";

        String updatedPlaylistSuccessMsg = "Updated playlist \"Sample Edited Playlist.\"";
        //login
        provideEmail("varag@testpro.io");
        providePassword("te$t$tudent1");
        loginToKoel();
        //Thread.sleep(5000);
        //double Click Playlist
        doubleClickPlaylist();
        //enter new name
        enterNewName();
        Thread.sleep(5000);
        //assertion
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistSuccessMsg);
        //Thread.sleep(5000);
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public void enterNewName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);

    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(5)")));
        actions.doubleClick(playlistElement).perform();
    }
}
