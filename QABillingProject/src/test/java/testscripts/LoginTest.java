package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automationcore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test(description="Login using valid credentials",groups={"smoke"},priority=1)
	public void verifyLoginWithValidUsernameAndValidPassword() throws IOException
	{
		String username=ExcelUtility.readStringData(1,0,"LoginPage");
		String password=ExcelUtility.readIntegerData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		boolean expectedResult=true;
		boolean isTodayButtonDisplayed=loginpage.isTodayButtonDisplayed();
		Assert.assertEquals(expectedResult, isTodayButtonDisplayed, "Login failed for valid credentials!");
	}
	@Test(description="Login using invalid username and valid password",groups= {"regression"},priority=2)
	public void verifyUnabletoLoginWithInvalidUsernameAndValidPassword() throws IOException
	{
		String expectedResult="These credentials do not match our records.";
		String username=ExcelUtility.readStringData(2,0,"LoginPage");
		String password=ExcelUtility.readIntegerData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		String actualResult=loginpage.getAlertMessage();
		Assert.assertEquals(actualResult, expectedResult,"Error message is not as expected");
	}
		
	@Test(description="Login using valid username and invalid password",groups={"smoke"})
	public void verifyUnabletoLoginWithValidUsernameAndInValidPassword() throws IOException
	{
		String expectedResult="These credentials do not match our records.";
		String username=ExcelUtility.readStringData(1,0,"LoginPage");
		String password=ExcelUtility.readIntegerData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		String actualResult=loginpage.getAlertMessage();
		Assert.assertEquals(actualResult, expectedResult,"Error message is not as expected");
	}
	@Test(dataProvider="loginProvider",description="Login using invalid username and invalid password")
	public void verifyUnabletoLoginWithInvalidUsernameAndInvalidPassword(String username,String password)
	{
		String expectedResult="These credentials do not match our records.";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		String actualResult=loginpage.getAlertMessage();
		Assert.assertEquals(actualResult, expectedResult,"Error message is not as expected");
	}
	@DataProvider(name="loginProvider")
	public Object[][] getDatafromDataProvider() throws IOException
	{
		return new Object[][] {new Object[] {"admin123","admin123"},
		new Object[] {"123","123"},
		new Object[] {ExcelUtility.readStringData(2,0,"LoginPage"),ExcelUtility.readIntegerData(2, 1, "LoginPage")},
		};
	}
		
}


