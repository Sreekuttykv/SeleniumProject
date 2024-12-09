package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import pages.LoginPage;
import pages.UserManagementPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtilities;

public class UserPageTest extends Base {
	
	PageUtility pageutility=new PageUtility();
	WaitUtilities waitutility=new WaitUtilities();
	UserManagementPage userpage;
	
	@Test(description="verify add a new user with valid details",retryAnalyzer=retry.Retry.class)
	public void verifyAddNewUser() throws IOException
	{
		String username=ExcelUtility.readStringData(1,0,"LoginPage");
		String password=ExcelUtility.readIntegerData(1, 1, "LoginPage");
		String prefix=ExcelUtility.readStringData(0,1,"UserPage");
		String firstName=ExcelUtility.readStringData(1,1,"UserPage");
		String lastName=ExcelUtility.readStringData(2,1,"UserPage");
		String email=ExcelUtility.readStringData(6,1,"UserPage");
		String userPassword=ExcelUtility.readIntegerData(4,1,"UserPage" );
		String confirmpassword=ExcelUtility.readIntegerData(5,1,"UserPage" );
		LoginPage loginpage=new LoginPage(driver);
		userpage=loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password)
		.clickOnLoginButton().clickOnUserManagementPage().clickOnUsersMenu().clickOnAddButton()
		.enterSurnameOnSurnameField(prefix).enterFirstnameOnFirstnameField(firstName)
		.enterLastnameOnLastnameField(lastName).enterEmailOnEmailField(email)
		.enterPasswordOnPasswordField(userPassword).enterPasswordOnConfirmPasswordField(confirmpassword)
		.clickOnSaveButton();
		boolean expectedAddAlert=true;
		boolean actualAddAlert=userpage.isAddAlertDisplayed();
		Assert.assertEquals(expectedAddAlert, actualAddAlert,"New user is not added successfully "); 	
	}
	@Test(description="verify delete an existing user from the user table")
	public void verifyDeleteAnExistingUser() throws IOException
	{
		String username=ExcelUtility.readStringData(1,0,"LoginPage");
		String password=ExcelUtility.readIntegerData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		userpage=loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password)
		.clickOnLoginButton().clickOnUserManagementPage().clickOnUsersMenu().clickOnDeleteButton();
		boolean actualDeleteAlert = true;
		boolean expectedDeleteAlert = userpage.isDeleteAlertDisplayed();
		Assert.assertEquals(actualDeleteAlert, expectedDeleteAlert,"user is not removed successfully ");
		
	}
	@Test(description="verify view an existing user")
	public void verifyViewAnExistingUser() throws IOException
	{
		
		String username=ExcelUtility.readStringData(1,0,"LoginPage");
		String password=ExcelUtility.readIntegerData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		userpage=loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password)
		.clickOnLoginButton().clickOnUserManagementPage().clickOnUsersMenu();
		userpage.clickOnViewButton();
		boolean expectedResult=true;
		boolean actualResult = userpage.isActiveButtonDisplayed();;
		Assert.assertEquals(actualResult, expectedResult,"Result not found ");
		
	}
	

}
