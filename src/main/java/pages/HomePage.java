package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    String homepageURL = "https://useinsider.com/";
    String expectedTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(homepageURL);
    }

    public boolean checkHomePage() {
        return driver.getCurrentUrl().equals(homepageURL) && driver.getTitle().equals(expectedTitle);
    }

}
