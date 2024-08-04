package api.utilities;

import java.text.SimpleDateFormat;

import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager implements ITestListener 
{

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    
    String repName;
    
	public void onStart(ITestContext testcontext) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		repName = "Test-Report-" +timestamp+".html";
	
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName); //Specify location of report
		
		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject"); //Title of report
		sparkReporter.config().setReportName("Pet Store User API");
		sparkReporter.config().setTheme(Theme.DARK); //
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Pet Store User API");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "JEETU");
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "test passed");
		
		
	}

	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.FAIL, "test failed");
		test.log(Status.FAIL,result.getThrowable().getMessage());
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.SKIP, "test Skipped");
		test.log(Status.SKIP,result.getThrowable().getMessage());
		
	}
	
	
	public void onFinish(ITestResult result)
	{
		extent.flush(); //helping to generate report
	}
	
	
	
	
	

}