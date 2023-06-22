package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import wrappers.BaseTest;

public class TC005_SearchProducts extends BaseTest {
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC005";
		testCaseName = "SearchProducts";
		testDescription = "To search the product and verify the same in the cart";
		category = "smoke";
		authors = "Kumar Pancham Prasar";		
	}
	
	@Test
	public void searchProducts(){
		new HomePage(driver, test)
		.clickProduct()
		.enterSearch(readProperty(dataSheetName,"Search"))
		.clickSearch()
		.verifyHeader(readProperty(dataSheetName,"Header"))
		.verifyResult()
		.addAllProduct()
		.clickCart()
		.getProductNames()
		.verifyProduct()
		.clickSignUpOrLogin()
		.enterEmail(readProperty(dataSheetName,"Email"))
		.enterPassword(readProperty(dataSheetName,"Password"))
		.clickLogin()
		.clickCart()
		.getProductNames()
		.verifyProduct();
	}
}










