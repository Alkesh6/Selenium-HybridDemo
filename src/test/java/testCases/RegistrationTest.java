package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegistrationPage;
import testBase.Base;

public class RegistrationTest extends Base {

	@Test(groups = {"Sanity" , "Regression"})
    public void registerUser() {

        HomePage h1 = new HomePage(driver);

        logger.info("***** Clicked on My Account Link *****");
        h1.clickAcc();

        logger.info("***** Clicked on Register Link *****");
        h1.clickRegis();

        RegistrationPage r1 = new RegistrationPage(driver);

        String email;
        String password;
        String firstName = getRandomString();
        String lastName = getRandomString();

        email = getRandomString() + "@abc.com";
        String phone = getRandomNum();

        password = getAlphaNumeric();

        logger.info("***** Entering Registration Details *****");

        r1.getFirstName(firstName);
        r1.getLastName(lastName);
        r1.getEmail(email);
        r1.getTelephone(phone);
        r1.getPassword(password);
        r1.getConfirmPass(password);

        r1.clickAgree();
        r1.clickSubmit();

        String actualMsg = r1.getConfirmationMsg();

        if(actualMsg.equals("Your Account Has Been Created!")) {

            System.out.println("\n===== Registration Details =====");
            System.out.println("Email    : " + email);
            System.out.println("Password : " + password);
            System.out.println("================================\n");

            Assert.assertTrue(true);

        } else {

            Assert.fail("Registration Failed");
        }

        logger.info("***** Registration Completed *****");
    }

}