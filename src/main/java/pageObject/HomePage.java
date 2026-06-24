package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseComponent{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Create Constructor (Moved to BaseComponent class)
	/*public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} */
	
	
	// Locators
	
	 @FindBy(xpath = "//span[normalize-space()='My Account']")
	 WebElement myAcc;
	 
	 @FindBy(xpath = "//a[normalize-space()='Register']")
	 WebElement register;
	 
	 @FindBy(xpath = "//a[normalize-space()='Login'][1]")
	 WebElement login;
	
	
	// Action Methods
	 
	 public void clickAcc() {
		// System.out.println("myAcc = " + myAcc);
		 myAcc.click();
	 }
	 
	 public void clickRegis() {
		 register.click();
	 }
	 
	 public void clickLogin() {
		 login.click();
	 }

}
