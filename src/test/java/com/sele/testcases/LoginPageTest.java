package com.sele.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sele.base.BaseClass;
import com.sele.dataprovider.DataProviders;
import com.sele.pageobjects.HomePage;
import com.sele.pageobjects.IndexPage;
import com.sele.pageobjects.LoginPage;
import com.sele.utility.Log;

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
		Assert.assertTrue(actualURL.equals(expectedURL1) || actualURL.equals(expectedURL2), "Your username or password may be wrong!");
	    Log.info("Login is Sucess");
	    Log.endTestCase("loginTest");
	}

}