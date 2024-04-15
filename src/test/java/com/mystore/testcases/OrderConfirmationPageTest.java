package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCardPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

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
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression")
	public void verifyConfirmOrder() throws Throwable {
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
	}
}
