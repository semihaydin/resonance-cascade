package pages;

import org.openqa.selenium.WebDriver;

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
