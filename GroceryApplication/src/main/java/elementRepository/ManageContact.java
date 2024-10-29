package elementRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageContact {
	WebDriver driver;
	String contactName;
	HomePage hp;
	WaitUtilities wu;
	GeneralUtilities gu=new GeneralUtilities();
	public ManageContact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wu=new WaitUtilities();
	}
	
	@FindBy(xpath="//i[@class='fas fa-edit']")
	WebElement editButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlert;
	@FindBy(xpath="//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath="//textarea[@name='address']")
	WebElement addressTextArea;
	@FindBy(xpath="//textarea[@name='del_time']")
	WebElement deliveryTime;
	
	public void editContact()
	{
		wu.explicitWaitUntilClickable(driver, editButton);
		editButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		addressTextArea.clear();
		addressTextArea.sendKeys("Thrissur");
		deliveryTime.clear();
		deliveryTime.sendKeys("20 minutes");
		updateButton.click();
		
	}
	public String getUpdateAlert()
	{
		return updateAlert.getText();
	}
	
}
