package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class SearchPage extends PageFactoryInitializer {
	
	@Test(priority = 0)
	@Description("Verify search works with product")
	public void testSearchProduct() throws Exception {
		homePage().clickCloseCookie();
		homePage().clickSearchIcon();
		searchPage().search("shirts"+"\n");
		Assert.assertEquals(searchPage().getSearchResultCategory(), "Shirts","Search criteria doesn't match");
	}
	
	@Test(priority = 1)
	@Description("Verify user can open product after search")
	public void testOpenFirstSearchedProduct() throws Exception {
		String previousUrl = getCurrentUrl();
		searchPage().clickOnFirstProduct();
		Assert.assertNotEquals(getCurrentUrl(), previousUrl,"Product page isn't opened");
		navigateBack();
	}
	
	@Test(priority = 1)
	@Description("Verify user can see filters on the products")
	public void testFilterAreOpened() throws Exception {
		searchPage().clickFilter();
		Assert.assertTrue(getCurrentUrl().contains("showFilterMenu=true"),"Filter page is not opened");
		navigateBack();
	}

}
