package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import wrappers.BaseTest;

public class TC001_RegisterUser extends BaseTest {
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC001";
		testCaseName = "RegisterUser";
		testDescription = "Verify the registration process of the user";
		category = "smoke";
		authors = "Kumar Pancham Prasar";		
	}
	
	@Test
	public void registerUser(){
		new HomePage(driver, test)
		.clickSignUpOrLogin()
		.verifySignUpHeader(readProperty(dataSheetName,"Header"))
		.enterSignupName(readProperty(dataSheetName,"Name"))
		.enterSignUpEmail(readProperty(dataSheetName,"Email"))
		.clickSignUpButton()
		.verifyHeader(readProperty(dataSheetName,"SignUp"))
		.clickTitle()
		.enterName(readProperty(dataSheetName,"FullName"))
		.enterPassword(readProperty(dataSheetName,"Password"))
		.selectDOB (readProperty(dataSheetName,"DOB"))
		.clickNewsletter()
		.clickOptin()
		.enterFirstName(readProperty(dataSheetName,"FirstName"))
		.enterLastName(readProperty(dataSheetName,"LastName"))
		.enterCompany(readProperty(dataSheetName,"Company"))
		.enterAddress1(readProperty(dataSheetName,"Address1"))
		.enterAddress2(readProperty(dataSheetName,"Address2"))
		.selectCountry(readProperty(dataSheetName,"Country"))
		.enterState(readProperty(dataSheetName,"State"))
		.enterCity(readProperty(dataSheetName,"City"))
		.enterZipCode(readProperty(dataSheetName,"ZipCode"))
		.enterMobileNumber(readProperty(dataSheetName,"MobileNumber"))
		.clickCreate()
		.verifyHeader(readProperty(dataSheetName,"ConfirmationHeader"))
		.clickContinue()
		.verifyLoggedInUser(readProperty(dataSheetName,"FullName"));
	}
}









