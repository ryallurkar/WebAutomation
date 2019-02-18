package pageObjects.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class LoginPageObjects extends PageFactoryInitializer {

	@FindBy(css = "input[name=\"email\"]")
	private WebElement email;

	@FindBy(css = "input[name=\"password\"]")
	private WebElement password;

	@FindBy(css = "button[type=\"submit\"]")
	private WebElement submit;

	@FindBy(css = ".invalid.touched")
	private List<WebElement> error;

	@FindBy(css = ".password-forgot")
	private WebElement forgotPwdLink;
	
	@FindBy(css = ".embedded-password-forgot")
	private WebElement pwdResetConfirmationMessage;

	@Step("Enter email")
	public void enterEmail(String mail) throws Exception {
		email.clear();
		email.sendKeys(mail);
	}

	@Step("Enter password")
	public void enterPassword(String pwd) throws Exception {
		password.clear();
		password.sendKeys(pwd);
	}

	@Step("Click submit")
	public void clickSubmit() throws Exception {
		submit.click();
	}

	@Step("Click forgot password")
	public void clickForgotPassword() throws Exception {
		forgotPwdLink.click();
	}

	@Step("Verify error message is present")
	public boolean isErrorVisible() throws Exception {
		return error.get(0).isDisplayed();
	}
	
	@Step("Verify if pwd reset confirmation messageis present")
	public boolean isPwdResetMessageVisible() throws Exception {
		return pwdResetConfirmationMessage.isDisplayed();
	}

	@Step("Enter email and Pwd to login")
	public LoginPageObjects signIn() throws Exception {
		enterEmail(Username);
		enterPassword(Password);
		clickSubmit();
		return this;
	}

}
