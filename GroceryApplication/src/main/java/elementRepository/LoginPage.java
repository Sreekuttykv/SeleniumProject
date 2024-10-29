package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.WaitUtilities;

public class LoginPage {
	WebDriver driver;
	WaitUtilities wu;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")
	WebElement userNameField;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMessage;
	
	
	public HomePage loginByUsingExcelData() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0,"LoginPage1");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage1");
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
		return new HomePage(driver);  //for chaining of pages(calling hp constructor)
	}
	public HomePage sentLoginDetail(String username,String password)
	{
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
		return new HomePage(driver); 
	}
	public String getAlert()
	{
		return alertMessage.getText();
	} 
	
}
