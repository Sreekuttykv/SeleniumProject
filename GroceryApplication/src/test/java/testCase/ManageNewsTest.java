package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageNews;

public class ManageNewsTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ManageNews mn;
	
  @Test
  public void addNews() throws IOException {
		lp = new LoginPage(driver);
	  	hp=lp.loginByUsingExcelData();
		mn=hp.clickOnManageNews();
		mn.addNews();
		boolean actualaddAlert=true;
		boolean expectedaddAlert=mn.getAddAlert().contains("News Created Successfully");
		Assert.assertEquals(actualaddAlert, expectedaddAlert,Constant.lp_verifyAddNews);
		
  }

  @Test(groups="smoke")
  public void editNews() throws IOException
  {
	  	lp = new LoginPage(driver);
	  	hp=lp.loginByUsingExcelData();
		mn=hp.clickOnManageNews();
		mn.editNews();
		boolean actualUpdateAlert=true;
		boolean expectedUpdateAlert=mn.getUpdateAlert().contains("News Updated Successfully");
		Assert.assertEquals(actualUpdateAlert, expectedUpdateAlert,Constant.lp_editNews);
	  
  }
  @Test
  public void deleteNews() throws IOException
  {
	  	lp = new LoginPage(driver);
	  	hp=lp.loginByUsingExcelData();
		mn=hp.clickOnManageNews();
		mn.deleteNews();
		boolean actualDeleteAlert=true;
		boolean expectedDeleteAlert=mn.getDeleteAlert().contains("News Deleted Successfully");
		Assert.assertEquals(actualDeleteAlert, expectedDeleteAlert,Constant.lp_deleteNews);
	  
  }
  @Test
  public void searchNews() throws IOException
  {
	  	lp = new LoginPage(driver);
	  	hp=lp.loginByUsingExcelData();
		mn=hp.clickOnManageNews();
		mn.searchNews();
		boolean actualSearchAlert=true;
		boolean expectedSearchAlert=mn.getSearchAlert().contains("RESULT NOT FOUND");
		Assert.assertEquals(actualSearchAlert, expectedSearchAlert,Constant.lp_searchNews);
		
  }
  
}
