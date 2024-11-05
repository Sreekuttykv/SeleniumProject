package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class SubCategory {
	WebDriver driver;
	String subCategoryName;
	WaitUtilities wu;
	GeneralUtilities gu=new GeneralUtilities();
	public SubCategory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wu=new WaitUtilities();
	}
	@FindBy(xpath="//a[@class=\'btn btn-rounded btn-danger\']")
	WebElement newSubCategoryButton;
	@FindBy(id="cat_id")
	WebElement subCategoryDropdown;
	@FindBy(xpath="//input[@id='subcategory']")
	WebElement subCategoryText;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	List<WebElement> subCategorytableSize;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchSubCategoryButton;
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	WebElement searchSubCategoryDropdown;
	@FindBy(xpath="//input[@class='form-control']")
	WebElement searchSubCategoryText;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement redSearchButton;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")
	WebElement resultNotFoundMsg;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	WebElement editDropdown;
	@FindBy(xpath="//input[@id='subcategory']")
	WebElement editSubCategoryText;
	@FindBy(xpath="//button[text()='Update']")
	WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlert;
	
	
	public void addNewSubCategory()throws ElementClickInterceptedException 
	{
		
		String subCategoryName="JonaGold"+gu.generateCurrentDateAndTime();
		this.subCategoryName=subCategoryName;
		newSubCategoryButton.click();
		gu.selectDropdownWithVisibleText(subCategoryDropdown, "Apple");
		subCategoryText.sendKeys(subCategoryName);
		String imagefile=System.getProperty("user.dir")+"\\src\\main\\resources\\apple.jpg";
		chooseFile.sendKeys(imagefile);
		try
		{
			saveButton.click();
		}
		catch( ElementClickInterceptedException e)
		{
			System.out.println(e);
		}
		
	}
	public String getsubCategoryname()
	{
		return subCategoryName;
	}
	public String getAlert()
	{
		return alertMessage.getText();
	}
	public String readSubcategoryTableElement(int row,int column)
	{
		String path="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td["+column+"]";
		WebElement element=driver.findElement(By.xpath(path));
		return element.getText();
	}
	public void deleteSubCategory()
	{
		deleteButton.click();
		driver.switchTo().alert().accept();		
	}
	public String getAlertDelete()
	{
		return deleteAlert.getText();
	}
	public void searchSubCategory()
	{
		searchSubCategoryButton.click();
		gu.selectDropdownWithVisibleText(searchSubCategoryDropdown, "Apple");
		String searchItem="JonaGold"+gu.generateCurrentDateAndTime();
		searchSubCategoryText.sendKeys(searchItem);
		redSearchButton.click();
	}
	public String getSearchMsg()
	{
		return resultNotFoundMsg.getText();
		
	}
	public void editSubCategory()
	{	
		editButton.click();
		gu.selectDropdownWithVisibleText(editDropdown, "Apple");
		editSubCategoryText.sendKeys(subCategoryName+"12");
		updateButton.click();
		
	}
	public String getUpdateAlert()
	{
		return updateAlert.getText();
		
	}
	
	
	
	
}
