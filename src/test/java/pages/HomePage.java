package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web-Elements

    String newPlaylistName = "Sample Edited Playlist";
            By userAvatarIcon = By.cssSelector("img.avatar");

    //Helper Methods
    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);

    }

    By playlistLocator = By.cssSelector(".playlist:nth-child(6)");

    /* The org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"[name='name']"}
    It's possible that the element is not immediately available when WebDriver attempts to locate it.
     By playlistInputFieldLocator = By.cssSelector("[name='name']");
    */
    By notificationLocator = By.cssSelector("div.success.show");

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(6)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewName() {
        WebElement playlistInputField = findElement(playlistInputFieldLocator);
        //WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        // WebElement playlistInputField = driver.findElement(playlistInputFieldLocator);
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
