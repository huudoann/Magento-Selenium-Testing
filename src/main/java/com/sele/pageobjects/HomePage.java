package com.sele.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sele.actiondriver.Action;
import com.sele.base.BaseClass;

public class HomePage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
	WebElement createMessage;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
	WebElement profileButton;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")
	WebElement accountBtn;
	
	@FindBy(xpath = "//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a")
	WebElement orderHistory;
	
	@FindBy(xpath = "//*[@id=\"block-collapsible-nav\"]/ul/li[4]/a")
	WebElement wishList;
	
	@FindBy(xpath = "//*[@id=\"ui-id-3\"]")
	WebElement homePageBtn;
	
	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement searchField;
	
	@FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
	WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateSuccessCreation() throws Throwable{
		return action.isDisplayed(getDriver(), createMessage);
	}
	
	public boolean validateWishList() throws Throwable{
		action.click(getDriver(), profileButton);
		action.click(getDriver(), accountBtn);
		action.implicitWait(getDriver(), 5);
		return action.isDisplayed(getDriver(), wishList);
	}
	
	public boolean validateOrderHistory() throws Throwable{
		action.click(getDriver(), profileButton);
		action.click(getDriver(), accountBtn);
		action.implicitWait(getDriver(), 5);
		return action.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrURL() {
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable{
		action.type(searchField, productName);
		searchField.sendKeys(Keys.ENTER);
		return new SearchResultPage();
	}
}
