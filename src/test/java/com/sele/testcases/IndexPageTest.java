package com.sele.testcases;

import org.testng.annotations.*;
import org.testng.Assert;

import com.sele.base.BaseClass;
import com.sele.pageobjects.IndexPage;
import com.sele.utility.Log;

public class IndexPageTest extends BaseClass{
	private IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(@Optional("Edge") String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable{
		Log.startTestCase("verifyLogo");
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String title = indexPage.getStoreTitle();
		Assert.assertEquals(title, "Home Page");
		Log.endTestCase("verifyTitle");
	}
}
