package Testcases;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POM.HomePage_PageObjectModel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Responsive {

	HomePage_PageObjectModel	HomePage_POM;
	static String BaseURL = "https://jungle.co/";
		@DataProvider
		public Object[][] mobileEmulations(){
			return new Object[][] {
				{"iPad Mini", 768,1024},
				{"iPhone X", 375,812},
				{"Nexus 5", 360,640},
				{"Pixel 2", 411,731}
			};
		}
		@Test(dataProvider = "mobileEmulations")
		public void validateResponsive(String emulation, int w, int h) {
			
			//the required driver (chromedriver) will be available for all the WebDriver tests using Chrome in this class.
			WebDriverManager.chromedriver().setup();

			
		//	WebDriverManager.firefoxdriver().setup();
		//	WebDriver driver = new FirefoxDriver();
			
			Map<String, String> deviceMobEmu = new HashMap<>();
			deviceMobEmu.put("deviceName", emulation);
			ChromeOptions chromeOpt = new  ChromeOptions();
			chromeOpt.setExperimentalOption("mobileEmulation", deviceMobEmu);
			
			WebDriver driver = new ChromeDriver(chromeOpt);
		
			Dimension d = new Dimension(w, h);
			driver.manage().window().setSize(d);
			driver.get(BaseURL);
					  
				
			//html report
			ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/Responsive_Report.Html");
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			System.out.println("Responsive Test");
			ExtentTest logger =	extent.createTest("Responsive Test");
			logger.log(Status.INFO, "QA Task");
			logger.log(Status.PASS, "All Test is    Passed");
			extent.flush();
			
			
			driver.close();
			driver.quit();
		}
	}


