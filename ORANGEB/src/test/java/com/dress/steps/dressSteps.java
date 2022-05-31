package com.dress.steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dress.pages.dressesPages;

import cucumber.api.java.en.*;

public class dressSteps {
	WebDriver driver;
	dressesPages abc; 
	double secondHighest;
	ArrayList<Double> dressPrices;

	@Given("user goes to automationpractice site")
	public void user_goes_to_automationpractice_site() {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		abc = new dressesPages(driver);
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		
		
	}

	@When("user clicks on the dress tab")
	public void user_clicks_on_the_dress_tab() {
	    
	    abc.getDresses().click();
	    
	}

	@When("user capture all dress prices from resultset")
	public void user_capture_all_dress_prices_from_resultset() {
	    
	//List<WebElement>AllDresses = (List<WebElement>)driver.findElements(By.xpath("//*[@class='product-container']/div[2]/div[1]/span[1]"));
	dressPrices = new ArrayList<Double>();
	for(int i = 0; i<abc.getResultset().size(); i++) {
	dressPrices.add(Double.parseDouble(abc.getResultset().get(i).getText().replace("$", "")));
	}
	}

	@When("user add to the cart the second highest price dress")
	public void user_add_to_the_cart_the_second_highest_price_dress() throws Throwable {
	Collections.sort(dressPrices,Collections.reverseOrder());
	secondHighest = dressPrices.get(1);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)", "");
	WebElement secDress =driver.findElement(By.xpath("(//*[contains(text(),'$30.50')])[2]"));
	
	//HOVER
	Actions act = new Actions(driver);
	act.moveToElement(secDress).perform();
	
	//driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div[2]/div[2]/a[1]/span")).click();
	WebElement addCart = driver.findElement(By.xpath("//*[@class='right-block']/div[@class='content_price']/span[contains(text(),'"+dressPrices.get(1)+"')]//following::div[1]/a[1]"));
	addCart.click();
	
	
	WebElement preChe = driver.findElement(By.xpath("//*[contains(text(),'Proceed to checkout')]"));
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(preChe)).click();
	
	
	}

	@Then("user verify the total price including shipping")
	public void user_verify_the_total_price_including_shipping() {
		String totalPrice = driver.findElement(By.xpath("//span[@id='total_price']")).getText();
		Double actualPrice = secondHighest+2;
		String actual = "$"+actualPrice;
		System.out.println(actual);
		System.out.println(totalPrice);
	   Assert.assertTrue("This is not the right price!",totalPrice.contains(actual));
	}
}
