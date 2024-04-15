package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCardPage extends BaseClass{
	
	Action action = new Action();
	WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"qty\"]")
	WebElement quantity;
	
	@FindBy(xpath = "//*[@id=\"option-label-size-143-item-166\"]")
	WebElement size;
	
	@FindBy(xpath = "//*[@id=\"option-label-color-93-item-50\"]")
	WebElement color;
	
	@FindBy(xpath = "//*[@id=\"product-addtocart-button\"]")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a/span[2]")
	WebElement showCart;
	
	@FindBy(xpath = "//*[@id=\"top-cart-btn-checkout\"]")
	WebElement checkOutBtn;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
	WebElement successMessage;
	
	public AddToCardPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantities) throws Throwable{
		action.click(getDriver(), size);
		action.click(getDriver(), color);
		action.type(quantity, quantities);
	}
	
	public void clickOnAddToCart() {
		action.click(getDriver(), addToCartBtn);
	}	
	
	public boolean validateAddtoCart() throws Throwable{
		return action.isDisplayed(getDriver(), successMessage);
	}
	
	
	public AddressPage clickOnBuyNow() throws Throwable{
		action.fluentWait(getDriver(), addToCartBtn, 5);
		action.implicitWait(getDriver(), 5);
		action.click(getDriver(), showCart);
		action.JSClick(getDriver(), checkOutBtn);
		return new AddressPage();
		
	}
}
