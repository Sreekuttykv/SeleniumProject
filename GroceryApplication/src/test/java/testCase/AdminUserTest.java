package testCase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminUser;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class AdminUserTest extends BaseClass {
	
	HomePage hp;
	LoginPage lp;
	AdminUser au;
	
  @Test
  public void verifyAddingANewAdminUser() throws IOException
  {
	  	lp = new LoginPage(driver);
	  	hp=lp.loginByUsingExcelData();
		au=hp.clickOnAdminUser();
		au.addAdminUser();
		boolean actualAddAlert=true;
		boolean expectedAddAlert=au.getAddAlert().contains("User Created Successfully");
		Assert.assertEquals(actualAddAlert, expectedAddAlert,Constant.lp_verifyAddAdminUser);	
  }
  @Test
  public void verifySearchTheAdminUserThatIsNotPresentInTheList() throws IOException
  {
	  	lp = new LoginPage(driver);
		hp=lp.loginByUsingExcelData();
		au=hp.clickOnAdminUser();
		au.searchAdminUser();
		boolean actualSearchAlert=true;
		boolean expectedSearchAlert=au.getSearchAlert().contains(".........RESULT NOT FOUND.......");
		Assert.assertEquals(actualSearchAlert, expectedSearchAlert,Constant.lp_verifySearchAdminUser);	
  }
  @Test
  public void verifyDeleteAnExistingAdminUser() throws IOException
  {
	  lp = new LoginPage(driver);
	  hp=lp.loginByUsingExcelData();
	  au=hp.clickOnAdminUser();
	  au.deleteAdminUser();
	  boolean actualDeleteAlert=true;
	  boolean expectedDeleteAlert=au.deleteAlert().contains("User Deleted Successfully");
	  Assert.assertEquals(actualDeleteAlert, expectedDeleteAlert,Constant.lp_verifydeleteAdminUser);
	  
  }
  
}
