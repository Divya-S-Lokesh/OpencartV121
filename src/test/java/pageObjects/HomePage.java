package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

  //constructor call
   public HomePage (WebDriver driver)
    {
	  super(driver);  //super keyword is used to invoke immediate parent class constructor
    }
   
   
  //Locators
   @FindBy(xpath="//a[@title='My Account']")
   WebElement Myaccount;
   
   @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
   WebElement Register;
   
   @FindBy(xpath="//a[normalize-space()='Login']") // from step 5
   WebElement Login;

 
   
   //Action methods
   public void clickMyAccount()
   {
	   Myaccount.click();
   }

	public void clickRegister()
	{
		Register.click();
	}
	
	public void clickLogin()  //login from step 5
	{
		Login.click();
	}
}
