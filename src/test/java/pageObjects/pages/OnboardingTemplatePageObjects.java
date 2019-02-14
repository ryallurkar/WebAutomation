package pageObjects.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;
import utils.Helpers;

public class OnboardingTemplatePageObjects extends PageFactoryInitializer {

	@FindBy(css = ".input-group-btn")
	private List<WebElement> buttons;

	@FindBy(css = "select[name=\"responsible\"]")
	private WebElement responsible;

	@FindBy(css = "select[name=\"offset_direction\"]")
	private WebElement offset;

	@FindBy(css = "input[name=\"due_date_offset\"]")
	private WebElement dueDate;
	
	@FindBy(css = ".fal.fa-trash")
	private List<WebElement> deleteIcon;
	
	@FindBy(css = ".alert.alert-success.alert-autofade")
	private WebElement success;

	@Step("Enter step name")
	public OnboardingTemplatePageObjects writeTemplateName(String sname) throws Exception {
		Helpers.writeInput("New Template...", sname);
		return this;
	}

	@Step("Click on + ")
	public OnboardingTemplatePageObjects clickOnAdd() throws Exception {
		buttons.get(0).click();
		return this;
	}

	@Step("Click on Add step ")
	public OnboardingTemplatePageObjects clickOnAddItem() throws Exception {
		Helpers.clickLink("Add step");
		return this;
	}

	@Step("Select step ")
	public OnboardingTemplatePageObjects selectStepFromList(String stepname) throws Exception {
		Helpers.selectFromCustomDropdown(stepname);
		return this;
	}

	@Step("Select Responsible ")
	public OnboardingTemplatePageObjects selectResponsible(String resName) throws Exception {
		Helpers.select(responsible, resName);
		return this;
	}

	@Step("Set Due date ")
	public OnboardingTemplatePageObjects setDueDate(String days) throws Exception {
		dueDate.sendKeys(days);
		return this;
	}

	@Step("Select offset direction ")
	public OnboardingTemplatePageObjects selectOffset(String resName) throws Exception {
		Helpers.select(offset, resName);
		return this;
	}
	
	@Step("Delete Template")
	public void deleteTemplate(String templateName) throws Exception {
		Helpers.clickLink(templateName);
		Helpers.getVisibleElement(deleteIcon).click();
		Helpers.clickButton("Delete");
		ExplicitWaiting.explicitWaitVisibilityOfElement(success,10);
	}

}
