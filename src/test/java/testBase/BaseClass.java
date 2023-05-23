package testBase;

import java.io.File;

import java.io.IOException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	@Parameters({"browser"})
	@BeforeClass(groups = {"Sanity", "Regression", "Master"})
	public void setup(String br) {
		logger = LogManager.getLogger(this.getClass());
		rb = ResourceBundle.getBundle("config");
		
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"Sanity", "Regression", "Master"})
	public void tearDown() {
		driver.close();
	}
	
	public String randomString() {
		String genStr = RandomStringUtils.randomAlphabetic(5);
		return genStr;
	}
	
	public String randomNumber() {
		String genNum = RandomStringUtils.randomNumeric(10);
		return genNum;
	}
	
	public String randomAlphaNumeric() {
		String num = RandomStringUtils.randomNumeric(4);
		String alp = RandomStringUtils.randomAlphabetic(3);
		return alp + "@" + num;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}	
