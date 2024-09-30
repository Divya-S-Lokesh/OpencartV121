package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	   //constructor call
	   public LoginPage (WebDriver driver)
	    {
		  super(driver);  //super keyword is used to invoke immediate parent class constructor
	    }
	   
	   //Locators
	   @FindBy(xpath="//input[@id='input-email']")
	   WebElement Email;
	   
	   @FindBy(xpath="//input[@id='input-password']")
	   WebElement Password;
	   
	   @FindBy(xpath="//input[@value='Login']") 
	   WebElement LoginButton;
	   
	   
	 //Action methods
	   public void setEmail(String email)
	   {
		   Email.sendKeys(email);
	   }

		public void setPassword(String pwd)
		{
			Password.sendKeys(pwd);
		}
		
		public void clickLoginButton()  
		{
			LoginButton.click();
		}


	
}
