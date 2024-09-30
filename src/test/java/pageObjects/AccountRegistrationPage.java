package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	 //constructor call
	   public AccountRegistrationPage (WebDriver driver)
	    {
		  super(driver);  //super keyword is used to invoke immediate parent class constructor
	    }
	   
	   
	   
	 
	 //Locators
	   @FindBy(xpath="//input[@id='input-firstname']")
	   WebElement Firstname;
	   
	   
	   @FindBy(xpath="//input[@id='input-lastname']")
	   WebElement Lastname;
	   
	   @FindBy(xpath="//input[@id='input-email']")
	   WebElement Email;
	   
	   @FindBy(xpath="//input[@id='input-telephone']")
	   WebElement TelephoneNumber;
	   
	   @FindBy(xpath="//input[@id='input-password']")
	   WebElement Password;
	   
	   @FindBy(xpath="//input[@id='input-confirm']")
	   WebElement ConfirmPassword;
	   
	   @FindBy(xpath="//input[@name='agree']")
	   WebElement PolicyCheckbox;
	   
	   @FindBy(xpath="//input[@value='Continue']")
	   WebElement ContinueButton;
	   
	   @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	   WebElement ConformationMsg;
	   

	 //Action Methods
	 public void setFirstName(String fname)
	 {
		 Firstname.sendKeys(fname);
	 }
	 
	 public void setLastname(String lname)
	 {
		 Lastname.sendKeys(lname);
	 }
	 
	 public void setEmail(String email)
	 {
		 Email.sendKeys(email);
	 }
	 
	 public void setTelephoneNumber(String tel)
	 {
		 TelephoneNumber.sendKeys(tel);
	 }
	 
	 public void setPassword(String pwd)
	 {
		 Password.sendKeys(pwd);
	 }
	 
	 public void setConfirmPassword(String pwd)
	 {
		 ConfirmPassword.sendKeys(pwd);
	 }
	 
	 public void setPolicyCheckbox()
	 {
		 PolicyCheckbox.click();
	 }
	 
	 public void setContinueButton()
	 {
		 ContinueButton.click();
	 }
	 
	 
	 //validation should be done in test case 
	 //here we are just capturing the confirmation text and returning
	 public String getConformationMsg()
	 {
		 try
		 {
		return(ConformationMsg.getText());
	     }
		 
		 catch (Exception e)
		 {
			 return(e.getMessage());
		 }
	 }


}
