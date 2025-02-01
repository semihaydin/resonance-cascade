package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareersPage {
    WebDriver driver;
    private final By locationsBlock = By.cssSelector("#career-our-location > div > div > div > div.col-12.col-md-6 > p");
    private final By teamsBlock = By.cssSelector("[data-id='b6c45b2']");
    private final By lifeatInsiderBlock = By.cssSelector("[data-id='a8e7b90']");
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

    public boolean isLocationSectionDisplayed() {
        return driver.findElement(locationsBlock).isDisplayed();
    }


    public boolean isTeamSectionDisplayed() {
        return driver.findElement(teamsBlock).isDisplayed();
    }


    public boolean islifeatInsiderSectionDisplayed() {
        return driver.findElement(lifeatInsiderBlock).isDisplayed();
    }
}


