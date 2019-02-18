package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class CheckoutPage extends PageFactoryInitializer {
	
	@Test(priority = 0)
	@Description("Verify user can checkout product")
	public void testSearchProduct() throws Exception {
//		homePage().clickCloseCookie();
		homePage().clickSearchIcon();
		searchPage().search("VERO MODA shirt" + "\n");
		searchPage().clickOnFirstProduct();
		productsPage().selectSize();
		productsPage().clickAddBasket();
		homePage().clickCart();
		checkOutPage().clickCheckout();
		checkOutPage().clickLogin();
		loginPage().signIn();
		Thread.sleep(5000);
		checkOutPage().clickContinue();
		checkOutPage().clickPayNow();
		Thread.sleep(7000);
		Assert.assertTrue(getCurrentUrl().contains("www.paypal.com"),"Payment Gateway is not opened");
	}

}
