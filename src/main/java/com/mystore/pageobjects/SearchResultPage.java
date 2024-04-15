package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/div[2]/ol/li[1]/div/a")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable{
		return action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCardPage clickOnProduct() throws Throwable{
		action.click(getDriver(), productResult);
		return new AddToCardPage();
	}
	
}
