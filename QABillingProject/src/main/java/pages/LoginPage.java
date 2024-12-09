package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	@FindBy(id="username") private WebElement loginField;
	@FindBy(id="password") private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginButton;
	@FindBy(xpath="//label[@class='btn btn-info active']") private WebElement todayButton;
	@FindBy(xpath="//strong[text()='These credentials do not match our records.']")private WebElement alertMessage;

	public LoginPage enterUsernameOnUsernameField(String username)
	{
		loginField.sendKeys(username);
		return this;
	}
	public LoginPage enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	public UserManagementPage clickOnLoginButton()
	{
		loginButton.click();
		return new UserManagementPage(driver);
	}
	public boolean isTodayButtonDisplayed()
	{
		return todayButton.isDisplayed();
	}
	public String getAlertMessage()
	{
		return alertMessage.getText();
	}
	
	
}
