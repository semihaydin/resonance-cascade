package blackmesa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;

public class HomeNCareersPageTests {
    HomePage homePage;
    CareersPage careersPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        careersPage = new CareersPage();
    }

    @Test
    public void testHomePage() {
        // Navigate to homepage
        homePage.openHomePage();
        // Verify the homepage is opened
        Assert.assertTrue(
                homePage.checkHomePage(),
                "Home page is could not be opened."
        );
        // Verify the current URL
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://useinsider.com/", "The current URL does not match the expected URL"
        );
        // Verify the page title
        Assert.assertEquals(
                driver.getTitle(), "#1 Leader in Individualized, Cross-Channel CX — Insider", "The title does not match the expected title"
        );
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}