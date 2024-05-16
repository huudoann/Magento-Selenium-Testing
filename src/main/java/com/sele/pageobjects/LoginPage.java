package com.sele.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sele.actiondriver.Action;
import com.sele.base.BaseClass;

public class LoginPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement userName;
	
	@FindBy(xpath = "//*[@id=\"pass\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"send2\"]/span")
	WebElement signInBtn;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[2]/div[2]/div/div/a/span")
	WebElement createAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterUserName(String uname) {
		action.type(userName, uname);
	}
	
	public void enterPassword(String pswd) {
		action.type(password, pswd);
	}
	
	public HomePage signIn(String uname, String pswd, HomePage homePage) throws Throwable{
		enterUserName(uname);
		enterPassword(pswd);
	    action.JSClick(getDriver(), signInBtn);
		homePage = new HomePage();
		return homePage;
	}
	
	public AccountCreationPage createNewAccount() throws Throwable{
		action.click(getDriver(), createAccountBtn);
		return new AccountCreationPage();
	}
}
