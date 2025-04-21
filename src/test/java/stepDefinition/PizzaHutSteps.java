package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class PizzaHutSteps {

	  
	    WebDriver driver;						//Global Variable
	   


	    @Given("User launch Pizzahut application with {string}")
	    public void user_launch_pizzahut_application_with(String url) {
	        System.setProperty("webdriver.gecko.driver", "D://Selenium//geckodriver-v0.34.0-win64//geckodriver.exe");

	        FirefoxProfile profile = new FirefoxProfile();
	        profile.setPreference("geo.prompt.testing", true);
	        profile.setPreference("geo.prompt.testing.allow", false); // false = deny location access
	        profile.setPreference("permissions.default.geo", 2); // 2 = deny all location access
	        profile.setPreference("dom.webnotifications.enabled", false); // optional: disable notifications too

	        FirefoxOptions options = new FirefoxOptions();
	        options.setProfile(profile);

	        driver = new FirefoxDriver(options);
	        driver.manage().window().maximize();
	        driver.get(url);
	    }
	    @When("User wait for auto location black pop up screen")
	    public void user_wait_for_auto_location_black_pop_up_screen() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='blackScreenWrapper']")));
	        } catch (Exception e) {
	            System.out.println("Auto location popup not found. Continuing...");
	        }
	    }

	    @Then("User close the pop up screen")
	    public void user_close_the_pop_up_screen() {
	        try {
	            WebElement closeButton = driver.findElement(By.cssSelector("div[class*='blackScreenWrapper'] button"));
	            if (closeButton.isDisplayed()) {
	                closeButton.click();
	            }
	        } catch (Exception e) {
	            System.out.println("Close button not found. Possibly already closed.");
	        }
	    }  
	    

@Then("User type address as {string}") 
public void user_type_address_as(String location) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    // Wait for address input field to be visible
    WebElement addressInput = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter your location for delivery']")));
    			addressInput.sendKeys(location);
    			Thread.sleep(2000);
    		/*	addressInput.sendKeys(Keys.ARROW_DOWN);
    			Thread.sleep(2000);  */
    			 addressInput.sendKeys(Keys.ENTER);
    			}
@And("User select first auto populate drop down option")
public void user_select_first_auto_populate_drop_down_option() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    // Wait for the div containing the first dropdown suggestion to be clickable
    WebElement firstSuggestion = wait.until(ExpectedConditions
        .elementToBeClickable(By.cssSelector("div.justify-between:nth-child(6)")));

    // Click the suggestion
    firstSuggestion.click();
}
@When("User navigate to deals page")
public void user_navigate_to_deals_page() {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logo")));
}

@Then("User validate vegetarian radio button flag is off")
public void user_validate_vegetarian_radio_button_flag_is_off() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement vegToggle = wait.until(ExpectedConditions.presenceOfElementLocated(
       By.xpath("//div[@class='w-full bg-white border-t py-5 justify-end md:hidden lg:flex 2xl:hidden']//span[@class='rounded-full bg-white']")));

        boolean isChecked = vegToggle.getAttribute("checked") != null;

        if (isChecked) {
            System.out.println("Vegetarian toggle is ON - Test Failed");
        } else {
            System.out.println("Vegetarian toggle is OFF - Test Passed");
        }

    } catch (Exception e) {
        System.out.println("Vegetarian toggle not found or error occurred: " + e.getMessage());
    }
}

@And ("User clicks on Pizzas menu bar option")
public void user_clicks_on_Pizzas_menu_bar_option() {
	
	
	
	WebElement pizzaMenu=driver.findElement(By.cssSelector("a[data-synth='link--pizzas--side'] span"));
	pizzaMenu.click();
}


@When ("User select add button of any pizza from Recommended")
public void user_select_add_button_of_any_pizza_from_Recommended() {

Actions actions = new Actions(driver);
// Scroll down by a specified amount
actions.scrollByAmount(0, 500).perform();

WebElement pizzaMenu=driver.findElement(By.xpath("(//span)[46]"));
//(By.xpath("//body/div[@id='app']/div[@class='app en-IN app-bg']/div[@class='order']/div[@class='basket-placeholder']/div[@class='flex lg:flex-col']/div[@class='w-full side-menu-placeholder md:pt-60 lg:pt-0']/div[@class='container md:pt-5']/span[@data-testid='pizzas']/div[1]/a[1]/div[3]/div[1]/button[1]/span[1]"));
}

//Step: Add pizza from Recommended
@When("User select add button of any pizza from Recommended")
public void user_select_add_button_of_any_pizza_from_recommended() {
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
 WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
     By.xpath("(//div[contains(text(),'Recommended')]/ancestor::section//button[contains(text(),'Add')])[1]")));
 addButton.click();
}
/*
//Step: Validate item appears in Your Basket
@Then("User see that the pizza is getting added under Your Basket")
public void user_see_that_the_pizza_is_getting_added_under_your_basket() {
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement basketItem = wait.until(ExpectedConditions.visibilityOfElementLocated(
     By.xpath("//a[contains(@class,'justify-between')]//span[contains(@class,'absolute inset-0 flex-center')]")));
 System.out.println("Pizza added to basket: " + basketItem.isDisplayed());
}
/*
//Step: Validate pizza price + Tax equals checkout price
@And("User validate pizza price plus Tax is checkout price")
public void user_validate_pizza_price_plus_tax_is_checkout_price() {
 try {
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     WebElement pizzaPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
         By.cssSelector("span[data-testid='basket-item-price']")));

     WebElement taxElement = driver.findElement(By.cssSelector("span[data-testid='taxAmount']"));
     WebElement checkoutPriceElement = driver.findElement(By.cssSelector("span[data-testid='checkout-total']"));

     double pizzaPrice = Double.parseDouble(pizzaPriceElement.getText().replaceAll("[^0-9.]", ""));
     double tax = Double.parseDouble(taxElement.getText().replaceAll("[^0-9.]", ""));
     double checkoutPrice = Double.parseDouble(checkoutPriceElement.getText().replaceAll("[^0-9.]", ""));

     if (Math.abs((pizzaPrice + tax) - checkoutPrice) < 0.5) {
         System.out.println("Pizza price + tax matches checkout price.");
     } else {
         System.out.println("Mismatch: Pizza price + tax doesn't match checkout price.");
     }
 } catch (Exception e) {
     System.out.println("Error during price verification: " + e.getMessage());
 }
}

//Step: Validate checkout button contains item count
@Then("User validate checkout button contains Item count")
public void user_validate_checkout_button_contains_item_count() {
 WebElement checkoutButton = driver.findElement(By.cssSelector("button[data-testid='checkout-button']"));
 String text = checkoutButton.getText();
 if (text.contains("1 Item")) {
     System.out.println("Checkout button correctly shows 1 item.");
 } else {
     System.out.println("Unexpected item count: " + text);
 }
}

//Step: Validate checkout button contains total price
@And("User validate checkout button contains total price count")
public void user_validate_checkout_button_contains_total_price_count() {
 WebElement checkoutButton = driver.findElement(By.cssSelector("button[data-testid='checkout-button']"));
 String text = checkoutButton.getText();
 if (text.matches(".*\\₹[0-9]+.*")) {
     System.out.println("Checkout button shows total price: " + text);
 } else {
     System.out.println("Total price not found in checkout button.");
 }
}

//Step: Click on Drinks menu
@Then("User clicks on Drinks option")
public void user_clicks_on_drinks_option() {
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement drinksTab = wait.until(ExpectedConditions.elementToBeClickable(
     By.xpath("//span[contains(text(),'Drinks')]")));
 drinksTab.click();
}

//Step: Add Pepsi
@And("User select Pepsi option to add into the Basket")
public void user_select_pepsi_option_to_add_into_the_basket() {
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement pepsiAdd = wait.until(ExpectedConditions.elementToBeClickable(
     By.xpath("//div[contains(text(),'Pepsi')]/ancestor::div[contains(@class,'itemCard')]//button[contains(text(),'Add')]")));
 pepsiAdd.click();
}

//Step: Validate 2 items in basket
@Then("User see 2 items are showing under checkout button")
public void user_see_2_items_are_showing_under_checkout_button() {
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
     By.cssSelector("button[data-testid='checkout-button']")));

 String text = checkoutButton.getText();
 if (text.contains("2 Items")) {
     System.out.println("2 items are correctly shown in checkout.");
 } else {
     System.out.println("Expected 2 items, but got: " + text);
 }
}

//Step: Validate total price is updated
@And("User see total price is now more than before")
public void user_see_total_price_is_now_more_than_before() {
 WebElement checkoutPriceElement = driver.findElement(By.cssSelector("span[data-testid='checkout-total']"));
 String totalText = checkoutPriceElement.getText();
 System.out.println("New total price after Pepsi added: " + totalText);
 // Optional: Store earlier price and compare
}

//Step: Remove Pizza from Basket
@Then("User remove the Pizza item from Basket")
public void user_remove_the_pizza_item_from_basket() {
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(
     By.xpath("(//button[contains(text(),'Remove')])[1]")));
 removeButton.click();
}

//Step: Validate pizza removed from checkout price
@And("see Price tag got removed from the checkout button")
public void see_price_tag_got_removed_from_the_checkout_button() {
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
     By.cssSelector("button[data-testid='checkout-button']")));
 String text = checkoutButton.getText();
 System.out.println("Checkout after pizza removal: " + text);
}

//Step: Validate 1 item in checkout
@And("User see 1 item showing in checkout button")
public void user_see_1_item_showing_in_checkout_button() {
 WebElement checkoutButton = driver.findElement(By.cssSelector("button[data-testid='checkout-button']"));
 if (checkoutButton.getText().contains("1 Item")) {
     System.out.println("1 item remaining in checkout.");
 } else {
     System.out.println("Unexpected item count.");
 }
}

//Step: Click Checkout button
@Then("User Clicks on Checkout button")
public void user_clicks_on_checkout_button() {
 WebElement checkoutButton = driver.findElement(By.cssSelector("button[data-testid='checkout-button']"));
 checkoutButton.click();
}

//Step: Validate minimum order popup
@And("User see minimum order required pop up is getting displayed")
public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement errorPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
     By.xpath("//div[contains(text(),'minimum order')]")));
 if (errorPopup.isDisplayed()) {
     System.out.println("Minimum order popup is displayed successfully.");
 } else {
     System.out.println("Minimum order popup not found.");
 }
}

	*/
	
	
	}






	
	

	
	
	

