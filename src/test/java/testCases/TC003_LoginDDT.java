package testCases;

import org.testng.Assert;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven") //getting dataproviders from different package
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("******* Starting TC003_LoginDDT******");
		try 
		{
		//create object for HomePage to access methods
	    //import HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//create object for LoginPage to access methods
	    //import LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLoginButton();
		

		//validation
		//create object for MyAccountPage to access methods
	    //import MyAccountPage
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean result = myacc.isMyAccountPageExists();
		
		/*Data is valid  - login success - test pass  - logout
		                 -- login failed - test fail

		Data is invalid - login success - test fail  - logout
		                - login failed - test pass*/
		
		//1)for valid data
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(result==true)
			{
				myacc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(result==true)
			{
				myacc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}		
		catch(Exception e)
		{
			Assert.fail("An exception occurred:" + e.getMessage());
		}
		logger.info("******* Ending TC003_LoginDDT******"); 
				
	}

}