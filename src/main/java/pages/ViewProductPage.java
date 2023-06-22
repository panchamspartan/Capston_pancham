package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.BaseTest;

public class ViewProductPage extends BaseTest {
	
	public static By name = By.id("name");
	public static By email = By.id("email");
	public static By review = By.id("review");
	public static By submit = By.id("button-review");
	public static By successMsg = By.xpath("//div[@class='alert-success alert']/span");

	public ViewProductPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Automation Exercise - Product Details")){
			reportStep("This in not Product Details Page", "FAIL");
		}				
	}
	
	public ViewProductPage enterName(String data){
		enterValue(name, data);
		return this;
	}
	
	public ViewProductPage enterEmail(String data){
		enterValue(email, data);
		return this;
	}
	
	public ViewProductPage enterReview(String data){
		enterValue(review, data);
		return this;
	}
	
	public ViewProductPage clickSubmit(){
		scrollIntoView(submit);
		clickByElement(submit);
		return this;		
	}
	
	public ViewProductPage verifySuccessMsg(String data){
		verifyText(successMsg, data);
		return this;
	} 
	
}
