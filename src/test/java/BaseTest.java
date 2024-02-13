import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Wait<WebDriver> fluentWait;

    public Actions actions;

    // public String url = "https://qa.koel.app/";

    ///Data providers Start
    @DataProvider(name = "invalidLoginData")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"invalid@email.com", "invalidPassword"},
                {"varag@testpro.io", ""},
                {"", ""},
                {"invalid@email.com", "te$t$tudent1"},
        };
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
       // options.addArguments("--kiosk");
        // Set the initial window size
        options.addArguments("--window-size=1888,1800");

        driver = new ChromeDriver(options);
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      /*  fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(10));
*/
       // driver.manage().window().maximize();
        actions = new Actions(driver);
        navigateToPage(baseURL);
    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    //Helper Methods
    public void loginToKoel() {
        //WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        loginBtn.click();
        // Thread.sleep(5000);
    }

    public void providePassword(String password) {
       // WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }
}