package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups = {"Sanity" , "Master"})
	public void verify_login()
	{
		try
		{
		logger.info("******* Starting TC002_LoginTest******");
		
		//create object for HomePage to access methods
	    //import HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//create object for LoginPage to access methods
	    //import LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLoginButton();
		
		//validation
		//create object for MyAccountPage to access methods
	    //import MyAccountPage
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean res = myacc.isMyAccountPageExists();
		//Assert.assertEquals(res, true);
		//or 
		Assert.assertTrue(res);
		logger.info("******* Ending TC002_LoginTest******");
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}

}
