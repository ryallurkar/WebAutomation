package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class OnboardingEmployees extends BaseTest {
	@Test(priority = 2)
	@Description("Assign to employee")
	public void testAssignTemplate() throws Exception {
		employee().clickFirstEmployee()

				.clickOnboardingLink().clickAssignNewOnbarding().selectTemplate("TestingTemplate");
	}

	@Test(priority = 3)
	@Description("Edit Assigned OnboardinTemplate")
	public void testEditAssignedTemplate() throws Exception {
		employee().clickAssignedTemplate("TestingStepsfirst");
		employee().editAssignedTemplate();
	}

	@Test(priority = 4)
	@Description("Mark Template as completed")
	public void testTemplateAsCompleted() throws Exception {
		employee().clickAssignedTemplate("TestingStepsfirst");
		employee().markTemplateAsCompleted();
	}

	@Test(priority = 5)
	@Description("Remove template from an Employee")
	public void testRemoveTemplate() throws Exception {
		employee().removeTemplate();
	}

}
