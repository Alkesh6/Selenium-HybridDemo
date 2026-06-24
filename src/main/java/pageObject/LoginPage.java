package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseComponent{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Locators
	 @FindBy(xpath = "//input[@id='input-email']")
	 WebElement email;
	 
	 @FindBy(xpath = "//input[@id='input-password']")
	 WebElement pass;
	 
	 @FindBy(xpath = "//input[@value='Login']")
	 WebElement loginBtn;
	 
	 // action methods
	 public void setEmail(String usersEmail) {
		 email.sendKeys(usersEmail);
	 }
	 
	 public void setPassword(String usersPass) {
		 pass.sendKeys(usersPass);
	 }
	 
	 public void clickLoginBtn() {
		 loginBtn.click();
	 }
	 
}
