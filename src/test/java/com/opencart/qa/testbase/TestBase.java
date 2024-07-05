package com.opencart.qa.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties p;
	public static Logger logger;
	@BeforeClass
	@Parameters({"browser","os"})
	public void setup(String browser, String os) throws Exception {
		FileInputStream propfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(propfile);
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}else {
				throw new Exception("Set a appropriate Platform");
			}
			
			switch (browser.toLowerCase()) {
			case "chrome": cap.setBrowserName("chrome");break;
			case "edge" : cap.setBrowserName("MicrosoftEdge");break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + browser.toLowerCase());
			}
			driver = new RemoteWebDriver(new URL("http://192.168.0.106:4444/wd/hub"),cap);
			
		}else {
			switch (browser.toLowerCase()) {
			case "chrome": WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
				break;
			case "edge": WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
				break;
//			case "firefox": WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//				break;
			default:throw new IllegalArgumentException("Invalid Browser Specified"+browser);
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
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
