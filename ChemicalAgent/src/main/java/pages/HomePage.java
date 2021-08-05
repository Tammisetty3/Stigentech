package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath="//a[text()='Home']")
	public static WebElement home;
	
	@FindBy(xpath="/html/body/app-root/app-home1/div/div/app-search-form1/div/div/div/div[2]/div/div[1]/form/div/div[1]/form/mat-form-field/div/div[1]/div/input")
	public static WebElement search_chemical;
	
	@FindBy(xpath="/html/body/app-root/app-home1/div/div/app-search-form1/div/div/div/div[2]/div/div[1]/form/div/div[2]/button")
	public static WebElement search_button;
}
