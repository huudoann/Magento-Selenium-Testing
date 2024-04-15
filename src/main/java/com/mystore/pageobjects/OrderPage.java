package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[1]/td/span")
	WebElement unitPrice;
	
	@FindBy(xpath = "//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[2]/td/span")
	WebElement shippingPrice;
	
	@FindBy(xpath = "//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[3]/td/strong/span")
	WebElement totalPrice;
	
	@FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span")
	WebElement checkOutBtn;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		String uPrice = unitPrice.getText();
		String unit = uPrice.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice;
	}
	
	public double getShippingPrice() {
		String shipPrice = shippingPrice.getText();
		String ship = shipPrice.replaceAll("[^a-zA-Z0-9]", "");
		double finalShippingPrice = Double.parseDouble(ship);
		return finalShippingPrice;
	}
	
	public double getTotalPrice() {
		String tPrice = totalPrice.getText();
		String total = tPrice.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(total);
		return finalTotalPrice;
	}
	
	public OrderConfirmationPage clickOnCheckOutBtn() throws Throwable{
		action.click(getDriver(), checkOutBtn);
		return new OrderConfirmationPage();
	}
}
