package pageObjectpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Abstractcomponents;

public class Orderpage extends Abstractcomponents{
	WebDriver driver;
	public Orderpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productitems;

	
	By val=By.cssSelector(".cartSection h3");
	
	public boolean VerifiyOrderDispaly(String product) {
		
		boolean	 match=productitems.stream().anyMatch(s-> s.getText().equalsIgnoreCase(product));
		 return match;
	}
		
}
