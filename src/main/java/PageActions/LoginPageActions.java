package PageActions;

import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;
import Utilities.BaseClass;

public class LoginPageActions extends BaseClass{
	
	private static  WebDriver driver;
	
	private static LoginPage lp;
	
//	public LoginPageActions(WebDriver driver) {
//		this.driver = driver;
//		lp = new LoginPage(driver);
//	}
	
	private static LoginPageActions loginPageActions;
	
//	private LoginPageActions() {
//		
//	}
	
	public static LoginPageActions getInstance(WebDriver driver) {
		if(loginPageActions == null) {
			LoginPageActions.driver = driver;
			lp = new LoginPage(driver);
			loginPageActions = new LoginPageActions();
		}
		return loginPageActions;
	}
	
	public String  getLoginPageTitle() {
		return getTitle();
	}
	
	public void enterUsername(String value) {
		
		enterText(lp.getUsername(), value);
		
	}
	
	public void enterPassword(String value) {
		enterText(lp.getPassword(), value);
	}
	
	public void  clickLoginBtn() {
		clickOnElement(lp.getLoginBtn());
	}
	

}
