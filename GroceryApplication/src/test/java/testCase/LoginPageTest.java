package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void verifyLoginWithValidData() throws IOException {
		lp = new LoginPage(driver);
		hp=lp.loginByUsingExcelData();
		String actual = hp.getHomePageText(); // text read from the pgm  
		String expected = "7rmart supermarket"; // hardcoded text
		softAssert.assertEquals(actual, expected, Constant.lp_verifyLoginWithValidData); //soft assert
	}
	
	@Test(dataProvider = "data-provider")
	public void verifyLoginWithInValidData(String username,String password) throws IOException {
		lp = new LoginPage(driver);
		hp=lp.sentLoginDetail(username, password);
		boolean actual = true;
		boolean expected =lp.getAlert().contains("Invalid Username/Password");
		Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
	}
	
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][]{{ "admin","test"},{"abc","admin"},{"123","123"}};
	}

}
