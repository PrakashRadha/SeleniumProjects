package PageObjects;

import org.openqa.selenium.WebDriver;
import PageObjects.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.BaseClass;

public class LoginPage extends BasePage{

	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className = "login_title")
	private WebElement title;
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='Submit']")
	private WebElement loginBtn;

	public WebElement getTitle1() {
		return title;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public String  getLoginPageTitle() {
		return BaseClass.getTitle();
	}
	
	public void enterUsername(String value) {
		
		BaseClass.enterText(getUsername(), value);
	
	}
	
	public void enterPassword(String value) {
		BaseClass.enterText(getPassword(), value);
	}
	
	public void  clickLoginBtn() {
		BaseClass.clickOnElement(getLoginBtn());
	}
	


	
	

}
