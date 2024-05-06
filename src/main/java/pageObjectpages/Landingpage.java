package pageObjectpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Abstractcomponents;

public class Landingpage extends Abstractcomponents {
	WebDriver driver;

	@FindBy(id="userEmail")
	WebElement useremail;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut'")
	WebElement errormsz;

	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void geturl(){
		driver.get("https://rahulshettyacademy.com/client/");
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	public Homepage loginToApplication(String uname,String pwd) {
		useremail.sendKeys(uname);
		password.sendKeys(pwd);
		submit.click();
		Homepage hp= new Homepage(driver);
		return hp;
	}
	
	public String getErrormessage(){
		waitVisibilityOfWebElement(errormsz);
		return errormsz.getText();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	
}
