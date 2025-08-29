package baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	
public static WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void Setup(String os, String br) throws IOException 
	{
		FileInputStream file= new FileInputStream("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid Browser"); return;
		
		}
		
		
		driver.get(p.getProperty("appURL"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void Teardown()
	{
		driver.quit();
	}
	
	
	public String randomStr()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNum()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname)
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMhhddmmss");
		Date dt=new Date();
		String timestamp= df.format(dt);
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user,dir")+"\\screenshots\\"+tname+"_"+timestamp;
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

	

	
	
	

}
