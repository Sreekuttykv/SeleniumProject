package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
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
	
	
	public void sentLoginDetail(String username,String password)
	{
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
	}
	
	

}
