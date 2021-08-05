package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	
	@FindBy(xpath="//*[@id=\"navbarDropdown\"]")
	public static WebElement welcome;
	
	@FindBy(xpath="//a[text()='Logout']")
	public static WebElement logout;
	
}
