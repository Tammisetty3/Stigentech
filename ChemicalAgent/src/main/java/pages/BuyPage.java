package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyPage {
	
	@FindBy(xpath="//a[text()='Buy']")
	public static WebElement buy;
	
	@FindBy(xpath="//a[text()=' Next ']")
	public static WebElement next_button;
	
	@FindBy(xpath="//a[text()=' Previous ']")
	public static WebElement previous_button;
	
	
	

}
