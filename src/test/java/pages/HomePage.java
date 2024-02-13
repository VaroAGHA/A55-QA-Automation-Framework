package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web-Elements

    String newPlaylistName = "Sample Edited Playlist";
            By userAvatarIcon = By.cssSelector("img.avatar");
    //chooseAllSongsList
    By allSongsList = By.cssSelector("Li a.songs");

    //doubleClickPlaylist
    By playlistElementLocator = By.cssSelector(".playlist:nth-child(6)");

    //enterNewName
    @FindBy(css = "[name='name']" )
    By playlistInputFieldLocator = By.cssSelector("[name='name']");


    //notification
    By notificationLocator = By.cssSelector("div.success.show");

    /*-----------------------------------------------------------------------------------------*/

    //Helper Methods
    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);

    }
    public void chooseAllSongsList() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("Li a.songs"))).click();
        findElement(allSongsList).click();
    }

    public void doubleClickPlaylist() {
       // WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(6)")));
        WebElement playlistElement =findElement(playlistElementLocator);
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewName() {
        WebElement playlistInputField = findElement(playlistInputFieldLocator);
       // WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        //WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        WebElement notification = findElement(notificationLocator);
        return notification.getText();
    }
}
