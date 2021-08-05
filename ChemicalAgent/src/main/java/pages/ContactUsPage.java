package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage {
	
	@FindBy(xpath="//*[@id=\"navbarNavDropdown\"]/ul/li[2]/a")
	public static WebElement contactus;
	
	@FindBy(xpath="//*[@id=\"bg\"]/app-root/app-contact-us/div/div[1]/div/div/div[2]/div[1]/div/div[3]/div[1]/div/div/input")
    public static WebElement yourname;
	
	@FindBy(xpath="/html/body/app-root/app-contact-us/div/div[1]/div/div/div[2]/div[1]/div/div[3]/div[2]/div/div/input")
	public static WebElement youremail;
	
	@FindBy(xpath="/html/body/app-root/app-contact-us/div/div[1]/div/div/div[2]/div[1]/div/div[3]/div[3]/div/div/input")
	public static WebElement phone;
	
	@FindBy(xpath="/html/body/app-root/app-contact-us/div/div[1]/div/div/div[2]/div[1]/div/div[3]/div[4]/div/div/mat-form-field/div/div[1]/div/mat-select/div/div[2]")
    public static WebElement select_issue;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/div/mat-option[1]/span")
	public static WebElement issue_type;
	
	@FindBy(xpath="/html/body/app-root/app-contact-us/div/div[1]/div/div/div[2]/div[1]/div/div[3]/div[5]/div/div/textarea")
    public static WebElement type_msg;
	
	@FindBy(xpath="/html/body/app-root/app-contact-us/div/div[1]/div/div/div[2]/div[1]/div/div[3]/div[6]/button")
	public static WebElement submitnow_button;
	
	//Map
	@FindBy(xpath="/html/body/div/div[1]/div/div[4]/div/div/div/div/a")
	public static WebElement view_largemap;
	
	
	@FindBy(xpath="//*[@id=\"mapDiv\"]/div[1]/div/div[13]/div/div/div/button[1]/img[1]")
	public static WebElement zoonin;
	
	@FindBy(xpath="//*[@id=\"mapDiv\"]/div[1]/div/div[13]/div/div/div/button[2]/img[1]")
	public static WebElement zooout;
	
	


}
