package Learning.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Learning.TestComponents.BaseClass;
import pageObjectpages.Cartpage;
import pageObjectpages.Confirmationpage;
import pageObjectpages.Homepage;
import pageObjectpages.Paymentpage;

public class Errorvalidation extends BaseClass{
	@Test(groups={"ErrorHanding"})
	public void BaseOrderErrormsz() throws IOException,InterruptedException {
		String product="IPHONE 13 PRO";
		String userName="satyavandana123@yopmail.com";
		String pwd="Login_123";
		ldpage.loginToApplication(userName, pwd);
		Assert.assertEquals("Incorrect email or password.",ldpage.getErrormessage());		
	}
	@Test
	public void ProductErrorValidation() throws IOException,InterruptedException {
		String product="IPHONE 13 PRO";
		String userName="sampleuser@yopmail.com";
		String pwd="Login_123";
		Homepage hp= ldpage.loginToApplication(userName, pwd);
		Cartpage cpage=hp.addProducttoCart(product);
		hp.goToCart();
		boolean val=cpage.selectedProductvalidation("IPHONE 13 PRO1");
		Assert.assertTrue(val);
	}

}
