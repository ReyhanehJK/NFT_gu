package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage_PageObjectModel {
	

	// it just some example of POM model
		
		@FindBy(xpath="//*[@id=\\\"nav-menu\\\"]/li[3]/a")
		WebElement btn_Market;
		
		@FindBy(xpath="/html/body/div[2]/footer/div/div[3]/div/div/a[2]")
		WebElement TwitterLink;
		
		
		@FindBy(xpath="/html/body/div[2]/div/div/header/div/div[2]/div[1]/input")
		WebElement SearchField;
		
		@FindBy(xpath="/html/body/div[2]/div/div/header/div/div[2]/div[1]/button")
		WebElement SearchButton;
		
		
		@FindBy(xpath="/html/body/div[2]/div/div/header/div/div[2]/div[2]/a/span")
		WebElement SignUpButton;
		

		
		WebDriver driver;	
		public void SingUp_PF(WebDriver driver) {
			this.driver = driver;

			//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		}


		public void clickOnMarketButton() {
			btn_Market.click();
		}
		
		public void clickOnTwitterLink() {
			TwitterLink.click();
		}
		
		public void clickOnSearchField() {
			SearchField.click();
		}
		
		public void clickOnSearchButton() {
			SearchButton.click();
		}
		
		public void clickOnSignUpButton() {
			SignUpButton.click();
		}
		
	}