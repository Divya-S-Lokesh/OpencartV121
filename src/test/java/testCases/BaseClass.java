package testCases;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger;  //log4j
//Contains only common methods 
//parent of all testCases classes-------> instead of creating common methods for all the classes
public class BaseClass {
	public  WebDriver driver;
	public Logger logger; // for Log4j 
	public Properties p; //properties file 
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups = {"Sanity" ,"Regression" , "Master" , "Datadriven"})
	@Parameters ({"os","browser"})
	public void setup(String os, String br) throws IOException 
	{
		
		//loading config.properties file 
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		//Logger setting  
		//this.getclass() is used to get the class dynamically in to the logger
		logger = LogManager.getLogger(this.getClass());
		
		//condition to decide local/remote execution setup
		//REMOTE
		if(p.getProperty("execution_env").equals("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			//OS
			if (os.equalsIgnoreCase("Windows"))
			{
				cap.setPlatform(Platform.WIN10);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : cap.setBrowserName("chrome");
			break;
			case "edge" : cap.setBrowserName("MicrosoftEdge");
			break;
			case "firefox" : cap.setBrowserName("firefox");
			break;
			default : System.out.println("No matching browser");
			return;
			}
			
			driver= new RemoteWebDriver(new URL ("http://192.168.1.7:4444/wd/hub"), cap);
			

		}
		
		//LOCAL
	    if(p.getProperty("execution_env").equals("local"))
		{
		    //parallel testing 
			switch (br.toLowerCase())
			{
			case "chrome" : driver = new ChromeDriver();
			break;
			case "edge" : driver = new EdgeDriver();
			break;
			case "firefox" : driver = new FirefoxDriver();
			break;
			default : System.out.println("invalid browser");
			return;
		    }
			
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://tutorialsninja.com/demo/"); 
		driver.get(p.getProperty("appURL")); //using properties file to get URL instead
		driver.manage().window().maximize();
	}
		
	
	@AfterClass(groups = {"Sanity" ,"Regression" , "Master" , "Datadriven"})
	public void teardown()
	{
		driver.quit();
	}
	
	
	//RANDOM STRING AND NUMBER
	
	//generate random string of length 3
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		return generatedstring;
	}
	
	//generate random number of length 10
	public String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	//generate random AlphaNumeric and add "@" at the end 
	public String randomAlphaNumeric()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return (generatedstring +generatedNumber +"@");
	}
	
	//capture screenshot with time stamp
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	} 
}
