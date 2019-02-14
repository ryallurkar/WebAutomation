package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.initializePageObjects.PageFactoryInitializer;

public class BaseTest extends PageFactoryInitializer {


	@BeforeClass // The annotated method will be run before all tests in this suite have run
	public void setup() throws Exception {
		personioHomePage().signIn();
	}
	
	@AfterClass(description = "Class Level Teardown!")
	public void teardown() {
	}

}
