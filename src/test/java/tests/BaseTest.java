package tests;

import org.testng.annotations.BeforeTest;

import pageObjects.initializePageObjects.PageFactoryInitializer;

public class BaseTest extends PageFactoryInitializer {


	@BeforeTest // The annotated method will be run before all tests in this suite have run
	public void setup() throws Exception {
		personioHomePage().signIn();
	}

}
