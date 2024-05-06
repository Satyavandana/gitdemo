package Utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjectpages.Cartpage;
import pageObjectpages.Orderpage;

public class Abstractcomponents {
	WebDriver driver;
	WebDriverWait wait;
	Actions a;
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement order;
	
	public Abstractcomponents(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		this.a=new Actions(driver);
		PageFactory.initElements(driver,this);
		
	}
	
	public void waitVisibilityOfElementLocated(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitVisibilityOfWebElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		}
		
	public void waitinVisibilityOfElement(WebElement element) {
	wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	
	public void sendValue(WebElement element,String val) {
		a.sendKeys(element,val).build().perform();
	}
	
	public void movetoelement(WebElement element) {
		a.moveToElement(element).click().build().perform();
	}
	public Cartpage goToCart() {
		cart.click();
		Cartpage cpage=new Cartpage(driver);
		return cpage;
		
	}
	
	public Orderpage goToOrdersPage() {
		order.click();
		Orderpage opage=new Orderpage(driver);
		return opage;

		
		
	}
	
}
