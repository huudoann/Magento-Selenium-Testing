package com.sele.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.sele.actiondriver.Action;
import com.sele.base.BaseClass;
import com.sele.pageobjects.AddToCardPage;
import com.sele.pageobjects.AddressPage;
import com.sele.pageobjects.HomePage;
import com.sele.pageobjects.IndexPage;
import com.sele.pageobjects.LoginPage;
import com.sele.pageobjects.OrderConfirmationPage;
import com.sele.pageobjects.OrderPage;
import com.sele.pageobjects.SearchResultPage;
import com.sele.utility.Log;

public class OrderConfirmationPageTest extends BaseClass{
	IndexPage index;
	SearchResultPage searchResultPage;
	LoginPage loginPage;
	AddToCardPage addToCardPage;
	HomePage homePage;
	OrderPage orderPage;
	AddressPage addressPage;
	OrderConfirmationPage orderConfirmationPage;
	Action action;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(@Optional("Edge") String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression")
	public void verifyConfirmOrder() throws Throwable {
		Log.startTestCase("verifyConfirmOrder");
		index = new IndexPage();
		loginPage = index.clickOnSignIn();
		homePage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"), homePage);
		searchResultPage = homePage.searchProduct("Shirt");
		addToCardPage = searchResultPage.clickOnProduct();
		addToCardPage.enterQuantity("1");
		addToCardPage.clickOnAddToCart();
		Thread.sleep(2000);
		addressPage = addToCardPage.clickOnBuyNow();
		Thread.sleep(2000);
		orderPage = addressPage.clickOnNextBtn();
		Thread.sleep(2000);
		orderConfirmationPage = orderPage.clickOnCheckOutBtn();
		Thread.sleep(2000);
		boolean result = orderConfirmationPage.validateOrderMessage();
		Assert.assertTrue(result);
		Log.endTestCase("verifyConfirmOrder");
	}
}
