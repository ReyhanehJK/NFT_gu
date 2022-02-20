package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POM.HomePage_PageObjectModel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TittleAndHeader {

	static WebDriver driver;
	static String BaseURL = "https://jungle.co/";
	HomePage_PageObjectModel	HomePage_POM;

	public static void main(String[] args) {

		//the required driver (chromedriver) will be available for all the WebDriver tests using Chrome in this class.
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//	WebDriverManager.firefoxdriver().setup();
		//	WebDriver driver = new FirefoxDriver();

		driver.get(BaseURL);
		driver.manage().window().maximize();

		//Expected URL and Title
		String expectedURL = "https://jungle.co/";
		String expectedPageTitle = "Jungle NFT | Buy, Sell & Create NFT Marketplace";


		//Actual URL and Title
		String actualURL = driver.getCurrentUrl();
		String actualPageTitle = driver.getTitle();

		System.out.println("The Current URL is     "+driver.getCurrentUrl());
		System.out.println("The Tittle is     "+driver.getTitle());

		//Assertion and verification of expected URL and actual URL
		Assert.assertEquals(actualURL, expectedURL);
		System.out.println(" ***Test Paass***   Expected URL = Actual URL");

		//Assertion and verification of expected Page Title and actual Page Title
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		System.out.println(" ***Test Paass***   Expected Page Title = Actual Page Title");
		
		
		
		WebElement ExploreButton= driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/li[2]/a"));
		ExploreButton.click();

		String	Frequentlyaskedquestions= driver.findElement(By.xpath("//*[@id=\"faq\"]/div")).getText();
		System.out.println(Frequentlyaskedquestions);
		
		
		WebElement	HowItWorks = driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/li[4]/a"));
		HowItWorks.click();	
		
		String Set_up_your_wallet = driver.findElement(By.xpath("//*[@id=\"steps\"]/div/div/div/div[1]/div")).getText(); System.out.println(Set_up_your_wallet);
	    String	Build_your_collection = driver.findElement(By.xpath("//*[@id=\"steps\"]/div/div/div/div[2]/div")).getText(); System.out.println(Build_your_collection);
	    String  Add_your_own_NFTs = driver.findElement(By.xpath("//*[@id=\"steps\"]/div/div/div/div[3]/div")).getText(); System.out.println(Add_your_own_NFTs);
	    String  List_NFTs_for_sale = driver.findElement(By.xpath("//*[@id=\"steps\"]/div/div/div/div[4]/div")).getText(); System.out.println(List_NFTs_for_sale);
	    	    
		//html report
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/TittleAndHeader_Report.Html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println("TittleAndHeader Test");
		ExtentTest logger =	extent.createTest("TittleAndHeader Test");
		logger.log(Status.INFO, "QA Task");
		logger.log(Status.PASS, "All Test is    Passed");
		extent.flush();


		driver.close();
		driver.quit();
	}

}
