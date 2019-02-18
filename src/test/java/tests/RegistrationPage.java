package tests;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.RandomGenerator;

public class RegistrationPage extends PageFactoryInitializer {

	@Test(priority = 1)
	@Description("Verify Successful Registration")
	public void testSuccessfulRegistratio() throws Exception {
		driver.switchTo().frame(0);
		homePage().closeNotifcationIfVisible();
		registrationPage().enterFirstname("tom");
		registrationPage().enterlastname("martin");
		registrationPage().enterEmail(RandomGenerator.GenerateRandomEMAILIDs());
		registrationPage().enterPassword("TestingIsFun123");
		registrationPage().clickSubmit();
		driver.switchTo().defaultContent();
		Assert.assertTrue(registrationPage().isOrdersVisible(), "Registation failed");
	}

	@Test(priority = 0)
	@Description("Verify TOU and Data Protection link opens")
	public void testTermsofUseLink() throws Exception {
		homePage().clickSignUp();
		driver.switchTo().frame(0);
		homePage().closeNotifcationIfVisible();
		registrationPage().clickTouLink();

		String currentWindow = driver.getWindowHandle();
		String lastWindow = null;
		Set<String> handles = driver.getWindowHandles();
		for (String aux : handles) {
			lastWindow = aux;
		}
		driver.switchTo().window(lastWindow);
		Assert.assertTrue(getCurrentUrl().contains("nutzungsbedingungen"), "TOU link is not opened in new window");
		driver.switchTo().window(currentWindow);

		driver.switchTo().frame(0);
		registrationPage().clickDataLink();
		switchToNewWindow();
		Assert.assertTrue(getCurrentUrl().contains("datenschutz"), "Data Protection link is not opened in new window");
		driver.switchTo().window(currentWindow);
	}

}
