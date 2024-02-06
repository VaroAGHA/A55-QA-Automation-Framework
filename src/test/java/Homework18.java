import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

   @Test
    public void playSong() throws InterruptedException{
       //navigateToPage();
       provideEmail("varag@testpro.io");
       providePassword("te$t$tudent1");
       loginToKoel();
       //Thread.sleep(2000);
       playNextSong();
       playMusic();
       //Thread.sleep(10000);

       WebElement soundBar = driver.findElement(By.cssSelector("#mainFooter > div.side.player-controls"));
       WebElement pauseBtn = driver.findElement(By.cssSelector("#mainFooter > div.side.player-controls > span"));
       Assert.assertTrue(soundBar.isDisplayed() || pauseBtn.isDisplayed(),  "Either sound bar or pause button should be displayed indicating the song is playing.");

    }

    public void playMusic() {
       WebElement playButton = driver.findElement(By.cssSelector("#mainFooter > div.side.player-controls > span > span.play > i"));
       playButton.click();
    }

    public void playNextSong() {
        WebElement playNextBTn = driver.findElement(By.cssSelector("#mainFooter > div.side.player-controls > i.next.fa.fa-step-forward.control"));
        playNextBTn.click();

    }
    }

