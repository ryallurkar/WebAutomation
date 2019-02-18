package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class CartPage extends PageFactoryInitializer {

	@Test(priority = 0)
	@Description("Verify if product is added on cart")
	public void testProductInCart() throws Exception {
		homePage().clickCloseCookie();
		homePage().clickSearchIcon();
		searchPage().search("VERO MODA shirts" + "\n");
		searchPage().clickOnFirstProduct();
		productsPage().selectSize();
		productsPage().clickAddBasket();
		homePage().clickCart();
		Assert.assertEquals(cartPage().getProductName(), "VERO MODA", "Product is not same in cart");
	}

	@Test(priority = 1)
	@Description("Verify if quantity of the product is correct or not")
	public void testProductQuantity() throws Exception {
		Assert.assertEquals(cartPage().getSelectedQuantity(), "1", "Quantity is not 1");
	}

	@Test(priority = 2)
	@Description("Verify user can remove product from cart")
	public void testRemoveProduct() throws Exception {
		cartPage().clickdeleteIcon();
		cartPage().clickRemoveProduct();
	}

}
