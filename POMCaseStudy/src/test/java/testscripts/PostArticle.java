package testscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import base.TestBase;
import commonUtlis.ScreenSSPage;
import pages.DeletePage;
import pages.EditPage;
import pages.FailedScript;
import pages.LoginPage;
import pages.NewArticle;

public class PostArticle {
	
	WebDriver driver;
	LoginPage loginpage;
	NewArticle newarticle;
	EditPage editpage;
	DeletePage deletepage;
	FailedScript failedscript;
	ScreenSSPage SSP;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	public PostArticle() {
		
		TestBase.initDriver();
		driver = TestBase.getDriver();
		loginpage = new LoginPage(driver);
		newarticle = new NewArticle(driver);
		editpage = new EditPage(driver);
		deletepage = new DeletePage(driver);
		failedscript = new FailedScript(driver);
		SSP = new ScreenSSPage();
		

	}
	@BeforeTest
	public void setup() {
		
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/sparkreport.html").viewConfigurer().viewOrder().as(new ViewName[] 
				{
						ViewName.DASHBOARD,
						ViewName.TEST,
						ViewName.AUTHOR,
						ViewName.DEVICE,
						ViewName.LOG
				}).apply();
		extentReports.attachReporter(spark);
		
	}
	
	
	@Test (priority = 1)
	public void loginpage()
	{
		loginpage.validLogin("devamahe93@gmail.com", "Selenium@2468");
		
	}
	
	@Test (priority = 2)
	public void newarctile()
	{
	newarticle.NewArticle();
	newarticle.CreateArticle("selenium31122024", "Selenium first Project", "Selenium first Project using POM and testNg framework", "@selenium, @TestNG, @POM");
	}
	
	@Test (priority = 3)
	public void Editpage()
	{
		editpage.Editarticle();
		editpage.Arttitle("selenium21122024");	
	}
	
	@Test (priority = 4)
	public void Deletepage()
	{
		deletepage.deleteArc();
		Alert del = driver.switchTo().alert();
		del.accept();
	}
	@Test (priority = 5)
	public void failedscript()
	{
		failedscript.failedsce();
	}
	
	@AfterMethod
	public void teardown (ITestResult result)
	{
		extentTest = extentReports.createTest("POMCaseStudy");
		extentTest.assignAuthor("SeleniumUser")
		.assignCategory("Regression")
		.assignDevice(System.getProperty("os.name"))
		.assignDevice(System.getProperty("os.version"));
		if(ITestResult.FAILURE == result.getStatus()) {
			extentTest.log(Status.FAIL, result.getThrowable().getMessage());
			String strPath = SSP.getScreenshotPath(driver);
		    extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
		}	
		}
	@AfterTest
	public void finishExtent() 
	{
		extentReports.flush();
		}
}
