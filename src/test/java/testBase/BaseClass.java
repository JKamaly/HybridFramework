package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

	public static WebDriver driver;
	public Logger logger;//org.apache.logging.log4j.Logger
	
	public ResourceBundle rb;
	
	@BeforeClass(groups = {"Master", "Sanity", "Regression"})
	@Parameters("browser")
	public void setup(String br) {
		rb=ResourceBundle.getBundle("config"); // load config.properties file
		
		logger=LogManager.getLogger(this.getClass());//logging
		
		//ChromeOptions option = new ChromeOptions();
		//option.setExperimentalOption ("excludeSwitches", new String[] {"enable-automation"});
		
		//WebDriverManager.chromedriver().setup();//in selenium 4.6.0 the webdriver manger is object is not required  
		//if you want to runt ChromeOptions you should passe the chrome option as parameter to the chromeDriver()
		
		if(br.equals("chrome")) {
		driver = new ChromeDriver();
		}else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL1"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = {"Master", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();

	}
	
	public String randomString() {
		
		String generateRandomString=RandomStringUtils.randomAlphabetic(5);
		
		return (generateRandomString);
	}
	public String randomNumeric() {
		String generateRandomNumbers=RandomStringUtils.randomNumeric(4);
		return (generateRandomNumbers);
	}
	
	public String randomAphaNum() {
		String str=RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (str +"@"+num);
	}
	
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e) {
			e.getMessage();
		}
		return destination;
	}
	
	

}
