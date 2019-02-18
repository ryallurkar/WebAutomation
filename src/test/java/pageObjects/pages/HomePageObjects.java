package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;

public class HomePageObjects extends PageFactoryInitializer {

	@FindBy(css = "div[class*='Header__Container']")
	private WebElement Header;

	@FindBy(css = "div[class*='Footer__Container']")
	private WebElement footer;

	@FindBy(css = "div[data-cy-id=\"BurgerIcon\"]")
	private WebElement BurgerIcon;

	@FindBy(css = "a[data-cy-id=\"HeaderAYLogo\"]")
	private WebElement logo;

	@FindBy(css = "*[data-cy-id=\"HeaderSearchIcon\"]")
	private WebElement search;

	@FindBy(css = "a[data-cy-id=\"HeaderWishlistIcon\"]>div>i")
	private WebElement wishlist;

	@FindBy(css = "a[data-cy-id=\"HeaderBasketIcon\"]")
	private WebElement cart;

	@FindBy(css = "div[class*=\"TopCategorySwitch__Container\"]")
	private WebElement TopCategorySwitch;

	@FindBy(css = "div[class*='BrowseCategoryFilter']")
	private WebElement BrowseCategoryFilter;

	@FindBy(css = "*[data-cy-id=\"closeCookieBanner\"]")
	private WebElement cookie;

	@FindBy(xpath = "//*[text()=\"Melde Dich jetzt an\"]")
	private WebElement signUp;

	@FindBy(css = "button[class*=\"notification-close\"]")
	private WebElement notificationClose;
	
	@Step("Verify Burger icon is visible ")
	public boolean verifyBurgerIcon() throws Exception {
		return BurgerIcon.isDisplayed();
	}

	@Step("Verify Company logo is visible ")
	public boolean verifyLogo() throws Exception {
		return logo.isDisplayed();
	}

	@Step("Verify search is visible")
	public boolean verifySearch() throws Exception {
		return search.isDisplayed();
	}

	@Step("Verify wishlist is visible")
	public boolean verifyWishlist() throws Exception {
		return wishlist.isDisplayed();
	}

	@Step("Verify cart is visible")
	public boolean verifyCart() throws Exception {
		return cart.isDisplayed();
	}

	@Step("Verify TopCategorySwitch with men women and kids")
	public boolean verifyTopCategorySwitch() throws Exception {
		return TopCategorySwitch.isDisplayed();
	}

	@Step("Verify BrowseCategoryFilter is visible with alles , outfits, Stories")
	public boolean verifyBrowseCategoryFilter() throws Exception {
		return BrowseCategoryFilter.isDisplayed();
	}

	@Step("Verify Header is present")
	public boolean verifyHeader() throws Exception {
		return Header.isDisplayed();
	}

	@Step("Verify footer is visible")
	public boolean verifyFooter() throws Exception {
		return footer.isDisplayed();
	}

	@Step("Click search icon")
	public void clickSearchIcon() throws Exception {
		search.click();
	}

	@Step("Click wishlist icon")
	public void clickWishList() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(wishlist, 30);
		ExplicitWaiting.explicitWaitElementToBeClickable(wishlist, 30);
		wishlist.click();
	}

	@Step("Click cart icon")
	public void clickCart() throws Exception {
		cart.click();
	}

	@Step("Navigate to homepage")
	public void goToHomePage() throws Exception {
		driver.get(WebsiteURL);
	}
	
	public  void closeNotifcationIfVisible() throws Exception {
		try {
			notificationClose.click();
		}catch(Exception e) {
			System.out.println("No notification found");
		}
	}

	@Step("Click Signup")
	public void clickSignUp() throws Exception {
		BurgerIcon.click();
		signUp.click();
	}

	@Step("Close Cookie Manager")
	public void clickCloseCookie() throws Exception {
		try {
			cookie.click();
		} catch (NoSuchElementException e) {
			System.out.println("No cookie banner found");
		}

	}

}
