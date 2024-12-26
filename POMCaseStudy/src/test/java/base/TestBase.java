package base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	private static TestBase testbase;
	private static WebDriver driver;
	
	private TestBase() {
		String strbrowser = "chrome";
		if(strbrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(strbrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		System.out.println("driver obj...." + driver);
		}
	public static void initDriver() {
		if(testbase ==null) {
			testbase = new TestBase();
		}
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void openUrl(String url) {
		driver.get(url);
		}
	public static void teardown() {
		if (driver !=null) {
			driver.close();
			driver.quit();
		}
		testbase = null;
	}
}
