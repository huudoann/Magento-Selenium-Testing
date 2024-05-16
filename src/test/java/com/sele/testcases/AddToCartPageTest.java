package com.sele.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.sele.base.BaseClass;
import com.sele.pageobjects.AddToCardPage;
import com.sele.pageobjects.HomePage;
import com.sele.pageobjects.IndexPage;
import com.sele.pageobjects.LoginPage;
import com.sele.pageobjects.SearchResultPage;
import com.sele.utility.Log;

public class AddToCartPageTest extends BaseClass{
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private LoginPage loginPage;
	private AddToCardPage addToCardPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(@Optional("Edge") String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = { "Sanity", "Regression"})
	public void addToCartTest() throws Throwable {
		Log.startTestCase("addToCartPageTest");
		index = new IndexPage();
		loginPage = index.clickOnSignIn();
		homePage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"), homePage);
		searchResultPage = homePage.searchProduct("T-Shirt");
		addToCardPage = searchResultPage.clickOnProduct();
		addToCardPage.enterQuantity("1");
		Thread.sleep(3000);
		addToCardPage.clickOnAddToCart();
		boolean result = addToCardPage.validateAddtoCart();
		Assert.assertTrue(result);
		Log.endTestCase("addToCartPageTest");
	}
}
