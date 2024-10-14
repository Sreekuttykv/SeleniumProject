package testCase;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import elementRepository.HomePage;
import elementRepository.LoginPage;

public class LoginPageTest extends BaseClass{
	LoginPage lp;
	HomePage hp;
	@Test
  public void verifyLoginWithValidData() {
	  lp=new LoginPage(driver);
	  lp.sentLoginDetail("admin","admin");
	  hp=new HomePage(driver);
	  String actual=hp.getHomePageText();   //text read from the pgm
	  String expected="7rmart supermarket";    //hardcoded text
	  Assert.assertEquals(actual, expected,"signin text not as expected");  
  } 
  
	 public void verifyLoginWithInValidData() {
	  lp=new LoginPage(driver);
	  lp.sentLoginDetail("tyh","ggfhg");
	  hp=new HomePage(driver);
	  String actual1=hp.getAlert1();
	  boolean expected1=actual1.contains("Invalid Username/Password");
	  Assert.assertEquals(actual1, expected1,"alert message is not as expected");   
}

 /* public void verifyLoginWithInValidData() {
	  lp=new LoginPage(driver);
	  lp.sentLoginDetail("tyh","ggfhg");
	  hp=new HomePage(driver); 
	  boolean actual=hp.getAlert();
	  boolean expected=true;
	  Assert.assertEquals(actual, expected,"Alert message is not as expected");   
  }*/
 
  @Test(dataProvider="data-provider")
  public void testCase01(String username,String password) 
  {
	  lp=new LoginPage(driver);
	  lp.sentLoginDetail(username,password);
  }
  @DataProvider (name = "data-provider")
 	public Object[][] dpMethod(){
 	return new Object[][] {{"admin", "test" }, {"demo","admin"},{"test","test"},{"admin","admin"}};
 	}
  
}
