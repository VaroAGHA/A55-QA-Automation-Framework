package pages;

import org.bouncycastle.asn1.x500.style.BCStrictStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This is class has Page Factory
 * Login Helper Methods are using the Page Factory
 */

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    // Elements

    @FindBy(css = "[type='email']")
    WebElement emailField;

    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement submitBtn;
    By soundBarVisualizer = By.cssSelector("[data-testid= 'sound-bar-play']");

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        submitBtn.click();
    }

    public void login() {
        provideEmail("varag@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
    }

    public boolean isSongPlaying() {
        // WebElement soundBarVisualiazier = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid= 'sound-bar-play']")));
        return findElement(soundBarVisualizer).isDisplayed();
    }

    protected boolean waitForElementToBeNotVisible(WebElement webElement) {
        boolean isWebElementNotVisible = false;
        try {
            isWebElementNotVisible = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.invisibilityOf(webElement));

        } catch (TimeoutException e) {
            isWebElementNotVisible = true;
        }
        return isWebElementNotVisible;
    }
}


