package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class OnboardingEmployees extends BaseTest {
	

	@Test(priority = 2)
	@Description("Assign Onboarding Template to employee")
	public void testAssignTemplate() throws Exception {
		sideNavigationBar().clickOnSettings().clickEmployees();
		employee().clickFirstEmployee()

				.clickOnboardingLink().clickAssignNewOnbarding().selectTemplate("TestingTemplate");
	}

	@Test(priority = 3)
	@Description("Edit Assigned Onboarding Template")
	public void testEditAssignedTemplate() throws Exception {
		employee().clickAssignedTemplate("TestingStepsfirst");
		employee().editAssignedTemplate();
	}

	@Test(priority = 4)
	@Description("Mark Onboarding Template as completed")
	public void testTemplateAsCompleted() throws Exception {
		employee().clickAssignedTemplate("TestingStepsfirst");
		employee().markTemplateAsCompleted();
	}

	@Test(priority = 5)
	@Description("Remove Onboarding template from  Employee")
	public void testRemoveTemplate() throws Exception {
		employee().removeTemplate();
	}
	
	@Test(priority = 6)
	@Description("To verify user can delete steps")
	public void testDeleteStep() throws Exception {
		sideNavigationBar().clickOnSettings().clickOnBoarding().clickOnboardingStep();
		onBoardingStep().deleteStep("TestingStepsfirst");
	}
	
	@Test(priority = 7)
	@Description("To verify user can delete template")
	public void testDeleteTemplate() throws Exception {
		sideNavigationBar().clickOnSettings().clickOnBoarding();
		onBoardingTemplate().deleteTemplate("TestingTemplate");
	}

}
