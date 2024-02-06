import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        //navigateToPage();
        provideEmail("varag@testpro.io");
        providePassword("te$t$tudent1");
        loginToKoel();
        Thread.sleep(2000);
        choosePlaylist();
        Thread.sleep(2000);
        xPlaylist();
        Thread.sleep(2000);

        WebElement confirmationNotification = driver.findElement(By.cssSelector("body > div.alertify-logs.top.right"));
        String notificationText = confirmationNotification.getText();
        String expectedText = "Deleted playlist \"Removable Songs.\"";

        Assert.assertTrue(notificationText.contains(expectedText), "Confirmation notification doesn't have the expected text");
        Thread.sleep(2000);

    }

    public void choosePlaylist() {
        WebElement selectPlaylist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(6) > a"));
        selectPlaylist.click();
    }

    public void xPlaylist() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("#playlistWrapper > header > div.song-list-controls > span > button"));
        deletePlaylist.click();
    }
}
