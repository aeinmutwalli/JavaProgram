/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author ManishGupta
 *
 */
public class AddToCartPage extends BaseClass{

	
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(name="group_1")
	private WebElement size;
	
	@FindBy(name="Submit")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessag;
	
	@FindBy(xpath="//*[@title='Proceed to checkout']")
	private WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterQuantity(String quantity1) throws Throwable {
		Action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) throws Throwable {
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable {
		Action.click(driver, addToCartBtn);
	}
	
	public boolean validateAddtoCart() throws Throwable {
		Action.fluentWait(driver, addToCartMessag, 10);
		return Action.isDisplayed(driver, addToCartMessag);
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
		Action.fluentWait(driver, proceedToCheckOutBtn, 10);
		Action.JSClick(driver, proceedToCheckOutBtn);
		return new OrderPage();
	}
	
}
