package testCase;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageContact;
import elementRepository.ManageNews;

public class ManageContactTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ManageContact mc;
  @Test
  public void verifyEditTheExistingContact() throws IOException
  {
	  	lp=new LoginPage(driver);
	  	hp=lp.loginByUsingExcelData();
		mc=hp.clickOnManageContact();
		mc.editContact();
		boolean actualUpdateAlert=true;
		boolean expectedUpdateAlert=mc.getUpdateAlert().contains("Contact Updated Successfully");
		Assert.assertEquals(actualUpdateAlert, expectedUpdateAlert,Constant.lp_editContact);
  }
}
