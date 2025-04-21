
/*
package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By closePopup = By.xpath("//button[contains(@aria-label,'close')]");
    By locationInput = By.id("locationInput");
    By firstAutoOption = By.cssSelector("ul li[data-testid='location-item']");

    public void closeBlackPopup() {
        try {
            driver.findElement(closePopup).click();
        } catch (Exception e) {
            // Popup not found
        }
    }

    public void enterLocation(String location) {
        driver.findElement(locationInput).sendKeys(location);
    }

    public void selectFirstAutoSuggestion() {
        driver.findElement(firstAutoOption).click();
    }
}

*/
