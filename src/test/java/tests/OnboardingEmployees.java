package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class OnboardingEmployees extends BaseTest {

	@Test(priority = 2)
	@Description("Assign Onboarding Template to employee")
	public void testAssignTemplate() throws Exception {
		sideNavigationBar().clickOnSettings().clickEmployees();
		employee().clickFirstEmployee().clickOnboardingLink().clickAssignNewOnbarding()
				.selectTemplate("TestingTemplate");
		Assert.assertTrue(onBoardingStep().verifySuccessMessage(), "Assign Onboarding Template process failed");
	}

	@Test(priority = 3)
	@Description("Edit Assigned Onboarding Template")
	public void testEditAssignedTemplate() throws Exception {
		employee().clickAssignedTemplate("TestingStepsfirst");
		employee().editAssignedTemplate();
		Assert.assertTrue(onBoardingStep().verifySuccessMessage(), "Edit Onboarding Template process failed");
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
		Assert.assertTrue(onBoardingStep().verifySuccessMessage(), "Remove Onboarding Template process failed");
	}

	@Test(priority = 6)
	@Description("To verify user can delete steps")
	public void testDeleteStep() throws Exception {
		sideNavigationBar().clickOnSettings().clickOnBoarding().clickOnboardingStep();
		onBoardingStep().deleteStep("TestingStepsfirst");
		Assert.assertTrue(onBoardingStep().verifySuccessMessage(), "Onboarding step delete process Failed");
	}

	@Test(priority = 7)
	@Description("To verify user can delete template")
	public void testDeleteTemplate() throws Exception {
		sideNavigationBar().clickOnSettings().clickOnBoarding();
		onBoardingTemplate().deleteTemplate("TestingTemplate");
		Assert.assertTrue(onBoardingTemplate().verifySuccessMessage(), "Onboarding Template delete process Failed");
	}

}
