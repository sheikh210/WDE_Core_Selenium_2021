import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium2 {

    static String chromeRelativePath = "/resources/drivers/windows/chromedriver.exe";
    static String chromeDriverPath = System.getProperty("user.dir") + chromeRelativePath;

    static String firefoxRelativePath = "/resources/drivers/windows/geckodriver.exe";
    static String firefoxDriverPath = System.getProperty("user.dir") + firefoxRelativePath;

    static WebDriver chromeDriver;
    static WebDriver geckoDriver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

        chromeDriver = new ChromeDriver();
        geckoDriver = new FirefoxDriver();

        chromeDriver.get("https://www.chase.com/");
        geckoDriver.get("https://www.chase.com/");

        chromeDriver.manage().window().maximize();
        geckoDriver.manage().window().maximize();

        String signInButtonLocator = "#homepage-navigation-mbox-ab section.header-navigation__content--left.col-sm-9.col-lg-7 > nav.header-navigation__secondary--menu > ul > li:nth-child(1) > a";

        WebElement chromeSignInButton = chromeDriver.findElement(By.cssSelector(signInButtonLocator));
        WebElement firefoxSignInButton = geckoDriver.findElement(By.cssSelector(signInButtonLocator));

        chromeSignInButton.click();
        firefoxSignInButton.click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        chromeDriver.close();
        chromeDriver.quit();
        geckoDriver.close();
        geckoDriver.quit();

    }

}
