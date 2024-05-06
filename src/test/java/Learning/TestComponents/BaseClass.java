package Learning.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectpages.Landingpage;

public class BaseClass {
	WebDriver driver;
	public Landingpage ldpage;
	public WebDriver initialization() throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Properties//GlobalData.properties");
		prop.load(file);
		String browserName=System.getProperty("Browser")!=null ? System.getProperty("Browser") : prop.getProperty("Browser");
//		prop.getProperty("Browser");
		if (browserName.equalsIgnoreCase("Edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Safari")) {
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
		}
		else {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	public List<HashMap<String,String>> getJsonData(String filePath) throws IOException
	{
		//reading json to string
	String jsonContent=	FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		//string to hashmap using Jackson Datbind
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
	
	});
	return data;
	
	}
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage launchURL() throws IOException {
		WebDriver driver=initialization();
		ldpage=new Landingpage(driver);
		ldpage.geturl();
		return ldpage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	
}
