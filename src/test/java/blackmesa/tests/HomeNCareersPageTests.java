package blackmesa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CareersPage;
import pages.HomePage;

public class HomeNCareersPageTests {
    HomePage homePage;
    CareersPage careersPage;
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        careersPage = new CareersPage(driver);
    }

    @Test
    public void testHomePage() {
        // Navigate to homepage
        homePage.openHomePage();
        // Verify the homepage is opened
        Assert.assertTrue(
                homePage.checkHomePage(),
                "Home page could not be opened."
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

    @Test
    public void testCareerPage() throws InterruptedException {
        homePage.openHomePage();
        careersPage.clickCompany();
        careersPage.clickCareers();
        // Verify the careers page is opened
        Assert.assertTrue(
                careersPage.checkCareersPage(),
                "Careers page could not be opened."
        );
        // Verify the current URL
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://useinsider.com/careers/", "The current URL does not match the expected URL"
        );
        // Verify the page title
        Assert.assertEquals(
                driver.getTitle(), "Ready to disrupt? | Insider Careers", "The title does not match the expected title"
        );

        // Verify the Locations block
        Assert.assertTrue(careersPage.isLocationSectionDisplayed(), "Locations section is not displayed on the page.");
        // Verify the Teams block
        Assert.assertTrue(careersPage.isTeamSectionDisplayed(), "Team section is not displayed on the page.");
        // Verify the Life at Insider block
        Assert.assertTrue(careersPage.islifeatInsiderSectionDisplayed(), "lifeat insider section is not displayed on the page.");
    }

    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}