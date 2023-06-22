package pages;

import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.BaseTest;

public class CartPage extends BaseTest {

	public static By signup = By.xpath("//a[@href='/login']");
	public static By tableRow = By.xpath("//table[@id='cart_info_table']/tbody/tr");
	public static String prodDesc = "//table[@id='cart_info_table']/tbody/tr[%d]/td[@class='cart_description']/h4/a";
	public static String prodDelete = "//table[@id='cart_info_table']/tbody/tr[%d]//a[@class='cart_quantity_delete']";
	public static String prodName = "//a[text()='%s']";
	public static String productName = "//td[@class='cart_description']/h4/a";
	public static Set<String> addedProductsInCart = new TreeSet<String>();
	
	public CartPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Automation Exercise - Checkout")){
			reportStep("This in not Checkout Page", "FAIL");
		}				
	}
	
	public CartPage deleteProduct() {
		if(getSizeOfElement(tableRow)>0) {
			for(int i=1;i<=getSizeOfElement(tableRow);i++) {
				prodDelete = String.format(prodDelete, i);
				scrollIntoView(By.xpath(prodDelete));
				clickByXpath(prodDelete);
			}
		}
		return this;		
	}
	
	public CartPage verifyProductDeleted() {
		verifyElementDoesNotExist(tableRow);
		return this;		
	}
	
	public CartPage getProductNames() {
		if(getSizeOfElement(tableRow)>0) {
			for(int i=1;i<=getSizeOfElement(tableRow);i++) {
				addedProductsInCart.add(getTextByXpath("("+productName+")["+i+"]").trim());
			}
		}
		return this;
	}
	public CartPage verifyProduct() {
		if((AllProductsPage.addedProducts).equals(addedProductsInCart))
			reportStep("Added Products are displayed in View Cart","PASS");
		else
			reportStep("Added Products are not displayed in View Cart","FAIL");
		return this;
	}
	
	public LoginPage clickSignUpOrLogin(){
		clickByElement(signup);
		return new LoginPage(driver, test);		
	
	}
}
