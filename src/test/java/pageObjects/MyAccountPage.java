package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	//constructor call
	   public MyAccountPage (WebDriver driver)
	    {
		  super(driver);  //super keyword is used to invoke immediate parent class constructor
	    }
	
	
	   //Locators
	   @FindBy(xpath="//h2[normalize-space()='My Account']")
	   WebElement MyAccountHeading;
	   
	   @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") //step 6
	   WebElement LogoutButton;
	   
	   
	   //Action method
	   //only implementation 
	   //validation is done in TC
	   public boolean isMyAccountPageExists()
	   {
		   try
		   {
			   return (MyAccountHeading.isDisplayed());
		   }
		   catch(Exception e)
		   {
			   return false;
		   }
	   }
	   
	   public void clickLogout() //step 6
	   {
		   LogoutButton.click();
	   }

}
