package testCase;

import org.testng.annotations.Test;

import utilities.ScreenShotCapture;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	ScreenShotCapture sc;
	public static Properties pro;
	public static void testBasic() throws IOException
	{
		pro=new Properties();
		FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\Properties\\Config.properties");
		pro.load(fp);
	}
  
  @BeforeMethod(alwaysRun = true)
  @Parameters("browser")
  public void beforeMethod(String browserName) throws IOException {
	  	testBasic();
	  	if(browserName.equals("Chrome"))
	  	{
	  		
	  		driver = new ChromeDriver();
	  	}
	  	else if(browserName.equals("Firefox"))
	  	{
	  		driver = new FirefoxDriver();
	  	}
		driver.get(pro.getProperty("baseurl")); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  

  @AfterMethod(alwaysRun = true)

	public void afterMethode(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			sc = new ScreenShotCapture();

			sc.captureFailureScreenShot(driver, iTestResult.getName());

		}

		driver.quit();

	}

}
