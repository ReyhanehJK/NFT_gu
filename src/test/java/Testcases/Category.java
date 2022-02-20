package Testcases;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POM.HomePage_PageObjectModel;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Category {
	static HomePage_PageObjectModel	HomePage_POM;
	static WebDriver driver;
	static String BaseURL = "https://jungle.co/";

	@SuppressWarnings("deprecation")
	public static  void main(String[] args) throws IOException {

		//the required driver (chromedriver) will be available for all the WebDriver tests using Chrome in this class.
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//	WebDriverManager.firefoxdriver().setup();
		//	WebDriver driver = new FirefoxDriver();

		driver.get(BaseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement MarketButton= driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/li[3]/a"));
		MarketButton.click();

		String ActualTittle=driver.findElement(By.xpath("//*[@id=\"market\"]/div/h2")).getText();
		System.out.println("The Tittle of Market is   =  "+ActualTittle);

		String Category=driver.findElement(By.xpath("//*[@id=\"market\"]/div/div/div")).getText();
		System.out.println("The List of Category   =  "+Category);


		driver.close();
		driver.quit();
	}

}