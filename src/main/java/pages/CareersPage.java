package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareersPage {
    WebDriver driver;
    String careersURL = "https://useinsider.com/careers/";
    String expectedTitle = "Ready to disrupt? | Insider Careers";

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCompany() {

        WebElement companyMenuItem = driver.findElement(By.linkText("Company"));
        companyMenuItem.click();
    }

    public void clickCareers() {
        WebElement companyMenuItem = driver.findElement(By.linkText("Careers"));
        companyMenuItem.click();
    }

    public boolean checkCareersPage() {
        return driver.getCurrentUrl().equals(careersURL) && driver.getTitle().equals(expectedTitle);
    }

    private final By locationsBlock = By.cssSelector("[data-id='8ab30be']");

    public boolean isLocationSectionDisplayed() {
        return driver.findElement(locationsBlock).isDisplayed();
    }

    private final By teamsBlock = By.cssSelector("[data-id='b6c45b2']");

    public boolean isTeamSectionDisplayed() {
        return driver.findElement(teamsBlock).isDisplayed();
    }

    private final By lifeatInsiderBlock = By.cssSelector("[data-id='a8e7b90']");

    public boolean islifeatInsiderSectionDisplayed() {
        return driver.findElement(lifeatInsiderBlock).isDisplayed();
    }
}


