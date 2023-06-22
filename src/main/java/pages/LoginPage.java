package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.BaseTest;

public class LoginPage extends BaseTest{
	public static By email = By.xpath("//input[@data-qa='login-email']");
	public static By header = By.xpath("//h2[contains(text(),'New User')]");
	public static By loginheader = By.xpath("//h2[contains(text(),'Login')]");
	public static By password = By.xpath("//input[@data-qa='login-password']");
	public static By login = By.xpath("//button[@data-qa='login-button']");
	public static By signUpName = By.xpath("//input[@data-qa='signup-name']");
	public static By signUpEmail = By.xpath("//input[@data-qa='signup-email']");
	public static By signUpButton = By.xpath("//button[@data-qa='signup-button']");
	public static By errorMsgLogin = By.xpath("//button[@data-qa='login-button']/preceding-sibling::p");
	
	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Automation Exercise - Signup / Login")){
			reportStep("This is not Login Page", "FAIL");
		}		
	}

	public LoginPage enterEmail(String data){
		enterValue(email, data);
		return this;
	}
		
	public LoginPage enterPassword(String data){		
		enterValue(password, data);	
		return this;
	}
	
	public HomePage clickLogin(){
		clickByElement(login);
		return new HomePage(driver, test);
	}
	
	public LoginPage clickLoginForFailure(){
		clickByElement(login);
		return this;
	}
	
	public LoginPage verifyErrMsg(String text){
		verifyText(errorMsgLogin, text);
		return this;
	}
	
	public LoginPage enterSignupName(String data){
		enterValue(signUpName, data);
		return this;
	}
	
	
	public LoginPage enterSignUpEmail(String data){		
		enterValue(signUpEmail, data);	
		return this;
	}
	
	public SignUpPage clickSignUpButton(){
		clickByElement(signUpButton);
		return new SignUpPage(driver, test);
	}
	
	public LoginPage verifySignUpHeader(String data){
		verifyText(header, data);
		return this;		
	}
	
	public LoginPage verifyLoginHeader(String data){
		verifyText(loginheader, data);
		return this;		
	}

}

















