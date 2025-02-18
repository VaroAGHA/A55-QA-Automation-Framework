import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.AllSongsPage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

public class BaseTest {



    public WebDriver driver;
    public WebDriverWait wait;
    public Wait<WebDriver> fluentWait;

    public Actions actions;

    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    // public String url = "https://qa.koel.app/";

    ///Data providers Start
   /* @DataProvider(name = "invalidLoginData")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"invalid@email.com", "invalidPassword"},
                {"varag@testpro.io", ""},
                {"", ""},
                {"invalid@email.com", "te$t$tudent1"},
        };
    }

    */

   @BeforeSuite
    static void setupClass() {

       WebDriverManager.chromedriver().setup();
       // WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.edgedriver().setup();
        // WebDriverManager.safaridriver();
    }


    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().deleteAllCookies();
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--kiosk");
        //Set the initial window size
        options.addArguments("--window-size=1888,1800");
       // driver = new ChromeDriver(options);
        */
//-------------------------------------------------------------------------------------------------//
        //driver = new SafariDriver();
//---------------------------------------------------------------------------------------------------//
        //Firefox Browser
       /* FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--window-size=1888,1800");
        driver = new FirefoxDriver(options);
        */
        //----------------------------------------------------------------------------------------//
        // driver = pickBrowser(System.getProperty("browser"));
        //System.out.println();

        //Implicit Wait
        // getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicit Wait
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        fluentWait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(getDriver());
        navigateToPage(baseURL);
    }

    WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.138:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return new Homework25().lambdatest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
                optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
               // chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(optionsChrome);

        }
    }

    /* @AfterMethod
     public void closeBrowser() {
         driver.quit();
     }
     */
    @AfterMethod
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
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
        getDriver().get(url);
    }
    //public void (){
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
}


