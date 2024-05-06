package Learning.tests;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Standedcode {

	public static void main(String[] args) {
		String product="IPHONE 13 PRO";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.findElement(By.id("userEmail")).sendKeys("satyavandana@yopmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Login_123");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mb-3")));
		List<WebElement> items= driver.findElements(By.className("mb-3"));
		
		
		WebElement item=items.stream().filter(s->s.findElement(By.tagName("b")).getText().equals(product)).findFirst().orElse(null);
		item.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartitems=driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match=cartitems.stream().anyMatch(s-> s.getText().equalsIgnoreCase(product));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"ind").build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ta-item']")));
		a.moveToElement(driver.findElement(By.xpath("//span[text()=' India']"))).click().build().perform();
//		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
//		List<WebElement> countries=driver.findElements(By.xpath("//button[@class=\'ta-item list-group-item ng-star-inserted\']"));
//		List<WebElement> count=countries.stream().filter(c-> c.getText().equalsIgnoreCase("India")).collect(Collectors.toList());
//		count.get(0).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmationOrder=driver.findElement(By.className("hero-primary")).getText();
		Assert.assertEquals(confirmationOrder.trim().toLowerCase(), "thankyou for the order.");
	
	
	
	}
	

}
