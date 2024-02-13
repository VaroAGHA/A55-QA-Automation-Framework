package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    // By firstSongElement = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playOption = By.cssSelector("li.playback");
    By soundBarVisualizer = By.cssSelector("[data-testid= 'sound-bar-play']");
    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        //findElement(firstSongElement);
        actions.contextClick(firstSongElement).perform();
    }

    public void choosePlay() {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
        findElement(playOption).click();
    }

    public boolean isSongPlaying() {
        //WebElement soundBarVisualiazier = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid= 'sound-bar-play']")));
        WebElement soundBarVisualiazier = driver.findElement(soundBarVisualizer);
        return soundBarVisualiazier.isDisplayed();
    }

}
