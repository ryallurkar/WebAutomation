/**
 * 
 */
package pageObjects.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;
import utils.Helpers;

public class OnboardingStepsPageObjects extends PageFactoryInitializer {
	ArrayList<String> optionsList = new ArrayList<String>();

	@FindBy(css = ".input-group-btn")
	private List<WebElement> buttons;

	@FindBy(css = "select[name=\"item_type\"]")
	private WebElement selectItem;

	@FindBy(css = "select[name=\"item_type\"]>option")
	private List<WebElement> options;

	@FindBy(xpath = "//option[text()=\"Select document category...\"]/..")
	private List<WebElement> document;

	@FindBy(css = "input[name*='file_']")
	private List<WebElement> upload;
	
	@FindBy(css = ".fal.fa-trash.pull-right")
	private List<WebElement> deleteIcon;

	@FindBy(css = ".alert.alert-success.alert-autofade")
	private WebElement success;
	
	public WebElement getDocument() {
		WebElement docu = null;
		for (WebElement doc : document) {
			if (doc.isDisplayed() == true) {
				docu = doc;
			}
		}
		return docu;

	}

	@Step("Enter step name")
	public OnboardingStepsPageObjects writeStepName(String sname) throws Exception {
		Helpers.writeInput("New step...", sname);
		return this;
	}

	@Step("Select General Step")
	public OnboardingStepsPageObjects selectGeneralStep() throws Exception {
		buttons.get(0).click();
		;
		Helpers.selectFromDropdown("General step");
		return this;
	}

	@Step("Select Email Step")
	public OnboardingStepsPageObjects selectEmailStep() throws Exception {
		Helpers.selectFromDropdown("Email action");
		return this;
	}

	@Step("Click on + ")
	public OnboardingStepsPageObjects clickOnAdd() throws Exception {
		buttons.get(1).click();
		;
		return this;
	}

	@Step("Click on Add item ")
	public OnboardingStepsPageObjects clickOnAddItem() throws Exception {
		Helpers.clickLink("Add item");
		return this;
	}

	@Step("Click Create")
	public OnboardingStepsPageObjects clickCreate() throws Exception {
		Helpers.clickButton("Create");
		return this;
	}

	@Step("Add all steps ")
	public void addSteps() throws Exception {
		for (WebElement option : options) {
			optionsList.add(option.getText());
		}

		for (int i = 1; i < optionsList.size(); i++) {
			if (i > 1) {
				Helpers.clickLink("Add item");
			}
			Helpers.select(selectItem, optionsList.get(i));
			Helpers.clickButton("Create");
			ExplicitWaiting.explicitWaitElementToBeClickable(buttons.get(1), 30);
		}
	}

	@Step("Add textarea ")
	public void addTextArea() throws Exception {
		Helpers.sendText("Enter your text here...", "This is textarea test");
	}

	@Step("Add document ")
	public void addDocumentForDownload() throws Exception {
		Helpers.writeInput("Name of the document....", "This is test for download");
		File file = new File(
				"src" + File.separator + "test" + File.separator + "resources" + File.separator + "pdfsample.pdf");
		Helpers.uploadFile(upload, file.getAbsolutePath());
		Thread.sleep(10000);
	}

	@Step("Add emp id")
	public void selectEmployeeAttribute(String option) throws Exception {
		Helpers.selectFromCustomDropdown(option);
	}

	@Step("Add profile pic ")
	public void addProfilePicture() throws Exception {
		Helpers.writeInput("Profile picture label...", "This is profile picture");
	}

	@Step("Add description for the checkbox")
	public void addDescription() throws Exception {
		Helpers.writeInput("Description for the checkbox...", "This is description test");
	}

	@Step("Add description for the checkbox")
	public void addNameOfTextField() throws Exception {
		Helpers.writeInput("Name of textfield...", "This is textfield test");
	}

	@Step("Add url")
	public void addUrl() throws Exception {
		Helpers.writeInput("Name of URL...", "http://this.is.url.test");
	}

	@Step("Add Document")
	public void addDocument() throws Exception {
		Helpers.select(getDocument(), "Payroll");
		Helpers.writeInput("Name of document...", "This is test document" + "\n");
	}
	
	@Step("Delete Step")
	public void deleteStep(String stepName) throws Exception {
		Helpers.clickLink(stepName);
		Helpers.getVisibleElement(deleteIcon).click();
		Helpers.clickButton("Delete");
		ExplicitWaiting.explicitWaitVisibilityOfElement(success,10);
	}

}