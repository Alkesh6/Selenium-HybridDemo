 package testBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Base {

public WebDriver driver;
// public Logger logger; 
public Properties p1;
public FileInputStream f1;
	
public Logger logger = LogManager.getLogger(Base.class);
	@BeforeTest(alwaysRun = true)
	@Parameters({ "Browser" })
	public void setup(String browserName) {
		System.out.println("Setup method executed");
		System.out.println("Driver initialized = " + driver);
		logger = LogManager.getLogger(this.getClass());   // Get log4j from xml file
		
		p1 = new Properties();
		try {
	        f1 = new FileInputStream("./src/test/resources/data.properties");
	        p1.load(f1);
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }
		
		
		
		switch(browserName.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		default : System.out.println("Browser does not exist !"); return;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// driver.get("https://tutorialsninja.com/demo/");
		driver.get(p1.getProperty("baseUrl"));
		driver.manage().window().maximize();
	}
	
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}  
	
	
	// Copy alpha , numeric functions here
	public String getRandomString() {
		return RandomStringUtils.secure().nextAlphabetic(6);
	}
	
	public String getRandomNum() {
		return RandomStringUtils.secure().nextNumeric(10);
	}
	
	public String getAlphaNumeric() {
		String val =  RandomStringUtils.secure().nextAlphanumeric(7);
		return val+"@";
	}
	
}
