package testCases;


//import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationPage extends BaseClass{

	
	@Test(groups = {"Regression" , "Master"})
	public void verify_account_registration()
	{
		logger.info("******* Starting TC001_AccountRegistrationPage******");
		try
		{
		//create object for HomePage to access methods
		//import HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("***** Clicked on clickMyAccount*******");
		hp.clickRegister();
		logger.info("***** Clicked on clickRegister*****");
		
	
		//create object for AccountRegistrationPage to access methods
		//import AccountRegistrationPage
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("*****Providing customer details******");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephoneNumber(randomNumber());
		
		//create variable to store randomAlphaNumeric 
		//password should be same for both password and ConfirmPassword
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPolicyCheckbox();
		regpage.setContinueButton();
		
		logger.info("*****validating expeceted message******");
		//confirmation Message validation 
		//store getConformationMsg in a variable
		//pass variable and the "actual message"
		String confirmMsg = regpage.getConformationMsg();
		
		if (confirmMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("******test failed******");
			logger.debug("******debug log******");
			Assert.assertTrue(false);
		}
		}
		
		catch (Exception e) 
		{
	        Assert.fail();
		}
		logger.info("*******Ending TC001_AccountRegistrationPage******");
	}
}
