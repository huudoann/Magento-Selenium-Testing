package com.sele.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.sele.base.BaseClass;
import com.sele.pageobjects.AccountCreationPage;
import com.sele.pageobjects.HomePage;
import com.sele.pageobjects.IndexPage;
import com.sele.utility.Log;

public class AccountCreationPageTest extends BaseClass{
	IndexPage indexPage;
	AccountCreationPage accountCreationPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(@Optional("Edge") String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyAccountCreationPageTest() throws Throwable{
		Log.startTestCase("verifyAccountCreactionPageTest");
		indexPage = new IndexPage();
		accountCreationPage = indexPage.clickOnSignUp();
		boolean result= accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);
		Log.endTestCase("verifyAccountCreactionPageTest");
	}
	
	@Test(groups = { "Sanity" })
	public void signUpTest() throws Throwable{
		Log.startTestCase("signUpTest");
		indexPage = new IndexPage();
		accountCreationPage = indexPage.clickOnSignUp();
	    homePage = accountCreationPage.signUpNewAccount(prop.getProperty("firstName"), prop.getProperty("lastName"), prop.getProperty("email"), prop.getProperty("pswd"), prop.getProperty("pswd"), homePage);
		String actualURL = homePage.getCurrURL();
		Assert.assertEquals(actualURL, "https://magento.softwaretestingboard.com/customer/account/");
		Log.endTestCase("signUpTest");
	}
}
