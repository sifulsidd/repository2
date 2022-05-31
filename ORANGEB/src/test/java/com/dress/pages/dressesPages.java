package com.dress.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class dressesPages {
	WebDriver driver;

	public dressesPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(how = How.XPATH, using= "(//*[@class='sf-with-ul'])[4]")
	private WebElement dresses;
	
	@FindBy(how= How.XPATH, using=("//*[@class='product-container']/div[2]/div[1]/span[1]"))
	private List<WebElement> resultset;

	
	
	
	public List<WebElement> getResultset() {
		return resultset;
	}



	public void setResultset(List<WebElement> resultset) {
		this.resultset = resultset;
	}



	public WebElement getDresses() { 
		return dresses;
	}



	public void setDresses(WebElement dresses) {
		this.dresses = dresses;
	}
	
}
