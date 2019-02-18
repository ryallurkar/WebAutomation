package pageObjects.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class ProductPageObjects extends PageFactoryInitializer {
	
	@FindBy(css = "div[class*=\"ScrollSnapContainer__\"]")
	private WebElement productImages;
	
	@FindBy(css = "div[class*=\"SizeSelection__SizesContainer\"]")
	private WebElement sizeSelection;

	@FindBy(css = "div[class*=\"ProductInformation__Container\"]")
	private WebElement productInformation;
	
	@FindBy(css = "button[data-cy-id=\"AddToBasketButton\"]")
	private WebElement addToBasket;
	
	@FindBy(css = "div[data-cy-id*=\"size_\"]")
	private List<WebElement> sizes;
	
	@FindBy(css = "div[class*=\"ToastContent__Container\"]")
	private List<WebElement> successFulToastMessage;
	
	
	@Step("Verify product images are visible ")
	public boolean verifyProductsImage() throws Exception {
		return productImages.isDisplayed();
	}

	@Step("Verify product size collection are visible ")
	public boolean verifyProductSize() throws Exception {
		return sizeSelection.isDisplayed();
	}

	@Step("Verify product information is visible")
	public boolean verifyProductInfomation() throws Exception {
		return productInformation.isDisplayed();
	}
	
	@Step("Verify successful toas message visible")
	public boolean verifyToastMessage() throws Exception {
		return successFulToastMessage.get(0).isDisplayed();
	}
	
	@Step("Select product size")
	public  void selectSize() throws Exception {
//		driver.findElement(By.xpath("//p[text()='"+size+"']")).click();
		sizes.get(0).click();
	}
	
	@Step("Click on add basket")
	public  void clickAddBasket() throws Exception {
		addToBasket.click();
	}

}
