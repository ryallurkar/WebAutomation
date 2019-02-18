package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class RegistrationPageObjects extends PageFactoryInitializer {

	@FindBy(css = "input[name=\"firstName\"]")
	private WebElement firstname;

	@FindBy(css = "input[name=\"lastName\"]")
	private WebElement lastname;

	@FindBy(css = "input[name=\"email\"]")
	private WebElement email;

	@FindBy(css = "input[name=\"password\"]")
	private WebElement password;

	@FindBy(css = "button[type=\"submit\"]")
	private WebElement submit;

	@FindBy(xpath = "//p[text()='meine Bestellungen ansehen']")
	private WebElement findMyOrders;

	@FindBy(xpath = "//a[text()=\"Nutzungsbedingungen\"]")
	private WebElement touLink;

	@FindBy(xpath = "//a[text()=\"Datenschutzerklärung\"]")
	private WebElement dataProtectionLink;

	@FindBy(xpath = "//a[text()=\"Du hast einen Account: Jetzt einloggen\"]")
	private WebElement login;
	
	@Step("Enter firstname")
	public void enterFirstname(String fname) throws Exception {
		firstname.sendKeys(fname);
	}

	@Step("Enter lastname")
	public void enterlastname(String lname) throws Exception {
		lastname.sendKeys(lname);
	}

	@Step("Enter email")
	public void enterEmail(String mail) throws Exception {
		email.sendKeys(mail);
	}

	@Step("Enter password")
	public void enterPassword(String pwd) throws Exception {
		password.sendKeys(pwd);
	}

	@Step("Click submit")
	public void clickSubmit() throws Exception {
		submit.click();
	}
	
	@Step("Click Login")
	public void clickLogin() throws Exception {
		login.click();
	}

	@Step("Click submit")
	public void clickCart() throws Exception {
		submit.click();
	}

	@Step("Click tou link")
	public void clickTouLink() throws Exception {
		touLink.click();
	}

	@Step("Click data link")
	public void clickDataLink() throws Exception {
		dataProtectionLink.click();
	}

	@Step("Check view my orders visible or not")
	public boolean isOrdersVisible() throws Exception {
		return findMyOrders.isDisplayed();
	}

}
