package Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

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
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Search_InValid {
	HomePage_PageObjectModel	HomePage_POM;
	static WebDriver driver;
	static String BaseURL = "https://jungle.co/";

	public static  void main(String[] args) throws IOException {

		//the required driver (chromedriver) will be available for all the WebDriver tests using Chrome in this class.
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//	WebDriverManager.firefoxdriver().setup();
		//	WebDriver driver = new FirefoxDriver();

		driver.get(BaseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement searchField= driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[2]/div[1]/input"));
		searchField.click();
		searchField.clear();
		searchField.sendKeys("+_)(*&^%#@$.1`");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[2]/div[1]/button")).click();

		//Take the Screenshot of product details
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir")+"/Reports/ScreenShotOfResult/SearchResult.png"));


		driver.close();
		driver.quit();
	}

}
