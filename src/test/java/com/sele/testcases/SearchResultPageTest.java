/**
 * 
 */
package com.sele.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.sele.base.BaseClass;
import com.sele.pageobjects.HomePage;
import com.sele.pageobjects.IndexPage;
import com.sele.pageobjects.SearchResultPage;
import com.sele.utility.Log;

/**
 * 
 */
public class SearchResultPageTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(@Optional("Edge")String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void productAvailabilityTest() throws Throwable{
		Log.startTestCase("productAvalabilityTest");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("Shirt");
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("productAvalabilityTest");
	}
}
