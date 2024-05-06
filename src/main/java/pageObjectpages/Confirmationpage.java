package pageObjectpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Abstractcomponents;

public class Confirmationpage extends Abstractcomponents {

	
	WebDriver driver;
	
	public Confirmationpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		// TODO Auto-generated constructor stub
	}

	@FindBy(className="hero-primary")
	WebElement confirmationmsz;
	By val=By.className("hero-primary");
	
	public String confirmationMessage() {
		waitVisibilityOfElementLocated(val);
		String confirmationOrder= confirmationmsz.getText();
		return confirmationOrder;
	}
	
	
}
