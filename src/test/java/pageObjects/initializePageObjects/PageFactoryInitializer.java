package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.CartPageObjects;
import pageObjects.pages.CheckoutPageObjects;
import pageObjects.pages.HomePageObjects;
import pageObjects.pages.LoginPageObjects;
import pageObjects.pages.ProductPageObjects;
import pageObjects.pages.RegistrationPageObjects;
import pageObjects.pages.SearchPageObjects;

public class PageFactoryInitializer extends BaseMethod {
	
	public HomePageObjects homePage() {
		return PageFactory.initElements(getWebDriver(), HomePageObjects.class);
	}
	
	public SearchPageObjects searchPage() {
		return PageFactory.initElements(getWebDriver(), SearchPageObjects.class);
	}
	
	public ProductPageObjects productsPage() {
		return PageFactory.initElements(getWebDriver(), ProductPageObjects.class);
	}
	
	public CartPageObjects cartPage() {
		return PageFactory.initElements(getWebDriver(), CartPageObjects.class);
	}

	public RegistrationPageObjects registrationPage() {
		return PageFactory.initElements(getWebDriver(), RegistrationPageObjects.class);
	}
	
	public LoginPageObjects loginPage() {
		return PageFactory.initElements(getWebDriver(), LoginPageObjects.class);
	}
	
	public CheckoutPageObjects checkOutPage() {
		return PageFactory.initElements(getWebDriver(), CheckoutPageObjects.class);
	}
}
