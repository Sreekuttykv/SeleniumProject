package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.CategoryPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class CategoryTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	CategoryPage cat;

	@Test
	public void verifyAddNewCategory() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		hp = lp.loginByUsingExcelData();
		cat = hp.clickOnCategory();
		cat.addCategory();
		boolean actualAddAlert = true;
		boolean expectedAddAlert = cat.getAddAlert().contains("Category Created Successfully");
		Assert.assertEquals(actualAddAlert, expectedAddAlert, Constant.lp_verifyAddCategory);
	}

	@Test
	  public void verifyDeleteCategory()throws IOException {
			
		lp=new LoginPage(driver);
		hp=lp.loginByUsingExcelData();
		cat=hp.clickOnCategory();
		cat.deleteCategory();
		boolean actualDeleteAlert=true;
		boolean expectedDeleteAlert=cat.getDeleteAlert().contains("Category Deleted Successfully");
		Assert.assertEquals(actualDeleteAlert, expectedDeleteAlert,Constant.lp_verifyDeleteCategory);
	}
}
