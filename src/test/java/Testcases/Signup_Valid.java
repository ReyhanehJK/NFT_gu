package Testcases;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POM.HomePage_PageObjectModel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Signup_Valid {

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

		WebElement SignUpButton= driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[2]/div[2]/a/span"));
		SignUpButton.click();

		// Javascript executor
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(4000);

		//Locating the email field element via Name tag and storing it in the webelement
		WebElement subscribeForm_with_email=driver.findElement(By.xpath("//*[@id=\"subscribeForm\"]/input"));

		subscribeForm_with_email.click();
		subscribeForm_with_email.clear();

		//Generate a Valid Email address randomly and Enter it into the email field
		Random randomGeneratorEmail = new Random();  
		int randomInt = randomGeneratorEmail.nextInt(100);  
		subscribeForm_with_email.sendKeys("email"+ randomInt +"@gmail.com");

		WebElement SignUpButton2= driver.findElement(By.xpath("//*[@id=\"subscribeForm\"]/button"));
		SignUpButton2.click();
		Thread.sleep(4000);

		WebElement MessageOfSignup = driver.findElement(By.xpath("//*[@id=\"subscribeForm\"]/div"));	
		System.out.println("The Message is     "+MessageOfSignup.getText());

		//html report
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/Singup_Report.Html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println("Singup  Test");
		ExtentTest logger =	extent.createTest("Singup  Test");
		logger.log(Status.INFO, "QA Task");
		logger.log(Status.PASS, "All Test is    Passed");
		extent.flush();


		driver.close();
		driver.quit();
	}

}
