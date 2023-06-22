package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.BaseTest;

public class SignUpPage  extends BaseTest {
	public static By header = By.xpath("//*[contains(text(),'Enter Account')]");
	public static By title = By.id("id_gender1");
	public static By name = By.id("name");
	public static By password = By.id("password");
	public static By days = By.id("days");
	public static By months = By.id("months");
	public static By years = By.id("years");
	public static By newsletter = By.id("newsletter");
	public static By optin = By.id("optin");
	public static By firstName = By.id("first_name");
	public static By lastName = By.id("last_name");
	public static By company = By.id("company");
	public static By address1 = By.id("address1");
	public static By address2 = By.id("address2");
	public static By country = By.id("country");
	public static By state = By.id("state");
	public static By city = By.id("city");
	public static By zipcode = By.id("zipcode");
	public static By mobileNumber = By.id("mobile_number");
	public static By createAccount = By.xpath("//button[@data-qa='create-account']");
	
	public SignUpPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Automation Exercise - Signup")){
			reportStep("This is not Sign Up Page", "FAIL");
		}		
	}
	
	public SignUpPage verifyHeader(String data){
		verifyText(header, data);
		return this;
	} 
	
	public SignUpPage clickTitle(){
		clickByElement(title);
		return this;
	}
	
	public SignUpPage enterName(String data){
		enterValue(name, data);
		return this;
	}
	
	public SignUpPage enterPassword(String data){
		enterValue(password, data);
		return this;
	}
	
	public SignUpPage selectDOB(String date){		
		String[] dob = date.split("-"); //Format dd-MMM-yyyy
		selectVisibileText(days, dob[0]);
		selectVisibileText(months, dob[1]);
		selectVisibileText(years, dob[2]);
		return this;
	}
	
	public SignUpPage clickNewsletter(){
		scrollIntoView(newsletter);
		clickByElement(newsletter);
		return this;
	}
	
	public SignUpPage clickOptin(){
		clickByElement(optin);
		return this;
	}
	
	public SignUpPage enterFirstName(String data){
		enterValue(firstName, data);
		return this;
	}
	
	public SignUpPage enterLastName(String data){
		enterValue(lastName, data);
		return this;
	}
	
	public SignUpPage enterCompany(String data){
		enterValue(company, data);
		return this;
	}
	
	public SignUpPage enterAddress1(String data){
		enterValue(address1, data);
		return this;
	}
	
	public SignUpPage enterAddress2(String data){
		enterValue(address2, data);
		return this;
	}
	
	public SignUpPage selectCountry(String data){
		selectVisibileText(country, data);		
		return this;
	}
	
	public SignUpPage enterState(String data){
		enterValue(state, data);
		return this;
	}
	
	public SignUpPage enterCity(String data){
		enterValue(city, data);
		return this;
	}
	
	public SignUpPage enterZipCode(String data){
		enterValue(zipcode, data);
		return this;
	}
	
	public SignUpPage enterMobileNumber(String data){
		enterValue(mobileNumber, data);
		return this;
	}
	
	public AccountCreateOrDeletePage clickCreate(){
		scrollIntoView(createAccount);
		clickByElement(createAccount);
		return new AccountCreateOrDeletePage(driver, test);
	}
}
