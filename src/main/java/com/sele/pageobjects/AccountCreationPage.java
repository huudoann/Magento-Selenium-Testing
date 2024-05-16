package com.sele.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sele.actiondriver.Action;
import com.sele.base.BaseClass;

public class AccountCreationPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span")
	WebElement formTitle;
	
	@FindBy(xpath = "//*[@id=\"firstname\"]")
	WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"lastname\"]")
	WebElement lastName;
	
	@FindBy(xpath = "//*[@id=\"email_address\"]")
	WebElement emailAdress;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "password-confirmation")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button/span")
	WebElement createNewAccountBtn;

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateAccountCreatePage() throws Throwable {
		return action.isDisplayed(getDriver(), formTitle);
	}

	public HomePage signUpNewAccount(String firstN, String lastN, String email, String pswd, String confpswd, HomePage homePage) throws Throwable{
		action.type(firstName, firstN);
		action.type(lastName, lastN);
		action.type(emailAdress, email);
		Thread.sleep(3000);
		action.type(password, pswd);
		Thread.sleep(3000);
		action.type(confirmPassword, confpswd);
		action.click(getDriver(), createNewAccountBtn);
		homePage = new HomePage();
		return homePage;
	}
}
