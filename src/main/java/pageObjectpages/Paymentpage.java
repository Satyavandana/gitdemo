package pageObjectpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Utility.Abstractcomponents;

public class Paymentpage extends Abstractcomponents {

	WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement value;
	@FindBy(css=".action__submit")
	WebElement payment;
	@FindBy(xpath="//span[text()=' India']")
	WebElement Selector;
	By value1=By.xpath("//span[text()=' India']");
	public Paymentpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	
	public void selectCountry(String val) {
		 sendValue(value,val);
		 waitVisibilityOfElementLocated(value1);
		 movetoelement(Selector);
	}
	

	public Confirmationpage paymentClick() {
		payment.click();
		Confirmationpage confimpage= new Confirmationpage(driver);
		return confimpage;
	}
	
	
	
}
