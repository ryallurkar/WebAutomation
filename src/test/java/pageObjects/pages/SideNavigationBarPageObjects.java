package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class SideNavigationBarPageObjects extends PageFactoryInitializer {
	
	@FindBy(xpath="//div[text()='Settings']/..")
	private WebElement settingIcon;
	
	@FindBy(xpath="//div[text()='Employees']/..")
	private WebElement emp;
	
	@FindBy(xpath="//a[text()='On-/Offboarding']")
	private WebElement onBoarding;
	
	@FindBy(xpath="//a[contains(.,'Onboarding Steps')]")
	private WebElement onBoardingSteps;
	
	@Step("Click on Settings label")
	public SideNavigationBarPageObjects clickOnSettings() throws Exception
	{
		settingIcon.click();
		return this;		
	}
	
	@Step("Click on On/Offboarding")
	public SideNavigationBarPageObjects clickOnBoarding() throws Exception
	{
		onBoarding.click();
		return this;		
	}
	
	@Step("Click on Onboarding step")
	public SideNavigationBarPageObjects clickOnboardingStep() throws Exception
	{
		onBoardingSteps.click();
		return this;		
	}
	
	@Step("Click on Employees label")
	public SideNavigationBarPageObjects clickEmployees() throws Exception
	{
		emp.click();
		return this;		
	}
	
	

}
