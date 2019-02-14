package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class OnboardingSteps extends BaseTest {

	@Test(priority = 0)
	@Description("To verify onboarding steps")
	public void testSteps() throws Exception {
		sideNavigationBar().clickOnSettings().clickOnBoarding().clickOnboardingStep();
		onBoardingStep().writeStepName("TestingStepsfirst");
		onBoardingStep().selectGeneralStep();
		onBoardingStep().clickOnAdd();
		onBoardingStep().clickOnAddItem();
		onBoardingStep().addSteps();
		onBoardingStep().addTextArea();
		onBoardingStep().addDocumentForDownload();
		onBoardingStep().addProfilePicture();
		onBoardingStep().addNameOfTextField();
		onBoardingStep().addUrl();
		onBoardingStep().selectEmployeeAttribute("First name");
		onBoardingStep().addDocument();
	}

	@Test(priority = 1)
	@Description("To verify user can delete steps")
	public void testDeleteStep() throws Exception {
		sideNavigationBar().clickOnSettings().clickOnBoarding().clickOnboardingStep();
		onBoardingStep().deleteStep("TestingStepsfirst");
	}

}
