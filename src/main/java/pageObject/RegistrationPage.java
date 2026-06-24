package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseComponent{
	
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	// Create Constructor (Moved to BaseComponent class)
	/*public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} */
	
	// Locators
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	public
	WebElement email;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	public
	WebElement password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement agreeBtn;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//h1[normalize-space() = 'Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Action Methods
	
	public void getFirstName(String first) {
		firstName.sendKeys(first);
	}
	
	public void getLastName(String last) {
		lastName.sendKeys(last);
	}
	
	public void getEmail(String emailId) {
		email.sendKeys(emailId);
	}
	
	public void getTelephone(String myTelephone) {
		telephone.sendKeys(myTelephone);
	}
	
	public void getPassword(String myPass) {
		password.sendKeys(myPass);
	}
	
	public void getConfirmPass(String confirmPass) {
		confirmPassword.sendKeys(confirmPass);
	}
	
	public void clickAgree() {
		agreeBtn.click();
	}
	
	public void clickSubmit() {
		submitBtn.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	

}
