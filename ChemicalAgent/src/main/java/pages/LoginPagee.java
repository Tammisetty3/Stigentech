package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPagee {

	@FindBy(xpath="//a[@class='site-button-link white ng-star-inserted']")
	public static WebElement member;

	@FindBy(xpath="//input[@type='text']")
	public static WebElement username;

	@FindBy(xpath="//input[@type='password']")
	public static WebElement pwd;

	@FindBy(xpath="//button[@class='submit']")
	public static WebElement loginbutton;


	
}

