package Learning.tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Learning.TestComponents.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectpages.Cartpage;
import pageObjectpages.Confirmationpage;
import pageObjectpages.Homepage;
import pageObjectpages.Landingpage;
import pageObjectpages.Orderpage;
import pageObjectpages.Paymentpage;


public class Testexection extends BaseClass{
	String product1="IPHONE 13 PRO";
	String userName1="satyavandana@yopmail.com";
	String pwd1="Login_123";
	String countrykeys="ind";
	String country="India";
	@Test(dataProvider="Data",groups= {"Purchase","smoke"})
//	public void BaseOrder(String userName, String pwd, String product) throws IOException,InterruptedException {
	public void BaseOrder(HashMap<String,String> input) throws IOException,InterruptedException {
		
		Homepage hp= ldpage.loginToApplication(input.get("email"), input.get("pwd"));
		Cartpage cpage=hp.addProducttoCart(input.get("product"));
		hp.goToCart();
		boolean val=cpage.selectedProductvalidation(input.get("product"));
		Assert.assertTrue(val);
		Paymentpage paypage=cpage.checkout();
		paypage.selectCountry(countrykeys);
		Confirmationpage confimpage= paypage.paymentClick();
		String confmes=confimpage.confirmationMessage();
		Assert.assertEquals(confmes.trim().toLowerCase(), "thankyou for the order.");	
	}
	
	@Test(dependsOnMethods={"BaseOrder"})
	public void OrderHistoryTest() throws InterruptedException {
		Homepage hp= ldpage.loginToApplication(userName1, pwd1);
		Thread.sleep(2000);
		Orderpage op=hp.goToOrdersPage();
		Assert.assertTrue(op.VerifiyOrderDispaly(product1));
	}
	
	
	@DataProvider
	public Object[][] Data() throws IOException	{
		
		
		List<HashMap<String,String>> hp=getJsonData(System.getProperty("user.dir")+"//src//test//java//Learning//data//PurchaseOrderfile.json");
		
		return new Object[][] {{hp.get(0)},{hp.get(1)}};
		
		
		
		
		
//	1st way
//		return new Object[][] {{"satyavandana@yopmail.com","Login_123","IPHONE 13 PRO"},{"sampleuser@yopmail.com","Login_123","ADIDAS ORIGINAL"}};
//		
//		2nd way
		
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "satyavandana@yopmail.com");
//		map.put("pwd", "Login_123");
//		map.put("product", "IPHONE 13 PRO");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "sampleuser@yopmail.com");
//		map1.put("pwd", "Login_123");
//		map1.put("product", "ADIDAS ORIGINAL");
	}
	
	
	
}
