package com.sele.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sele.actiondriver.Action;
import com.sele.base.BaseClass;

public class SearchResultPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "/html/body/div[2]/main/div[3]/div[1]/div[2]/div[2]/ol/li[1]")
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
