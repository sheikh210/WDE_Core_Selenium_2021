import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Base {

    static String relativePath = "/resources/drivers/windows/chromedriver.exe";
    static String chromeDriverPath = System.getProperty("user.dir") + relativePath;
    static WebDriver driver;
    private final String URL = "https://www.amazon.com";


    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod");
        driver.close();
        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();

        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass");
    }
}
