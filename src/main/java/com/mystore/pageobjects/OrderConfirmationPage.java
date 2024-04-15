package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span")
	WebElement orderConfirmationMessage;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateOrderMessage() throws Throwable{
		return action.isDisplayed(getDriver(), orderConfirmationMessage);
	}
	
}
