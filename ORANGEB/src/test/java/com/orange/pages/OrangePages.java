package com.orange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrangePages {
	WebDriver driver;

	public OrangePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(how = How.XPATH, using= "//input[@id='txtUsername']")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}
	
	@FindBy(how = How.XPATH, using= "//input[@name='txtPassword']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}
	
	@FindBy(how = How.XPATH, using= "//input[@type='submit']")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}
	
	@FindBy(how = How.ID, using= "welcome")
	private WebElement welcomeText;

	public WebElement getWelcomeText() {
		return welcomeText;
	}

	public void setWelcomeText(WebElement welcomeText) {
		this.welcomeText = welcomeText;
	}
}
