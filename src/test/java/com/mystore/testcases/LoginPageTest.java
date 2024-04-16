package com.mystore.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(@Optional("Edge") String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups = {"Smoke","Sanity"}, dataProvider = "Credentials", dataProviderClass = DataProviders.class)
	
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.signIn(uname,pswd,homePage);
	    String actualURL=homePage.getCurrURL();
	    String expectedURL1="http://automationpractice.com/index.php?controller=my-account";
	    String expectedURL2="https://magento.softwaretestingboard.com/";
	    Assert.assertTrue(actualURL.equals(expectedURL1) || actualURL.equals(expectedURL2), "Actual URL is neither expected URL1 nor expected URL2");
	    Log.info("Login is Sucess");
	    Log.endTestCase("loginTest");
	}

}