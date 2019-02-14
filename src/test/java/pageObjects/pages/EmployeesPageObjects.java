package pageObjects.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.Helpers;

public class EmployeesPageObjects extends PageFactoryInitializer {

	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	private WebElement firstEmp;

	@FindBy(xpath = "//a[text()=\"Onboarding\"]")
	private WebElement onboardingLink;

	@FindBy(css = "select[name=\"template_id\"]")
	private WebElement templateId;

	@FindBy(xpath = "//i[text()=\"No onboarding template assigned.\"]")
	private List<WebElement> labelNoTemplates;

	@FindBy(css = "input[type=\"file\"]")
	private List<WebElement> upload;

	@FindBy(css = ".alert.alert-success.alert-autofade")
	private WebElement success;

	@Step("Click on Onboarding")
	public EmployeesPageObjects clickOnboardingLink() throws Exception {
		onboardingLink.click();
		return this;
	}

	@Step("Click on First Employee")
	public EmployeesPageObjects clickFirstEmployee() throws Exception {
		firstEmp.click();
		return this;
	}

	@Step("Click on Assign new onboarding template ")
	public EmployeesPageObjects clickAssignNewOnbarding() throws Exception {
		Helpers.clickLink("Assign new onboarding template");
		return this;
	}

	@Step("Select template ID")
	public EmployeesPageObjects selectTemplate(String templateName) throws Exception {
		if (labelNoTemplates.size() > 0) {
			Helpers.clickLink(templateName);
		} else {
			Helpers.select(templateId, templateName);
			Helpers.clickButton("Assign");
		}

		return this;
	}

	@Step("Click on Assigned Template")
	public EmployeesPageObjects clickAssignedTemplate(String tempName) throws Exception {
		Helpers.clickLink(tempName);
		return this;
	}

	@Step("Edit Assigned Template")
	public EmployeesPageObjects editAssignedTemplate() throws Exception {
		Helpers.clickLink("(Edit)");
		Helpers.clickLink("pdfsample.pdf");
		File file = new File(
				"src" + File.separator + "test" + File.separator + "resources" + File.separator + "pdfsample2.pdf");
		Helpers.uploadFile(upload, file.getAbsolutePath());
		Thread.sleep(5000);
		Helpers.clickButton("Submit");
		return this;
	}

	@Step("Mark Template as completed")
	public EmployeesPageObjects markTemplateAsCompleted() throws Exception {
		Helpers.clickButton("Mark as completed");
		return this;
	}

	@Step("Remove Template")
	public EmployeesPageObjects removeTemplate() throws Exception {
		Helpers.clickLink("Remove onboarding template");
		Helpers.clickButton("Delete");
		return this;
	}

	@Step("Verify Success message")
	public boolean verifySuccessMessage() throws Exception {
		return success.isDisplayed();
	}

}
