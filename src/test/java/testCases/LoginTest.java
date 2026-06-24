package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testBase.Base;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import pageObject.RegistrationPage;

public class LoginTest extends Base{
	
	private String testEmail;
	private String testPassword;
	
	private void ensureTestUserRegistered() {
		testEmail = "test" + System.currentTimeMillis() + "@abc.com";
		testPassword = p1.getProperty("myPassword");

		HomePage hm = new HomePage(driver);
		hm.clickAcc();
		hm.clickRegis();

		RegistrationPage rp = new RegistrationPage(driver);

		rp.getFirstName(getRandomString());
		rp.getLastName(getRandomString());
		rp.getEmail(testEmail);
		rp.getTelephone(getRandomNum());
		rp.getPassword(testPassword);
		rp.getConfirmPass(testPassword);
		rp.clickAgree();
		rp.clickSubmit();

		String baseUrl = p1.getProperty("baseUrl");
		driver.get(baseUrl + "index.php?route=account/logout");
		driver.get(baseUrl);
	}
	
	@Test (groups= {"Regression"})
	public void verify_login() {
		logger.info("****Starting Login Test****");
		ensureTestUserRegistered();

		driver.get(p1.getProperty("baseUrl") + "index.php?route=account/login");
	    LoginPage lp = new LoginPage(driver);

	    lp.setEmail(testEmail);

	    lp.setPassword(testPassword);

	    lp.clickLoginBtn();

		
		
		//login page
		/*LoginPage lp=new LoginPage(driver);
		//lp.setEmail("test@codenbox.com");
		logger.info("Entered email for login");
		lp.setEmail(p1.getProperty("myEmail"));
		logger.info("Entered password for login");
		lp.setPassword(p1.getProperty("myPassword"));
		logger.info("Clicked on login button for login function");
		lp.clickLoginBtn();  */
		
		//my account page 
		MyAccountPage myact=new MyAccountPage(driver);
		logger.info("account page verification");
		SoftAssert sa=new SoftAssert();
		
		myact.isMyAccountExist(); //true 
		sa.assertTrue(myact.isMyAccountExist());//false
		//System.out.println("LoginTest failed"); // will not execute
		logger.info("Login Test failed");
		sa.assertAll();	
		
	}

}
