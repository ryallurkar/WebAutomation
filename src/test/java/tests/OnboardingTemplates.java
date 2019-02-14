package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utils.Helpers;

public class OnboardingTemplates extends BaseTest {

	@Test(priority = 0)
	@Description("To verify onboarding templates")
	public void testCreateTemplates() throws Exception {
		sideNavigationBar().clickOnSettings().clickOnBoarding();
		onBoardingTemplate().writeTemplateName("TestingTemplate");
		onBoardingTemplate().clickOnAdd();
		onBoardingTemplate().clickOnAddItem();
		onBoardingTemplate().selectStepFromList("TestingStepsfirst");
		onBoardingTemplate().selectResponsible("Employee");
		onBoardingTemplate().setDueDate("20");
		onBoardingTemplate().selectOffset("after hire");
		Helpers.clickButton("Create");
	}

	@Test(priority = 1)
	@Description("To verify user can delete steps")
	public void testDeleteStep() throws Exception {
		sideNavigationBar().clickOnSettings().clickOnBoarding();
		onBoardingTemplate().deleteTemplate("TestingTemplate");
	}

}