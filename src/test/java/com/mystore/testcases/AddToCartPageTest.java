package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCardPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private LoginPage loginPage;
	private AddToCardPage addToCardPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = { "Sanity", "Regression"})
	public void addToCartTest() throws Throwable {
		index = new IndexPage();
		loginPage = index.clickOnSignIn();
		homePage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"), homePage);
		searchResultPage = homePage.searchProduct("T-Shirt");
		addToCardPage = searchResultPage.clickOnProduct();
		addToCardPage.enterQuantity("2");
		Thread.sleep(3000);
		addToCardPage.clickOnAddToCart();
		boolean result = addToCardPage.validateAddtoCart();
		Assert.assertTrue(result);
	}
}
