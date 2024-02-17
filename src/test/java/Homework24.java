import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Homework24 {
    protected WebDriver driver;
    @BeforeMethod

    protected WebDriver pickBrowser(String browser) throws MalformedURLException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://qa.koel.app");
        driver = pickBrowser(System.getProperty("browser"));
        System.out.println();
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.138:4444";
        switch (browser) {
            case "grid-chrome":
                caps.setCapability("browsername", "chrome");
                return new RemoteWebDriver(new URL(gridURL), caps);
            default:
                return new ChromeDriver();

        }
    }
}




