package pageObjectpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Utility.Abstractcomponents;

public class Homepage extends Abstractcomponents{
	WebDriver driver;
	public Homepage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="mb-3")
	List<WebElement> items;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	
	By item=By.className("mb-3");
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	By toaster= By.cssSelector("#toast-container");
	
	public List<WebElement> productList(){
		waitVisibilityOfElementLocated(item);
		return items;
	}
	public WebElement RequiiredProduct(String product) {
		WebElement item=productList().stream().filter(s->s.findElement(By.tagName("b")).getText().equals(product)).findFirst().orElse(null);
		
		return item;
	}
	public Cartpage addProducttoCart(String product) {
		RequiiredProduct(product).findElement(addtocart).click();
		waitVisibilityOfElementLocated(toaster);
		waitinVisibilityOfElement(spinner);
		Cartpage cpage=new Cartpage(driver);
		return cpage;
	}
	
	
	
	
	
}
