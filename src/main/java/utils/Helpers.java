package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import controllers.BaseMethod;

public class Helpers extends BaseMethod {

	// Write in input box
	public static void writeInput(String placeHolder, String keys) {
		List<WebElement> inputs = driver.findElements(By.xpath("//input[@placeholder='" + placeHolder + "']"));
		for (WebElement input : inputs) {
			if (input.isDisplayed() == true) {
				input.sendKeys(keys);
				break;
			}

		}
	}

	// Select option from toggle
	public static void selectFromDropdown(String option) {
		driver.findElement(By.xpath("//a[contains(.,'" + option + "')]")).click();
	}

	// Click on link
	public static void clickLink(String linkText) {
		List<WebElement> links = driver.findElements(By.xpath("//a[contains(.,'" + linkText + "')]"));
		for (WebElement link : links) {
			if (link.isDisplayed() == true) {
				link.click();
				break;
			}
		}

	}

	// Select from dropdown
	public static void select(WebElement select, String option) {
		Select dropdown = new Select(select);
		dropdown.selectByVisibleText(option);
	}

	// Upload file
	public static void uploadFile(List<WebElement> element, String path) throws InterruptedException {
		for (WebElement ele : element) {
			if (ele.isDisplayed() == true) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
				Thread.sleep(3000);
				ele.sendKeys(path);
				break;
			}

		}
	}

	// Click button
	public static void clickButton(String buttonText) {
		List<WebElement> buttons = driver.findElements(By.xpath("//button[contains(.,'" + buttonText + "')]"));
		for (WebElement button : buttons) {
			if (button.isDisplayed() == true) {
				button.click();
				break;
			}
		}
	}

	// Send text in textarea
	public static void sendText(String placeHolder, String text) {
		List<WebElement> textareas = driver.findElements(By.xpath("//textarea[@placeholder='" + placeHolder + "']"));
		for (WebElement area : textareas) {
			if (area.isDisplayed() == true) {
				area.sendKeys(text);
				break;
			}

		}
	}

	public static WebElement getVisibleElement(List<WebElement> elements) {
		WebElement visibleElement = null;
		for (WebElement ele : elements) {
			if (ele.isDisplayed() == true) {
				visibleElement = ele;
				break;
			}
		}
		return visibleElement;
	}

	public static List<WebElement> getVisibleElements(List<WebElement> elements) {
		List<WebElement> visibleElements = null;
		for (WebElement ele : elements) {
			if (ele.isDisplayed() == true) {
				visibleElements.add(ele);
				break;
			}
		}
		return visibleElements;
	}

	// Select from custom dropdown
	public static void selectFromCustomDropdown(String option) throws InterruptedException {
		getVisibleElement(driver.findElements(By.cssSelector(".chosen-single>span"))).click();
		getVisibleElement(driver.findElements(By.cssSelector(".chosen-search>input"))).sendKeys(option);
		Thread.sleep(1500);
		getVisibleElement(driver.findElements(By.cssSelector(".chosen-results>li"))).click();
	}
	
	// Check if element is visible
	public boolean isElementVisibl(WebElement element) throws InterruptedException {
		return element.isDisplayed();
	}
	
	

}
