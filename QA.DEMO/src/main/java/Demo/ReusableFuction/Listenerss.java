package Demo.ReusableFuction;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class Listenerss implements ITestListener {
	WebDriver driver;
	public ExtentSparkReporter sparkReports; // ui of the reports
	public ExtentReports extentReports; // tester name , browsername, os
	public ExtentTest extentsTest;// creating the TC entries and update the reports and status of the reports

	@Override
	public void onStart(ITestContext contextStart) {
		// it execute only one time before start test
		System.out.println("onStart method started");
		sparkReports = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReports.html");
		sparkReports.config().setDocumentTitle("Automation Reports"); // title of the reports
		sparkReports.config().setReportName("Functional Test");// name of the reports
		sparkReports.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReports);

		// environment info ,os , testername,browserName

//		extentReports.setSystemInfo("Computer Name ", "localhost");
//		extentReports.setSystemInfo("Environmnet  ", "QA");
//		extentReports.setSystemInfo("TestName  ", "Thangabalu R");
//		extentReports.setSystemInfo("OS ", "Windows 11 ");
//		extentReports.setSystemInfo("Browser name ", "Chrome ");

	}

	@Override
	public void onTestStart(ITestResult result) {
		extentsTest = extentReports.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentsTest.log(Status.FAIL, "Test Failed : " + result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File paths = new File("C:\\Users\\thangrs\\hello1.png");
		try {
			Files.copy(scr, paths);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentsTest.log(Status.PASS, "Test Passed");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("i am finsher");
		extentReports.flush();

	}


	
}
