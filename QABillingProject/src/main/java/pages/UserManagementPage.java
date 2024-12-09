package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtilities;

public class UserManagementPage {
	
	PageUtility pageutility = new PageUtility();
	WaitUtilities waitutility=new WaitUtilities();
	public WebDriver driver;
	public UserManagementPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);  
	}
	
	@FindBy(xpath="//span[text()='User Management']") private WebElement usermanagementmenu;
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users']") private WebElement usermenu;
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users/create']") private WebElement addbutton;
	@FindBy(xpath="//input[@id='surname']") private WebElement prefixField;
	@FindBy(xpath="//input[@id='first_name']")private WebElement firstnameField;
	@FindBy(xpath="//input[@id='last_name']") private WebElement lastnameField;
	@FindBy(xpath="//input[@id='email']")private WebElement emailField;
	@FindBy(xpath="//select[@class='form-control select2 select2-hidden-accessible' and @id='role']")private WebElement roleField;
	@FindBy(xpath="//input[@id='username']")private WebElement usernameField;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordField;
	@FindBy(xpath="//input[@id='confirm_password']")private WebElement confirmPasswordField;
	@FindBy(xpath="//button[@id='submit_user_button']")private WebElement saveButtonField;
	@FindBy(xpath="//button[@class='btn btn-xs btn-danger delete_user_button']")private WebElement deleteButton;
	@FindBy(xpath="//a[@class='btn btn-xs btn-info']")private WebElement viewButton;
	@FindBy(xpath="//button[text()='OK']")private WebElement okButton;
	@FindBy(xpath="//div[text()='User deleted successfully']")private WebElement deleteAlert;
	@FindBy(xpath="//div[text()='User added successfully']")private WebElement AddAlert;
	@FindBy(xpath="//span[text()='Active']")private WebElement activeButton;
	
	
	public UserManagementPage clickOnUserManagementPage()
	{
		pageutility.clickJavaScriptExecutor(usermanagementmenu, driver);
		return this;
		
	}
	public UserManagementPage clickOnUsersMenu()
	{
		pageutility.clickJavaScriptExecutor(usermenu, driver);
		return this;
	}
	public UserManagementPage clickOnAddButton()
	{
		pageutility.clickJavaScriptExecutor(addbutton, driver);	
		return this;
	}
	public UserManagementPage enterSurnameOnSurnameField(String surname)
	{
		prefixField.sendKeys(surname);
		return this;
	}
	public UserManagementPage enterFirstnameOnFirstnameField(String firstname)
	{
		firstnameField.sendKeys(firstname);
		return this;
	}
	public UserManagementPage enterLastnameOnLastnameField(String lastname)
	{
		lastnameField.sendKeys(lastname);
		return this;
	}
	
	public UserManagementPage enterEmailOnEmailField(String email)
	{
		emailField.sendKeys(email+pageutility.generateCurrentDateAndTime());
		return this;
	}
	public UserManagementPage enterPasswordOnPasswordField(String accountpassword)
	{
		passwordField.sendKeys(accountpassword);
		return this;
	}
	public UserManagementPage enterPasswordOnConfirmPasswordField(String confirmaccountpassword)
	{
		confirmPasswordField.sendKeys(confirmaccountpassword);
		return this;
	}
	public UserManagementPage clickOnSaveButton()
	{
		pageutility.clickJavaScriptExecutor(saveButtonField, driver);
		return this;
	}
	public UserManagementPage clickOnDeleteButton()
	{
		waitutility.waitUntilElementIsVisible(driver, deleteButton);
		deleteButton.click();
		okButton.click();
		return this;
	}
	public UserManagementPage clickOnViewButton()
	{
		waitutility.waitUntilElementIsVisible(driver, viewButton);
		pageutility.clickJavaScriptExecutor(viewButton, driver);
		return this;
	}
	public String readUserTableElement(int row,int column)
	{
		String path="//table[@class='table table-bordered table-striped dataTable no-footer']//tbody//tr//td[1]";
		WebElement element=driver.findElement(By.xpath(path));
		return element.getText();
	}
	public boolean isDeleteAlertDisplayed() {
		return deleteAlert.isDisplayed();
	}
	
	public boolean isAddAlertDisplayed() {
		return AddAlert.isDisplayed();
	}
	public boolean isActiveButtonDisplayed()
	{
		return activeButton.isDisplayed();
	}
	
	
}
	
	
	
	
	


