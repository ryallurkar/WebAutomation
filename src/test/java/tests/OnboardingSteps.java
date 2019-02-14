package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class OnboardingSteps extends BaseTest {

	@Test(priority = 0)
	@Description("To verify User can create Onboarding step")
	public void testCreateSteps() throws Exception {
		sideNavigationBar().clickOnSettings().clickOnBoarding().clickOnboardingStep();
		onBoardingStep().writeStepName("TestingStepsfirst");
		onBoardingStep().selectGeneralStep();
		onBoardingStep().clickOnAdd();
		onBoardingStep().clickOnAddItem("TestingStepsfirst");
		onBoardingStep().addSteps();
		onBoardingStep().addTextArea();
		onBoardingStep().addDocumentForDownload();
		onBoardingStep().addProfilePicture();
		onBoardingStep().addNameOfTextField();
		onBoardingStep().addUrl();
		onBoardingStep().selectEmployeeAttribute("First name");
		onBoardingStep().addDocument();
	}

}
