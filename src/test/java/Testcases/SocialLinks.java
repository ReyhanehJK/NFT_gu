package Testcases;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POM.HomePage_PageObjectModel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SocialLinks {

	static WebDriver driver;
	static String BaseURL = "https://jungle.co/";
	HomePage_PageObjectModel	HomePage_POM;

	public static  void main(String[] args) throws InterruptedException {

		//the required driver (chromedriver) will be available for all the WebDriver tests using Chrome in this class.
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//	WebDriverManager.firefoxdriver().setup();
		//	WebDriver driver = new FirefoxDriver();

		driver.get(BaseURL);
		driver.manage().window().maximize();

		// Javascript executor
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(4000);

		driver.findElement(By.xpath("/html/body/div[2]/footer/div/div[3]/div/div/a[2]")).click();
		String expectedURLtwitter = "https://twitter.com/Junglenftmarket";
		String actualURLtwitter = driver.getCurrentUrl();
		assertTrue(actualURLtwitter.contains("jungle"));
		System.out.println(" ***Test Paass*** ");

		//html report
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/SocialLink_Report.Html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println("SocialLink Test");
		ExtentTest logger =	extent.createTest("SocialLink Test");
		logger.log(Status.INFO, "QA Task");
		logger.log(Status.PASS, "All Test is    Passed");
		extent.flush();

		driver.close();
		driver.quit();
	}

}
