package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCardPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class OrderPageTest extends BaseClass{
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
	
	@Test(groups = "Regression", dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productName, String qty) throws Throwable {
		Log.startTestCase("verifyTotalPrice");
		index = new IndexPage();
		loginPage = index.clickOnSignIn();
		homePage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"), homePage);
		searchResultPage = homePage.searchProduct(productName);
		addToCardPage = searchResultPage.clickOnProduct();
		addToCardPage.enterQuantity(qty);
		addToCardPage.clickOnAddToCart();
	    // Chờ 2 giây trước khi tiếp tục
	    Thread.sleep(2000);
	    addressPage = addToCardPage.clickOnBuyNow();
	    // Chờ 2 giây trước khi tiếp tục
	    Thread.sleep(2000);
	    orderPage = addressPage.clickOnNextBtn();
	    // Chờ 2 giây trước khi tiếp tục
	    Thread.sleep(2000);
		Double unitPrice = orderPage.getUnitPrice();
		Double shippingPrice = orderPage.getShippingPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = unitPrice + shippingPrice;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		Log.endTestCase("verifyTotalPrice");
	}
}
