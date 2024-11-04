package elementRepository;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class CategoryPage {
	WebDriver driver;
	WaitUtilities wu=new WaitUtilities();
	String CategoryName;
	GeneralUtilities gu=new GeneralUtilities();
	
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	WebElement newButton;
	@FindBy(xpath="//input[@id='category']")
	WebElement categoryTextArea;
	@FindBy(xpath="//li[@id='134-selectable']//span[text()='discount']")
	WebElement discountElement;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement addAlert;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlert;
	
	
	public void addCategory() throws InterruptedException
	{
		
		newButton.click();
		String CategoryName="Strawberry"+gu.generateCurrentDateAndTime();
		this.CategoryName=CategoryName;
		categoryTextArea.sendKeys(CategoryName);
		discountElement.click();
		gu.clickJavaScriptExecutorByLoop(driver);
		wu.explicitWaitUntilVisible(driver, saveButton);
		saveButton.click();		
	}
	public String getAddAlert()
	{
		return addAlert.getText();
	}
	public void readTableElement(int row,int column)
	{
		String path="//table[@class=table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td["+column+"]";
		WebElement element=driver.findElement(By.xpath(path));	
	}
	public void deleteCategory()
	{
		wu.explicitWaitUntilVisible(driver, deleteButton);
		deleteButton.click();
		driver.switchTo().alert().accept();	
	}
	public String getDeleteAlert()
	{
		return deleteAlert.getText();
	}
}
