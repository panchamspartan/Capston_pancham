package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import wrappers.BaseTest;

public class TC006_AddReviewOnProduct extends BaseTest {
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC006";
		testCaseName = "AddReviewOnProduct";
		testDescription = "To add a review on the product";
		category = "smoke";
		authors = "Kumar Pancham Prasar";		
	}
	
	@Test
	public void reviewProducts(){
		new HomePage(driver, test)
		.clickProduct()
		.verifyHeader(readProperty(dataSheetName,"Header"))
		.clickViewProduct()
		.enterName(readProperty(dataSheetName,"Name"))
		.enterEmail(readProperty(dataSheetName,"Email"))
		.enterReview(readProperty(dataSheetName,"Review"))
		.clickSubmit()
		.verifySuccessMsg(readProperty(dataSheetName,"SuccessMsg"));
	}
}










