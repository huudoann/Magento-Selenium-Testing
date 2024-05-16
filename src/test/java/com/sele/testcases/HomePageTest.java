package com.sele.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.sele.base.BaseClass;
import com.sele.pageobjects.HomePage;
import com.sele.pageobjects.IndexPage;
import com.sele.pageobjects.LoginPage;
import com.sele.utility.Log;

public class HomePageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
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
	public void wishListTest() throws Throwable{
		Log.startTestCase("wishListTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"), homePage);
		boolean result=homePage.validateWishList();
		Assert.assertTrue(result);
		Log.endTestCase("wishListTest");
	}
	
	@Test(groups = "Smoke")
	public void orderHistoryTest() throws Throwable{
		Log.startTestCase("orderHistoryTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"), homePage);
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
		Log.endTestCase("orderHistoryTest");
	}
}
