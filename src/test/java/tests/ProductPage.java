package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class ProductPage extends PageFactoryInitializer {
	
	@Test(priority = 0)
	@Description("	")
	public void testProductPageDetails() throws Exception {
		homePage().clickCloseCookie();
		homePage().clickSearchIcon();
		searchPage().search("VERO MODA shirts"+"\n");
		searchPage().clickOnFirstProduct();
		Assert.assertTrue(productsPage().verifyProductsImage(), "Products image are not present");
		Assert.assertTrue(productsPage().verifyProductSize(), "Products size are not present");
		Assert.assertTrue(productsPage().verifyProductInfomation(), "Products information are not present");
	}
	
	
	@Test(priority = 1)
	@Description("Verify user can add product to cart")
	public void testaddProductToCart() throws Exception {
		productsPage().selectSize();
		productsPage().clickAddBasket();
		Assert.assertTrue(productsPage().verifyToastMessage(), "Toast message isn't visible");
	}

}
