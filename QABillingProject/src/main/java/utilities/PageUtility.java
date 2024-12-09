package utilities;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement selectedElement = object.getFirstSelectedOption();
		selectedElement.click();

	} 
	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void clickJavaScriptExecutorByScroll(WebDriver driver, List<WebElement> elements, int index) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
	}
	
	public void sendValueUsingJavaScriptAndBlur(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + value + "'", element);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].blur()", element);
	}
	public void clickJavaScriptExecutorByLoop(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 5; i++) { // Scrolls down 5 times, for example
		    js.executeScript("window.scrollBy(0, 400)"); // Adjust pixel count as needed
		    Thread.sleep(500); // Pause briefly to allow page loading or AJAX content
		}
	}
	// Perform drag-and-drop action from source to target element
    public void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    // Perform a mouse hover over an element
    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Perform a double-click action on an element
    public void doubleClickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    // Perform a right-click (context click) on an element
    public void rightClickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
    public int random(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}
    public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
    public void checkbox(WebElement element)
    {
    	element.click();
		boolean checkSelected=element.isSelected();
		System.out.println(checkSelected);
    }
    public void radioButton(WebElement element)
    {
    	element.click();
		boolean checkSelected=element.isSelected();
		System.out.println(checkSelected);
    }
    public void enterkeyUsingrobotClass() throws AWTException
    {
    	Robot robot = new Robot();
    	robot.delay(500);
    	robot.keyPress(KeyEvent.VK_ENTER);  // Simulates pressing the Enter key
    	robot.keyRelease(KeyEvent.VK_ENTER); 
    }
    public void selectByIndexUsingfindelements(By dropdownLocator, int index) {
        List<WebElement> options = driver.findElements(dropdownLocator);
        if (index >= 0 && index < options.size()) {
            options.get(index).click();
        } else {
            System.out.println("Invalid index: " + index);
        }
    }
    public void selectOptionFromDropdownUsingFindElements(WebElement element,String visibleText) {
        List<WebElement> options = element.findElements(By.tagName("span"));
        for (WebElement option : options) {
            if (option.getText().equals(visibleText)) {
                option.click();
                break;
            }
        }
    }
}
