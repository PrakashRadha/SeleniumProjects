package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHotel extends BasePage{

	public SearchHotel(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css = ".login_title")
	private WebElement title;
	
	@FindBy(id = "location")
	private WebElement location;

	@FindBy(css = "#hotels")
	private WebElement hotel;
	
	@FindBy(id = "room_type")
	private WebElement roomType;
	
	@FindBy(id = "room_nos")
	private WebElement numberOfRooms;
	
	@FindBy(id = "datepick_in")
	private WebElement checkInDate;
	
	@FindBy(id ="datepick_out")
	private WebElement checkOutDate;
	
	@FindBy(id = "adult_room")
	private WebElement adultsPerRoom;
	
	@FindBy(id = "child_room")
	private WebElement childrenPerRoom;
	
	@FindBy(id = "Submit")
	private WebElement searchBtn;
	
	@FindBy(id = "Reset")
	private WebElement resetBtn;

	public WebElement getTitle() {
		return title;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getNumberOfRooms() {
		return numberOfRooms;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	
	public WebElement getAdultsPerRoom() {
		return adultsPerRoom;
	}

	public WebElement getChildrenPerRoom() {
		return childrenPerRoom;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getResetBtn() {
		return resetBtn;
	}


	
	
	
	
	
	
	
	
}
