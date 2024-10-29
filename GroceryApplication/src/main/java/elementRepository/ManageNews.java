package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageNews {
	WebDriver driver;
	String newsName;
	HomePage hp;
	WaitUtilities wu;
	GeneralUtilities gu=new GeneralUtilities();
	public ManageNews(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wu=new WaitUtilities();
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']//i")
	WebElement newButton;
	@FindBy(xpath="//textarea[@id='news']")
	WebElement newTextArea;
	@FindBy(xpath="//textarea[@id='news']")
	WebElement editTextArea;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement createAlert;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath="//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlert;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//input[@class='form-control']")
	WebElement searchTextarea;
	@FindBy(xpath="//button[@name='Search']")
	WebElement redSearchButton;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")
	WebElement searchAlert;
	
	
	public void addNews()
	{
		String newsName="Groceryapplicationnews11"+gu.generateCurrentDateAndTime();
		this.newsName=newsName;
		newButton.click();
		newTextArea.sendKeys("Groceryapplicationnews11");
		saveButton.click();	
	}
	public String getAddAlert()
	{
		return createAlert.getText();
	}
	public void deleteNews()
	{
		deleteButton.click();
		driver.switchTo().alert().accept();
	}
	public String getDeleteAlert()
	{
		return deleteAlert.getText();
	}
	
	public void editNews()
	{
		editButton.click();
		editTextArea.clear();
		editTextArea.sendKeys("123");
		updateButton.click();
	}
	public String getUpdateAlert()
	{
		return updateAlert.getText();
	}
	public void searchNews()
	{
		searchButton.click();
		searchTextarea.sendKeys("Supermarket News");
		redSearchButton.click();
	}
	public String getSearchAlert()
	{
		return searchAlert.getText();
	}
}
