/*

package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
    WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    By pizzaTab = By.linkText("Pizzas");
    By addRecommendedPizza = By.xpath("//section[contains(.,'Recommended')]//button[contains(.,'Add')]");
    By drinksTab = By.linkText("Drinks");
    By pepsiOption = By.xpath("//div[contains(.,'Pepsi')]/following-sibling::div//button");

    public void clickPizzaTab() {
        driver.findElement(pizzaTab).click();
    }

    public void addPizzaFromRecommended() {
        driver.findElement(addRecommendedPizza).click();
    }

    public void clickDrinksTab() {
        driver.findElement(drinksTab).click();
    }

    public void addPepsiToBasket() {
        driver.findElement(pepsiOption).click();
    }
}

*/