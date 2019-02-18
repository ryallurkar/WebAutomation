package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class LoginPage  extends PageFactoryInitializer {
	
	@Test(priority = 3)
	@Description("Verify user can login with valid credentials")
	public void testSuccessfulLogin() throws Exception {
		loginPage().signIn();
		Assert.assertTrue(registrationPage().isOrdersVisible(), "Login failed");
	}
	
	@Test(priority = 1)
	@Description("Verify error message shown when user tries to login without username and password")
	public void testInvalidLogin() throws Exception {
		driver.switchTo().frame(0);
		loginPage().clickSubmit();
		Assert.assertTrue(loginPage().isErrorVisible(), "No error message shown");
	}
	
	@Test(priority = 2)
	@Description("Verify error message shown when user tries to login without username ")
	public void testInvalidLoginWithoutPassword() throws Exception {
		loginPage().enterEmail("fafaa@gmail.com");
		loginPage().clickSubmit();
		Assert.assertTrue(loginPage().isErrorVisible(), "No error message shown");
	}
	
	@Test(priority = 0)
	@Description("Verify forgot password link works")
	public void testForgotPassword() throws Exception {
		homePage().clickSignUp();
		driver.switchTo().frame(0);
		homePage().closeNotifcationIfVisible();
		registrationPage().clickLogin();
		loginPage().clickForgotPassword();
		loginPage().enterEmail("fafaa@gmail.com");
		loginPage().clickSubmit();
		Assert.assertTrue(loginPage().isPwdResetMessageVisible(), "No pwd reset message shown");
		driver.navigate().back();
	}



}
