package Testcases;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Signup_InValid {
	static WebDriver driver;
	static String BaseURL = "https://jungle.co/";

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

		//Generate a InValid Email address randomly and Enter it into the  Email field
		Random randomGeneratorEmail = new Random();  
		int randomInt = randomGeneratorEmail.nextInt(10);  
		subscribeForm_with_email.sendKeys("email"+ randomInt +"InValid");

		WebElement SignUpButton2= driver.findElement(By.xpath("//*[@id=\"subscribeForm\"]/button"));
		SignUpButton2.click();	
		Thread.sleep(4000);

		// Find the Subscribe field 
		WebElement Subscribe = driver.findElement(By.xpath("//*[@id=\"subscribeForm\"]/button"));

		//get the value of the "title" attribute 
		String actualTooltip = Subscribe.getAttribute("subscribeForm");
		System.out.println(actualTooltip);
		System.out.println("The Pop-up page was present corectly");	


		driver.close();
		driver.quit();
	}

}
