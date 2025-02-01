package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class QualityAssurancePage {
    WebDriver driver;
    String qaPageURL = "https://useinsider.com/careers/quality-assurance/";
    String qaPageTitle = "Insider quality assurance job opportunities";
    String leverPageURL ="https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc";
    String expectedDepartment = "Quality Assurance";
    String expectedLocation = "Istanbul, Turkey";
    private final By qaJobsButton = By.cssSelector("#page-head > div > div > div.col-12.col-lg-7.order-2.order-lg-1 > div > div > a");
    private final By locationFilter = By.cssSelector("#top-filter-form > div:nth-child(1) > span > span.selection > span");
    private final By iTurkey = By.xpath("//select[@id='filter-by-location']//option[text()='Istanbul, Turkey']");
    private final By filterByDepartment = By.cssSelector("#select2-filter-by-department-container");
    private final By qualityAssurance = By.xpath("//select[@id='filter-by-department']//option[text()='Quality Assurance']");
    private final By acceptAllCookiesBtn = By.xpath("//a[@id='wt-cli-accept-all-btn']");
    private final By jobLink = By.xpath("//a[contains(text(),'View Role')]");

    protected String  javaScriptGetInnerText(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].innerText;", element);
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public QualityAssurancePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToQualityAssurancePage() {
        driver.get(qaPageURL);
        driver.getCurrentUrl().equals(qaPageURL);
        driver.getTitle().equals(qaPageTitle);
        waitFor(2);
    }

    public void clickSeeAllQAJobs() {
        driver.findElement(acceptAllCookiesBtn).click();
        driver.findElement(qaJobsButton).click();
    }

    public void filterJobsByIstanbulTurkeyNQA() {
        waitFor(15);
        driver.findElement(locationFilter).click();
        waitFor(2);
        driver.findElement(iTurkey).click();
        driver.findElement(filterByDepartment).click();
        driver.findElement(qualityAssurance).click();
        waitFor(5);
    }

    public void validateJobListings() {
        List<WebElement> jobsDetailsDepartment = driver.findElements(By.xpath("//span[contains(@class, 'position-department')]"));
        List<WebElement> jobsDetailsLocation = driver.findElements(By.xpath("//div[contains(@class, 'position-location')]"));

        List<String> errors = new ArrayList<>();

        for (int i = 0; i < jobsDetailsDepartment.size(); i++) {
            String jobDepartment = javaScriptGetInnerText(jobsDetailsDepartment.get(i)).trim();
            String jobLocation = javaScriptGetInnerText(jobsDetailsLocation.get(i)).trim();

            if (!jobDepartment.equals(expectedDepartment)) {
                errors.add("Job at index " + i + " has incorrect department. Expected: '" + expectedDepartment + "', Found: '" + jobDepartment + "'");
            }

            if (!jobLocation.equals(expectedLocation)) {
                errors.add("Job at index " + i + " has incorrect location. Expected: '" + expectedLocation + "', Found: '" + jobLocation + "'");
            }
        }

        if (!errors.isEmpty()) {
            throw new RuntimeException("Job list validation failed: \n" + String.join("\n", errors));
        }
        System.out.println("All jobs were successfully validated");
    }

    public void checkLeverPage() {
        waitFor(5);
        driver.findElement(jobLink).click();
        String mainWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                waitFor(5);
            }
        }
        driver.getCurrentUrl().equals(leverPageURL);
    }
}
