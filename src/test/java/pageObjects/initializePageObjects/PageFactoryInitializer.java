package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.EmployeesPageObjects;
import pageObjects.pages.OnboardingStepsPageObjects;
import pageObjects.pages.OnboardingTemplatePageObjects;
import pageObjects.pages.PersonioHomePageObjects;
import pageObjects.pages.SideNavigationBarPageObjects;

public class PageFactoryInitializer extends BaseMethod {
	public PersonioHomePageObjects personioHomePage() {
		return PageFactory.initElements(getWebDriver(), PersonioHomePageObjects.class);
	}

	public SideNavigationBarPageObjects sideNavigationBar() {
		return PageFactory.initElements(getWebDriver(), SideNavigationBarPageObjects.class);
	}

	public OnboardingStepsPageObjects onBoardingStep() {
		return PageFactory.initElements(getWebDriver(), OnboardingStepsPageObjects.class);
	}

	public OnboardingTemplatePageObjects onBoardingTemplate() {
		return PageFactory.initElements(getWebDriver(), OnboardingTemplatePageObjects.class);
	}

	public EmployeesPageObjects employee() {
		return PageFactory.initElements(getWebDriver(), EmployeesPageObjects.class);
	}

}
