package pages;

import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.BaseTest;

public class AllProductsPage extends BaseTest {
	
	public static By tableRow = By.xpath("//table[@id='cart_info_table']/tbody/tr");
	public static String prodDesc = "//td[@class='cart_description']/h4/a";
	public static String prodDelete = "//table[@id='cart_info_table']/tbody/tr[%d]//a[@class='cart_quantity_delete']";
	public static String prodName = "//a[text()='%s']";
	public static By cart = By.xpath("//a[@href='/view_cart']");
	public static By enterSearch = By.id("search_product");
	public static By submitSearch = By.id("submit_search");
	public static By header = By.xpath("//div[@id='cartModal']/preceding-sibling::h2");
	public static By listOfProd = By.xpath("//div[@class='features_items']");
	public static By products = By.xpath("//img[@alt='ecommerce website products']/following-sibling::a");
	public static String addProduct = "//img[@alt='ecommerce website products']/following-sibling::a";
	public static String productText = "//img[@alt='ecommerce website products']/following-sibling::p";
	public static By continueShopping = By.xpath("//button[contains(text(),'Continue Shopping')]");
	public static By viewProduct = By.xpath("//a[@href='/product_details/1']");
	public static Set<String> addedProducts = new TreeSet<String>();
	public AllProductsPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Automation Exercise - All Products")){
			reportStep("This in not All Products Page", "FAIL");
		}				
	}
	
	public AllProductsPage enterSearch(String data){
		enterValue(enterSearch, data);
		return this;
	}
	
	public AllProductsPage clickSearch(){
		clickByElement(submitSearch);
		return this;		
	}
	
	public AllProductsPage verifyHeader(String data){
		verifyText(header, data);
		return this;
	} 
	
	public AllProductsPage verifyResult(){
		verifyElementPresent(listOfProd);
		return this;
	}
	
	public AllProductsPage addAllProduct() {
		if(getSizeOfElement(products)>0) {
			for(int i=1;i<=getSizeOfElement(products);i++) {
				scrollIntoView(By.xpath("("+addProduct+")["+i+"]"));
				clickByXpath("("+addProduct+")["+i+"]");
				addedProducts.add(getTextByXpath("("+productText+")["+i+"]").trim());
				clickByElement(continueShopping);
			}
		}
		return this;		
	}
	
	public CartPage clickCart(){
		clickByElement(cart);
		return new CartPage(driver, test);		
	}
	
	public AllProductsPage verifyProductDeleted() {
		verifyElementDoesNotExist(tableRow);
		return this;		
	}
	
	public ViewProductPage clickViewProduct(){
		scrollIntoView(viewProduct);
		clickByElement(viewProduct);
		return new ViewProductPage(driver, test);		
	}

}
