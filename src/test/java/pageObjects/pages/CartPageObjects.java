package pageObjects.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class CartPageObjects extends PageFactoryInitializer {
	
	@FindBy(css = "p[class*=\"DeliveryItemStyled__BasketItemLabel\"]")
	private List<WebElement> productInfo;
	
	@FindBy(css = "select[class*=\"NumberDropDown__DropDownSelect\"]")
	private List<WebElement> quantity;
	
	@FindBy(css = "div[class*=\"DeliveryItemStyled__RightContainer\"]>i")
	private WebElement deleteIcon;
	
	@FindBy(xpath = "//button[text()=\"Produkt entfernen\"]")
	private WebElement removeProduct;
	
	@Step("Get product name")
	public String getProductName() throws Exception {
		return productInfo.get(0).getText();
	}
	
	@Step("Click delete icon")
	public void clickdeleteIcon() throws Exception {
		deleteIcon.click();
	}
	
	@Step("Click remove product icon")
	public void clickRemoveProduct() throws Exception {
		removeProduct.click();
	}
	
	@Step("Get product quantity")
	public String getSelectedQuantity() throws Exception {
		Select select = new Select(driver.findElement(By.cssSelector("select[class*=\"NumberDropDown__DropDownSelect\"]")));
		return select.getFirstSelectedOption().getText();
	}
	

}
