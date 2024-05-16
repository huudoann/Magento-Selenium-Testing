package com.sele.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.sele.actiondriver.Action;
import com.sele.base.BaseClass;
import com.sele.dataprovider.DataProviders;
import com.sele.pageobjects.AddToCardPage;
import com.sele.pageobjects.AddressPage;
import com.sele.pageobjects.HomePage;
import com.sele.pageobjects.IndexPage;
import com.sele.pageobjects.LoginPage;
import com.sele.pageobjects.OrderConfirmationPage;
import com.sele.pageobjects.OrderPage;
import com.sele.pageobjects.SearchResultPage;
import com.sele.utility.Log;

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
	public void setup(@Optional("Edge")String browser) {
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
