package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import constant.Constant;

import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategory;

public class SubCategoryTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	SubCategory sc;
	
  @Test(groups="smoke")
  public void verifyAddANewSubCategoryWithValidDetails() throws IOException {
	  	lp = new LoginPage(driver);
	  	hp=lp.loginByUsingExcelData();
		sc=hp.clickOnSubCategoryButton();
		sc.addANewSubCategoryWithValidDetails();
		boolean actual = true;
		boolean expected = sc.getAlert().contains("Sub Category Created Successfully");
		Assert.assertEquals(actual, expected, Constant.lp_verifyNewSubCategory);
  }
  @Test
  public void verifyDeleteAnExistingSubCategory() throws IOException
  {
	  	lp = new LoginPage(driver);
	  	hp=lp.loginByUsingExcelData();
		sc=hp.clickOnSubCategoryButton();
		sc.deleteSubCategory();
		boolean actualDeleteAlert=true;
		boolean expectedDeleteAlert=sc.getAlertDelete().contains("Sub Category Deleted Successfully");
		Assert.assertEquals(actualDeleteAlert,expectedDeleteAlert,Constant.lp_deleteSubCategory);
  }
  @Test 
  public void verifySearchASubCategoryThatIsNotPresentIntheList() throws IOException
  {
	  	lp = new LoginPage(driver);
	  	hp=lp.loginByUsingExcelData();
		sc=hp.clickOnSubCategoryButton();
		sc.searchSubCategory();
		boolean actualsearchMeassage=true;
		boolean expectedsearchMeassage=sc.getSearchMsg().contains(".........RESULT NOT FOUND.......");
		Assert.assertEquals(actualsearchMeassage,expectedsearchMeassage,Constant.lp_searchSubCategory);
  }
  @Test(groups="smoke")
  public void verifyEditTheExistingSubCategory() throws IOException
  {		
	  	lp = new LoginPage(driver);
	  	hp=lp.loginByUsingExcelData();
		sc=hp.clickOnSubCategoryButton();
		sc.editSubCategory();
		boolean actualUpdateMessage=true;
		boolean expectedUpdateMessage=sc.getUpdateAlert().contains("Sub Category Updated Successfully");
		Assert.assertEquals(actualUpdateMessage,expectedUpdateMessage,Constant.lp_editSubCategory);
	  
  }
}
