package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import wrappers.BaseTest;

public class TC004_RemoveProductsFromCart extends BaseTest {
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "RemoveProductsFromCart";
		testDescription = "To remove the products from cart";
		category = "smoke";
		authors = "Kumar Pancham Prasar";		
	}
	
	@Test
	public void removeProducts(){
		new HomePage(driver, test)
		.clickAddToCartForFiveProduct()
		.clickCart()
		.deleteProduct();
	}
}










