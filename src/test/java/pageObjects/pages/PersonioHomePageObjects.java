/**
 * 
 */
package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class PersonioHomePageObjects extends PageFactoryInitializer
{
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement password;

	@FindBy(css="button[type=\"Submit\"]")
	private WebElement submit;

	@Step("Enter email and Pwd to login")
	public PersonioHomePageObjects signIn() throws Exception
	{
		email.sendKeys("raju90y@outlook.com");
		password.sendKeys("TestingI$Fun123");
		submit.click();
		return this;		
	}

}
