package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass{
	
	Action action = new Action();
	
		
	@FindBy(xpath = "//*[@id=\"KP7SC0F\"]")
	WebElement address;
	
	@FindBy(xpath = "//*[@id=\"LPC3SOB\"]")
	WebElement city;
	
	@FindBy(xpath = "//*[@id=\"RC8HSOC\"]")
	WebElement countryDropDown;
	
	@FindBy(xpath = "//*[@id=\"QQ35CQG\"]")
	WebElement zipCode;
	
	@FindBy(xpath = "//*[@id=\"YIA46Y0\"]")
	WebElement phoneNum;

	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/div/button/span")
	WebElement nextBtn; 
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectDistrict(String countryName) {
        Select countrySelect = new Select(countryDropDown);
        countrySelect.selectByVisibleText(countryName);
    }
	
	public OrderPage clickOnNextBtn() throws Throwable{
		action.click(getDriver(), nextBtn);
		return new OrderPage();
	}
	
}
