package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.BaseTest;

public class HomePage extends BaseTest{
	public static By signup = By.xpath("//a[@href='/login']");
	public static By logOut = By.xpath("//a[@href='/logout']");
	public static By deleteAccount = By.xpath("//a[@href='/delete_account']");
	public static By cart = By.xpath("//a[@href='/view_cart']");
	public static By product = By.xpath("//a[@href='/products']");
	public static By continueShopping = By.xpath("//button[contains(text(),'Continue Shopping')]");

	public HomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Automation Exercise")){
			reportStep("This in not Home Page", "FAIL");
		}		
	}
		
	public LoginPage clickSignUpOrLogin(){
		clickByElement(signup);
		return new LoginPage(driver, test);		
	
	}
	
	public LoginPage clickLogOut(){
		clickByElement(logOut);
		return new LoginPage(driver, test);		
	}
	
	public HomePage verifyLoggedInUser(String data){
		verifyElementPresent(By.xpath("//b[contains(text(),'"+data+"')]"));
		return this;		
	}
	
	public AccountCreateOrDeletePage clickDeleteAccount() {
		clickByElement(deleteAccount);
		backPage();
		clickIfExists(deleteAccount);
		return new AccountCreateOrDeletePage(driver, test);
	}
	
	public HomePage clickAddToCartForFiveProduct(){
		for(int i=1;i<=5;i++) {
			By locator = By.xpath("//a[@data-product-id='"+i+"']");
			scrollIntoView(locator);
			clickByElement(locator);
			clickByElement(continueShopping);
		}
		return this;		
	}
	
	public CartPage clickCart(){
		clickByElement(cart);
		return new CartPage(driver, test);		
	}
	
	public AllProductsPage clickProduct(){
		clickByElement(product);
		backPage();
		clickByElement(product);
		return new AllProductsPage(driver, test);		
	}

}


















