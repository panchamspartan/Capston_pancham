package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.BaseTest;

public class AccountCreateOrDeletePage  extends BaseTest {
	public static By header = By.xpath("//*[starts-with(text(),'Account')]");
	public static By continueButton = By.xpath("//a[@data-qa='continue-button']");
	public static By frame = By.id("aswift_1");
	public static By closeButton = By.xpath("//span[text()='Close']");
	
	public AccountCreateOrDeletePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Automation Exercise - Account Created")){
			reportStep("This is not Account Created Page", "FAIL");
		}		
	}
	
	public AccountCreateOrDeletePage verifyHeader(String data){
		verifyText(header, data);
		return this;
	} 
	
	public HomePage clickContinue(){
		clickByElement(continueButton);
		refreshPage();
		clickIfExists(continueButton);
		return new HomePage(driver, test);
	}

	
}
