package utils;

import java.io.File;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public abstract class Reporter {
	public ExtentTest test;
	public static ExtentReports extent;
	public String testCaseName, testDescription, category, authors;

	public void reportStep(String desc, String status) {
		String encodedScreenshot = null;
		long snapNumber = 100000l;
		
		try {
			snapNumber= takeSnap();
			encodedScreenshot = Base64.getEncoder().encodeToString(Files.readAllBytes(new File("./reports/screenshots/"+snapNumber+".jpg").toPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Write if it is successful or failure or information
		if(status.toUpperCase().equals("PASS")){
			test.log(Status.PASS,desc);
		}else if(status.toUpperCase().equals("FAIL")){
			test.log(Status.FAIL, desc, MediaEntityBuilder.createScreenCaptureFromBase64String(encodedScreenshot).build());
			throw new RuntimeException("FAILED");
		}else if(status.toUpperCase().equals("INFO")){
			test.log(Status.INFO, desc);
		}else if(status.toUpperCase().equals("WARN")){
			test.log(Status.WARNING, desc, MediaEntityBuilder.createScreenCaptureFromBase64String(encodedScreenshot).build() );
		}
	}

	public abstract long takeSnap();
	

	public ExtentReports startResult(){
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./reports/result.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

	public ExtentTest startTestCase(String testCaseName, String testDescription){
		test = extent.createTest(testCaseName, testDescription);
		return test;
	}

	public void endResult(){		
		extent.flush();
	}
	
}