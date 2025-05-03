package PageActions;

import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;
import PageObjects.SearchHotel;
import Utilities.BaseClass;

public class SearchHotelPageActions extends BaseClass {
	private WebDriver driver;

	private SearchHotel sh;

	public SearchHotelPageActions(WebDriver driver) {
		this.driver = driver;
		sh = new SearchHotel(driver);
	}
	
	public String getPageTitle() {
		return getText(sh.getTitle());
	}
}
