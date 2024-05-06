package pageObjectpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Abstractcomponents;

public class Cartpage extends Abstractcomponents {
	WebDriver driver;
	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartitems;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	By val=By.cssSelector(".cartSection h3");
	
	public boolean selectedProductvalidation(String product) {
		waitVisibilityOfElementLocated(val);
		boolean	 match=cartitems.stream().anyMatch(s-> s.getText().equalsIgnoreCase(product));
		 return match;
	}
	
	public Paymentpage checkout() {
		checkout.click();
		Paymentpage paypage=new Paymentpage(driver);
		return paypage;
	}
}
