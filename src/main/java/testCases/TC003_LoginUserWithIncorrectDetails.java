package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import wrappers.BaseTest;

public class TC003_LoginUserWithIncorrectDetails extends BaseTest {
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC003";
		testCaseName = "LoginUserWithIncorrectDetails";
		testDescription = "Verify the invalid login message for the user";
		category = "smoke";
		authors = "Kumar Pancham Prasar";		
	}
	
	@Test
	public void loginUser(){
		new HomePage(driver, test)
		.clickSignUpOrLogin()
		.verifyLoginHeader(readProperty(dataSheetName,"Header"))
		.enterEmail(readProperty(dataSheetName,"Email"))
		.enterPassword(readProperty(dataSheetName,"Password"))
		.clickLoginForFailure()
		.verifyErrMsg(readProperty(dataSheetName,"ErrorMsg"));
	}
}










