import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException{

        navigateToPage();
        provideEmail("varag@testpro.io");
        providePassword("te$t$tudent1");
        loginToKoel();
        Thread.sleep(1000);
        searchSong();
        Thread.sleep(1000);
        viewAllBtn();
        Thread.sleep(1000);
        firstSong();
        Thread.sleep(1000);
        addBtn();
        Thread.sleep(1000);
        choosePlaylist();
        Thread.sleep(1000);
       // WebElement Notification = driver.findElement(By.cssSelector(".success.show"));


        WebElement actualResult = driver.findElement(By.cssSelector("body > div.alertify-logs.top.right"));
        String actualText = actualResult.getText().replace("\"","").trim();
        String expectedText = "Added 1 song into Barev.";

        Assert.assertEquals(actualText, expectedText);
        Thread.sleep(1000);
}

    public void searchSong() {
        WebElement searchField = driver.findElement(By.cssSelector("#searchForm > input"));
        searchField.click();
        searchField.sendKeys("Hogan Grip");
    }

    public void viewAllBtn() {
        WebElement viewAllSongs = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        viewAllSongs.click();
    }

    public void firstSong() {
        WebElement selectSong = driver.findElement(By.cssSelector("#songResultsWrapper .items > tr:nth-of-type(1) > .title"));
        selectSong.click();

    }

    private void addBtn() {
        WebElement addBtn = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
        addBtn.click();
    }

    private void choosePlaylist() {
        WebElement playList = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(5)"));
        playList.click();
    }
    }

