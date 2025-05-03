package Utilities;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import javax.xml.validation.Validator;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import PageObjects.BasePage;

public class BaseClass {

	public static WebDriver driver;
	
//	public static final Logger logger = LogManager.getLogger(BaseClass.class);
	
	public static WebDriver browserLaunch(String browserName) {
		if (driver == null && browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (driver == null && browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (driver == null && browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		return driver;
	}

	public static void launchURL(String url) {

		driver.get(url);
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void minimizeWindow() {
		driver.manage().window().minimize();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateBackward() {
		driver.navigate().back();
	}

	public static void navigateToPage(String url) {
		driver.navigate().to(url);
	}

	public static String getText(WebElement element) {
		return element.getText();
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static String getUrl() {
		return driver.getCurrentUrl();
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void clearText(WebElement element) {
		element.clear();
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public static boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public static boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	public static void acceptAlert(String action, String value) {
		Alert a = driver.switchTo().alert();
		if(action.equalsIgnoreCase("accept")) {
			a.accept();
		}
		else if(action.equalsIgnoreCase("dismiss")) a.dismiss();
		else if(action.equalsIgnoreCase("sendKeys"))a.sendKeys(value);
	}
	
	public static String getTextFromAlert() {
		Alert a = driver.switchTo().alert();
		return a.getText();
	}
	
	public static void switchToFramebyIdOrName(String id) {
		driver.switchTo().frame(id);
	}
	
	public static void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	public static void switchToFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public static void selectByValue(String value, WebElement element) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	
	public static void selectByText(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public static void selectByValue(int index, WebElement element) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public static void deselectByText(String text, WebElement element) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}
	

	public static void deselectByValue(String value, WebElement element) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}
	
	public static void deselectByIndex(int index, WebElement element) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	
	public static List<WebElement> getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
		return s.getAllSelectedOptions();
	}
	
	public static WebElement getFirstSelectedOptions(WebElement element) {
		Select s = new Select(element);
		return s.getFirstSelectedOption();
	}
	
	public static List<WebElement> getOptions(WebElement element) {
		Select s = new Select(element);
		return s.getOptions();
	}

	public static boolean checkDropdownIsMultiple(WebElement element) {
		Select s = new Select(element);
		return s.isMultiple();
	}
	
	public static void clickByActions(WebElement element) {
		
		Actions act = new Actions(driver);
		act.click(element).build().perform();
	}
	
	public static void rightClickByActions(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}
	
	public static void doubleClickByActions(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	
	public static void moveToElementByActions(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public static void dragAndDrop(WebElement source, WebElement destination) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, destination).build().perform();
	}
	
	public static void scrollToElementByActions(WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).build().perform();
	}
	
	public static void captureScreenshot(WebDriver driver, String testName) throws IOException {
	    if (driver == null) {
	        System.out.println("WebDriver is null — cannot capture screenshot for: " + testName);
	        return;
	    }

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File dest = new File(System.getProperty("user.dir") + "/screenshots/" + testName + ".png");
	    FileUtils.copyFile(src, dest);
	    System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
	}

	
	public static String windowHandle() {
		return driver.getWindowHandle();
	}
	
	public static List<String> windowHandles(){
		Set <String> ids = driver.getWindowHandles();
		 List<String> windowIds = new ArrayList<String>(ids);
		 return windowIds;
	}
	
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	
	
	
	
	
	

}
