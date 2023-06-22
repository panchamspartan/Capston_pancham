package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import wrappers.BaseTest;

public class TC002_LoginUser extends BaseTest {
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC002";
		testCaseName = "LoginUser";
		testDescription = "Verify the user should be able to successfully login";
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
		.clickLogin()
		.verifyLoggedInUser(readProperty(dataSheetName,"FullName"))
		.clickDeleteAccount()
		.verifyHeader(readProperty(dataSheetName,"ConfirmationHeader"));
	}
}










