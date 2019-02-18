package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class HomePage extends PageFactoryInitializer {
	
	@Test(priority = 0)
	@Description("Verify all homepage elements are present")
	public void testHomePageElement() throws Exception {
		Assert.assertTrue(homePage().verifyHeader(), "Header is not present");
		Assert.assertTrue(homePage().verifyFooter(), "Footer is not present");
		Assert.assertTrue(homePage().verifyBurgerIcon(), "Burger icon is not present");
		Assert.assertTrue(homePage().verifyTopCategorySwitch(), "TOP Category switch is not present");
		Assert.assertTrue(homePage().verifyCart(), "Cart icon is not present");
		Assert.assertTrue(homePage().verifyLogo(), "Logo is not present");
		Assert.assertTrue(homePage().verifySearch(), "Search is not present");
		Assert.assertTrue(homePage().verifyWishlist(), "Wishlist is not present");
		Assert.assertTrue(homePage().verifyBrowseCategoryFilter(), "BrowseCategoryFilter is not present");
	}
	
	@Test(priority = 1)
	@Description("Verify Search Page opens")
	public void testSearchPage() throws Exception {
		homePage().clickSearchIcon();
		Assert.assertTrue(getCurrentUrl().contains("search"),"Search page is not opened");
		navigateBack();
	}
	
	@Test(priority = 2)
	@Description("Verify wishlist opens")
	public void testWishListPage() throws Exception {
		homePage().clickWishList();
		Assert.assertTrue(getCurrentUrl().contains("wunschliste"),"wunschliste page is not opened");
	}
	
	@Test(priority = 3)
	@Description("Verify cart page opens")
	public void testCartPage() throws Exception {
		homePage().clickCart();
		Assert.assertTrue(getCurrentUrl().contains("warenkorb"),"warenkorb page is not opened");
	}


}
