import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class TestSelenium extends Base {

    @Test (priority = 2, enabled = false, dependsOnMethods = "testDoSearch")
    public void testNavigationToSignInPage() {
        WebElement signInButton = driver.findElement(By.cssSelector("#nav-link-accountList"));
        signInButton.click();

        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Amazon Sign-In";

        Assert.assertEquals(actualPageTitle, expectedPageTitle, "SIGN-IN PAGE TITLES DO NOT MATCH");
    }

    @Test (priority = 1, enabled = false)
    public void testDoSearch() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Rokit Monitors");

        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        String actualTitle = driver.getTitle().toLowerCase();
        String expectedTitle = "Amazon.com : rokit monitors".toLowerCase();

        Assert.assertEquals(actualTitle, expectedTitle, "TITLE DOES NOT MATCH");

    }

    @Test(priority = 3)
    public void testNumberOfHeaderNavigationBarLinks() {
        List<WebElement> navBarLinks = driver.findElements(By.cssSelector("#nav-xshop > a.nav-a"));

        int actualNumOfLinks = navBarLinks.size();
        int expectedNumOfLinks = 29;

        Assert.assertEquals(actualNumOfLinks, expectedNumOfLinks, "NUMBER OF LINKS DO NOT MATCH");
    }

    @Test
    public void testNamesOfHeaderNavBarLinks() {
        List<WebElement> navBarLinks = driver.findElements(By.cssSelector("#nav-xshop > a.nav-a"));
        String[] actualNavBarTitles = new String[navBarLinks.size()];

        for (int i = 0; i < navBarLinks.size(); i++) {
            actualNavBarTitles[i] = navBarLinks.get(i).getText();
        }

        String[] expectedNavBarTitles = {"Best Sellers", "Today's Deals", "Prime", "Customer Service", "New Releases", "Books",
                "Fashion", "Kindle Books", "Gift Cards", "Toys & Games", "Amazon Home", "Find a Gift", "Computers",
                "Pharmacy", "Sell", "Registry", "Video Games", "Automotive", "Home Improvement", "Coupons", "Beauty & Personal Care",
                "Smart Home", "Health & Household", "Amazon Basics", "Pet Supplies", "TV & Video", "Handmade",
                "Baby", "#FoundItOnAmazon"};

        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < actualNavBarTitles.length; i++) {
            softAssert.assertEquals(actualNavBarTitles[i], expectedNavBarTitles[i], "TITLE AT THE INDEX OF " + i + " DOES NOT MATCH");
        }

        softAssert.assertAll();
    }


}
