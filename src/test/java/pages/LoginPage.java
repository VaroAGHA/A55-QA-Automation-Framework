package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * This is class is using Selenium By Abstract class to locate elements.
 * Login Helper Methods are using By class for locators.
 */

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web Elements
    By emailField = By.cssSelector("input[type='email']");
By passwordField = By.cssSelector("input[type='password']");
By loginBtn = By.cssSelector("button[type='submit']");

    //Web Elements
    @FindBy(id = "email")
    By emailField = By.cssSelector("input[type='email']");
    @FindBy(id = "password")
    By passwordField = By.cssSelector("input[type='password']");
    @FindBy(id="submit")
    By loginBtn = By.cssSelector("button[type='submit']");

    //Helper Methods
    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {

        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElement(loginBtn).click();
    }
    public void login() {
        provideEmail("varag@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
    }
}

