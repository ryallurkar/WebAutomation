package pageObjects.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;

public class CheckoutPageObjects extends PageFactoryInitializer {
	
	@FindBy(css = "button[class*=\"CheckoutButton__StyledCheckoutButton\"]")
	private List<WebElement> checkoutButton;
	
	@FindBy(xpath = "//button[text()=\"Weiter\"]")
	private WebElement continueButton;
	
	@FindBy(css = "button[class*=\"notification-close\"]")
	private WebElement notificationClose;
	
	@FindBy(css = ".registration-login-toggle")
	private WebElement loginButton;
	
	@FindBy(css = "button[type=\"submit\"]")
	private List<WebElement> payNow;
	
	@FindBy(css = ".payment-list>li")
	private List<WebElement> paymentOptions;
	
	@FindBy(css = "")
	private List<WebElement> buyButton;
	
	@Step("Click checkout")
	public  void clickCheckout() throws Exception {
		checkoutButton.get(0).click();
	}
	
	@Step("Click continue")
	public  void clickContinue() throws Exception {
		closeNotifcationIfVisible();
		ExplicitWaiting.explicitWaitVisibilityOfElement(continueButton, 30);
		ExplicitWaiting.explicitWaitElementToBeClickable(continueButton, 30);
		scrollIntoView(continueButton);
		continueButton.click();
	}
	
	@Step("Click paynow")
	public  void clickPayNow() throws Exception {
		scrollIntoView(payNow.get(1));
		ExplicitWaiting.explicitWaitVisibilityOfElement(payNow.get(1), 30);
		ExplicitWaiting.explicitWaitElementToBeClickable(payNow.get(1), 30);
		Thread.sleep(4000);
		payNow.get(1).click();
	}
	
	public  void closeNotifcationIfVisible() throws Exception {
		try {
			notificationClose.click();
		}catch(Exception e) {
			System.out.println("No notification found");
		}
	}
	
	@Step("Click Login")
	public  void clickLogin() throws Exception {
		closeNotifcationIfVisible();
		scrollIntoView(loginButton);
		loginButton.click();
	}

}
