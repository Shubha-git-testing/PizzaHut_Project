/*

package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
    WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    By itemCount = By.cssSelector("[data-testid='basket-count']");
    By totalPrice = By.cssSelector("[data-testid='basket-total']");
    By removePizzaBtn = By.xpath("//div[contains(.,'Pizza')]/..//button[contains(.,'Remove')]");
    By checkoutBtn = By.xpath("//button[contains(.,'Checkout')]");

    public boolean isItemCountVisible() {
        return driver.findElement(itemCount).isDisplayed();
    }

    public boolean isTotalPriceVisible() {
        return driver.findElement(totalPrice).isDisplayed();
    }

    public void removePizza() {
        driver.findElement(removePizzaBtn).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
*/