package com.orange.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

import com.orange.pages.OrangePages;

import cucumber.api.java.en.*;

public class OrangeSteps {
	WebDriver driver;
	OrangePages obj;
	
	@Given("^user go to Orange HRM page site$")
	public void user_go_to_Orange_HRM_page_site() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		obj = new OrangePages(driver);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user type the username$")
	public void user_type_the_username() throws Throwable {
		obj.getUsername().sendKeys("Admin");
	    
	}

	@When("^user type the password$")
	public void user_type_the_password() throws Throwable {
		obj.getPassword().sendKeys(("admin123"));
	    
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
		obj.getLoginButton().click();
	    
	}

	@Then("^user verify the welcome screen$")
	public void user_verify_the_welcome_screen() throws Throwable {
		   String expected = "Welcome";
		   String actual = obj.getWelcomeText().getText();
		   Assert.assertTrue(actual.contains(expected));
		       
	    
	}

}
