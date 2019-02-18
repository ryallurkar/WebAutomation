package pageObjects.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class SearchPageObjects extends PageFactoryInitializer {
	
	@FindBy(css = "input[class*='SearchTermInput__']")
	private WebElement searchInput;
	
	@FindBy(css = "div[class*=\"VirtualizedList__RowItem\"]")
	private List <WebElement> firstroductTiles;
	
	@FindBy(css = "*[class*='CategoryPage__CategoryName']")
	private WebElement firstCategory;
	
	@FindBy(css = "div[class*=\"StreamFilterButton__\"]")
	private WebElement filter;
	
	@FindBy(css = "div[data-cy-id=\"AddToWishlist\"]")
	private List <WebElement> favorite;
	
	@Step("Search input")
	public void search(String searchItem) throws Exception {
		searchInput.sendKeys(searchItem);
	}
	
	@Step("Get first search category")
	public String getSearchResultCategory() throws Exception {
		Thread.sleep(5000);
		return firstCategory.getText();
	}
	
	@Step("Click on filter")
	public void clickFilter() throws Exception {
		 filter.click();
	}
	
	@Step("Click on first product")
	public void clickOnFirstProduct() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", favorite.get(0));
		Thread.sleep(2000);
		firstroductTiles.get(2).click();
		Thread.sleep(2000);
		}

}
