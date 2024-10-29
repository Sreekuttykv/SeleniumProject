package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class AdminUser {
	WebDriver driver;
	String adminName;
	HomePage hp;
	WaitUtilities wu;
	GeneralUtilities gu=new GeneralUtilities();
	public AdminUser(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wu=new WaitUtilities();
	}

	@FindBy(xpath="/html/body/div/div[1]/section/div[1]/a[1]")
	WebElement rednewbutton ;
	@FindBy(xpath="//h3[text()='Admin Users Informations']")
	WebElement adminuserpageheader ;
	@FindBy(xpath="//input[@id='username']")
	WebElement usernamefield ;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordfield ;
	@FindBy(xpath="//select[@id='user_type']")
	WebElement dropdownforusertype ;
	@FindBy(xpath="//button[@name='Create']")
	WebElement redsavebutton ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertbox ;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//input[@id='un']")
	WebElement searchTextArea;
	@FindBy(xpath="//select[@id='ut']")
	WebElement searchDropDown;
	@FindBy(xpath="//button[@name='Search']")
	WebElement redSearchButton;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")
	WebElement resultNotFoundMsg;
	@FindBy(xpath="//i[@class='fas fa-trash-alt'] ")
	WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlert;
	public void addAdminUser()
	{
		String adminName=gu.generateCurrentDateAndTime();
		this.adminName=adminName;
		rednewbutton.click();
		usernamefield.sendKeys(adminName);
		passwordfield.sendKeys("1234");
		gu.selectDropdownWithIndex(dropdownforusertype, 2);
		redsavebutton.click();
		
	}
	public String getAdminName()
	{
		return adminName;
	}
	public String getAddAlert()
	{
		return alertbox.getText();
	}
	public void searchAdminUser()
	{
		searchButton.click();
		searchTextArea.sendKeys(gu.generateCurrentDateAndTime());
		gu.selectDropdownWithIndex(searchDropDown, 1);
		redSearchButton.click();	
	}
	public String getSearchAlert()
	{
		return resultNotFoundMsg.getText();
	}
	public void deleteAdminUser()
	{
		deleteButton.click();
		driver.switchTo().alert().accept();	
	}
	public String deleteAlert()
	{
		return deleteAlert.getText();
	}
}
