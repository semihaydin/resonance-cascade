package blackmesa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CareersPage;
import pages.HomePage;
import pages.QualityAssurancePage;

public class TestBase {
    HomePage homePage;
    CareersPage careersPage;
    QualityAssurancePage qualityAssurancePage;
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        careersPage = new CareersPage(driver);
        qualityAssurancePage = new QualityAssurancePage(driver);
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
        System.out.println("Homepage tests passed.");
    }

    @Test
    public void testCareerPage() {
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
        System.out.println("Career page tests passed.");
    }

    @Test
    public void testQualityAssurancePage() {
        qualityAssurancePage.goToQualityAssurancePage();
        qualityAssurancePage.clickSeeAllQAJobs();
        qualityAssurancePage.filterJobsByIstanbulTurkeyNQA();
        qualityAssurancePage.validateJobListings();
        qualityAssurancePage.checkLeverPage();
        System.out.println("Quality Assurance page tests passed.");
    }

    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}