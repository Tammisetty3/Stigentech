package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage {

	@FindBy(xpath="//a[@class='site-button-link white ng-star-inserted']")
	public static WebElement member; 
	
	@FindBy(xpath="//a[text()=' Register']")
	public static WebElement register;
	
	@FindBy(xpath="/html/body/app-root/app-login2/div/div[1]/div/div/div[1]/div/div[2]/div/form/div[1]/input")
    public static WebElement fname;
	
	@FindBy(xpath="/html/body/app-root/app-login2/div/div[1]/div/div/div[1]/div/div[2]/div/form/div[2]/input")
	public static WebElement lname;
	
	@FindBy(xpath="/html/body/app-root/app-login2/div/div[1]/div/div/div[1]/div/div[2]/div/form/div[3]/input")
	public static WebElement email;
	
	@FindBy(xpath="/html/body/app-root/app-login2/div/div[1]/div/div/div[1]/div/div[2]/div/form/div[4]/input")
	public static WebElement address; 
	
	@FindBy(xpath="/html/body/app-root/app-login2/div/div[1]/div/div/div[1]/div/div[2]/div/form/div[5]/input")
	public static WebElement city;
	
	@FindBy(xpath="/html/body/app-root/app-login2/div/div[1]/div/div/div[1]/div/div[2]/div/form/div[6]/input")
	public static WebElement phnum; 
	
	@FindBy(xpath="/html/body/app-root/app-login2/div/div[1]/div/div/div[1]/div/div[2]/div/form/div[7]/input")
	public static WebElement companyname;
	
	//Enter your account details
	@FindBy(xpath="/html/body/app-root/app-login2/div/div[1]/div/div/div[1]/div/div[2]/div/form/div[8]/input")
	public static WebElement uname;
	
	@FindBy(xpath="/html/body/app-root/app-login2/div/div[1]/div/div/div[1]/div/div[2]/div/form/div[9]/input")
	public static WebElement typepwd;
	
	@FindBy(xpath="/html/body/app-root/app-login2/div/div[1]/div/div/div[1]/div/div[2]/div/form/div[10]/input")
	public static WebElement confirmpwd;
	
	@FindBy(xpath="//*[@id=\"register\"]/form/div[11]/div/input")
	public static WebElement choosefile;
	
	@FindBy(xpath="//label[text()=\"I agree to the \"]")
	public static WebElement checkbox;
	
	@FindBy(xpath="/html/body/app-root/app-login2/div/div[1]/div/div/div[1]/div/div[2]/div/form/div[13]/button")
	public static WebElement submitbutton;
	
	
	
	
	
	
	
	
	
	
	
	}


