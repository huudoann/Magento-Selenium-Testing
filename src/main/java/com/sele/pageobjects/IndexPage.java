package com.sele.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sele.actiondriver.Action;
import com.sele.base.BaseClass;

public class IndexPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
	WebElement signInBtn;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
	WebElement signUpBtn;

	@FindBy(xpath = "/html/body/div[2]/header/div[2]/a/img")
	WebElement storeLogo;

	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement searchProductBox;

	@FindBy(className = "//*[@id=\"search_mini_form\"]/div[2]/button")
	WebElement searchButton;

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage clickOnSignIn() throws Throwable {
		action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public AccountCreationPage clickOnSignUp() throws Throwable {
		action.click(getDriver(), signUpBtn);
		return new AccountCreationPage();
	}

	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), storeLogo);
	}
	
	public String getStoreTitle() {
		String storeTitle = getDriver().getTitle();
		return storeTitle;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable{
		action.type(searchProductBox, productName);
		searchProductBox.sendKeys(Keys.ENTER);
		return new SearchResultPage();
	}
}
