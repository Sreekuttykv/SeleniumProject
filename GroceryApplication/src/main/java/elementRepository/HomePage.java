package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	WebElement homePageText;
	@FindBy(xpath="//li//p[text()='Sub Category']")
	WebElement subCategoryButton;
	@FindBy(xpath="//li//p[text()='Manage News']")
	WebElement manageNewsButton;
	@FindBy(xpath="//p[text()='Manage Contact']")
	WebElement manageContact;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement adminUser;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and  @class='nav-link']")
	WebElement manageUser;
	@FindBy(xpath="//nav//ul//li[2]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	WebElement category;
	
	
	public String getHomePageText()
	{
		return homePageText.getText();
	}
	public SubCategory clickOnSubCategoryButton()
	{
		subCategoryButton.click();
		return new SubCategory(driver);
	}
	public ManageNews clickOnManageNews()
	{
		manageNewsButton.click();
		return new ManageNews(driver);
	}
	public ManageContact clickOnManageContact()
	{
		manageContact.click();
		return new ManageContact(driver);
	}
	public AdminUser clickOnAdminUser()
	{
		adminUser.click();
		return new AdminUser(driver);
	}
	public CategoryPage clickOnCategory()
	{
		category.click();
		return new CategoryPage(driver);
				
	}
	
}
