package com.sele.actioninterface;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	
	//Added all user actions abstract methods to achieve Abstraction  
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);
	public void click(WebDriver ldriver, WebElement ele);
	public boolean isDisplayed(WebDriver ldriver, WebElement ele);

	boolean isSelected(WebDriver driver, WebElement ele);

	boolean isEnabled(WebDriver driver, WebElement ele);

	public boolean type(WebElement ele, String text);
	public boolean findElement(WebDriver ldriver, WebElement ele);

	boolean selectBySendkeys(String value, WebElement ele);

	boolean selectByIndex(WebElement element, int index);

	boolean selectByValue(WebElement element, String value);

	boolean selectByVisibleText(String visibletext, WebElement ele);

	public boolean JSClick(WebDriver driver, WebElement ele);

	boolean moveToElement(WebDriver driver, WebElement ele);

	boolean rightclick(WebDriver driver, WebElement ele);

	boolean switchToNewWindow(WebDriver driver);

	public int getColumncount(WebElement row);
	public int getRowCount(WebElement table);
	public boolean launchUrl(WebDriver driver,String url);
	public String getCurrentURL(WebDriver driver);
	public String getTitle(WebDriver driver);
	public boolean click1(WebElement locator, String locatorName);
	public void fluentWait(WebDriver driver,WebElement element, int timeOut);
	public void implicitWait(WebDriver driver, int timeOut);
	public void pageLoadTimeOut(WebDriver driver, int timeOut);
	public String screenShot(WebDriver driver, String filename);
	public String getCurrentTime();
	public void explicitWait(WebDriver driver, WebElement element, Duration timeOut);

}
