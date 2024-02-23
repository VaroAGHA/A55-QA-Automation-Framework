import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

        // String url = "https://testpro.io/";
        //driver.get(url);
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test

    public void loginValidEmailPassword() throws InterruptedException {

        //Steps 1: Open Browser and navigate to Koel app.
        //navigateToPage();
        //Step 2: Enter email
        provideEmail("varag@testpro.io");
        //Step 3: Enter Password
        providePassword("te$t$tudent1");
        Thread.sleep(2000);
        //Step4 : Click on Login button
        loginToKoel();

        //Assertion (expected vs actual)
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Explicit Wait
        //WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        WebElement avatarIcon = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }


//Login with Valid email Test using the Page Object Model
    @Test
    public static void loginValidEmailValidPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("varag@testpro.io");
        Thread.sleep(2000);
        loginPage.providePassword("te$t$tudent1");
        Thread.sleep(2000);
        loginPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInValidEmailValidPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("invalid@email.com");
        Thread.sleep(2000);
        loginPage.providePassword("te$t$tudent1");
        Thread.sleep(2000);
        loginPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginEmptyEmailPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("");
        Thread.sleep(2000);
        loginPage.providePassword("");
        Thread.sleep(2000);
        loginPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginEmptyEmailValidPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("");
        Thread.sleep(2000);
        loginPage.providePassword("te$t$tudent1");
        Thread.sleep(2000);
        loginPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = TestData.class)
    public void loginWithNegativeData(String email, String password) {
        //NavigateToPage();
        // Step 2: Enter email
        provideEmail(email);
        //Step 3: Enter Password
        providePassword(password);
        // Click on Login button
        loginToKoel();
        // Assertion (expected vs actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //Quit the browser
        // driver.quit();
        // getDriver().quit();
    }
}

/*@Test
public void loginValidEmailValidPassword()  {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.provideEmail("varag@testpro.io");
    loginPage.providePassword("te$t$tudent1");
   loginPage.clickSubmit();
   Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
}

 */

/*@Test
private void loginValidEmailValidPasswordTest() {
  LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    */


   /* @Test
    public void loginInvalidEmailValidPassword(){
        //Preconditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Declaration
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Step 1: Open Browser and navigate to Koel app.
        String url = "https://qa.koel.app/";
        driver.get(url);

        // Step 2: Enter email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("invalid@email.com");

        //Step 3: Enter Password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent1");

        // Click on Login button
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit"));
        loginBtn.click();

        // Assertion (expected vs actual)
//    WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
//    Assert.assertTrue(avatarIcon.isDisplayed());
        //Quit the browser
        driver.quit();
    }

    */

 /*  @Test
    public void loginValidEmailEmptyPassword()  {
        //Preconditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//Declaration
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps 1: Open Browser and navigate to Koel app.
        String url = "https://qa.koel.app/";
        driver.get(url);

        //Step 2: Enter email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("varag@testpro.io");

        //Step 3: Enter Password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("");

        //Step4 : Click on Login button
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        //Thread.sleep(3000);
        //Assertion (expected vs actual)
//    WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
//    Assert.assertTrue(avatarIcon.isDisplayed());
        driver.quit();
    }
}

  */




