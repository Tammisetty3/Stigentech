package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellPage {
	
	@FindBy(xpath="/html/body/app-root/app-home1/div/app-header1/header/div/div/div/app-navigation/div[1]/div/a[2]")
    public static WebElement sell;
	
	@FindBy(xpath="/html/body/app-root/app-add-listing/div/div[1]/div/div/div/div[2]/form/div[1]/div/input")
	public static WebElement Chemicalname;
	
	@FindBy(xpath="/html/body/app-root/app-add-listing/div/div[1]/div/div/div/div[2]/form/div[2]/div/input")
	public static WebElement quantity;
	
	@FindBy(xpath="/html/body/app-root/app-add-listing/div/div[1]/div/div/div/div[2]/form/div[2]/div/mat-form-field/div/div[1]/div/mat-select/div/div[2]")
	public static WebElement select_units;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/div/mat-option[1]/span")
	public static WebElement selectunits_type;
	
	//manifacture date
	@FindBy(xpath="/html/body/app-root/app-add-listing/div/div[1]/div/div/div/div[2]/form/div[3]/div/mat-form-field/div/div[1]/div[2]/mat-datepicker-toggle/button")
	public static WebElement select_calendar;
	//june month 
	@FindBy(xpath="/html/body/div[2]/div[2]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[2]")
	public static WebElement select_month;
	//date
	@FindBy(xpath="/html/body/div[2]/div[2]/div/mat-datepicker-content/mat-calendar/div/mat-month-view/table/tbody/tr[2]/td[4]/div[1]")
	public static WebElement select_date;
	
	//Expiry date
	@FindBy(xpath="/html/body/app-root/app-add-listing/div/div[1]/div/div/div/div[2]/form/div[4]/div/mat-form-field/div/div[1]/div[2]/mat-datepicker-toggle/button")
	public static WebElement select_calendar2;
	//select year arrow
	@FindBy(xpath="/html/body/div[2]/div[2]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[1]/span[1]/div")
	public static WebElement select_arrow;
	//select year 2022
	@FindBy(xpath="/html/body/div[2]/div[2]/div/mat-datepicker-content/mat-calendar/div/mat-multi-year-view/table/tbody/tr[1]/td[2]/div[1]")
	public static WebElement select_year;
	//select month- Aug
	@FindBy(xpath="/html/body/div[2]/div[2]/div/mat-datepicker-content/mat-calendar/div/mat-year-view/table/tbody/tr[3]/td[4]/div[1]")
	public static WebElement select_month2;
	// Select date - 19
	@FindBy(xpath="/html/body/div[2]/div[2]/div/mat-datepicker-content/mat-calendar/div/mat-month-view/table/tbody/tr[4]/td[6]/div[1]")
	public static WebElement select_date2;
	
	
	//AVAILABILITY DATE
    @FindBy(xpath="/html/body/app-root/app-add-listing/div/div[1]/div/div/div/div[2]/form/div[5]/div/mat-form-field/div/div[1]/div[2]/mat-datepicker-toggle/button")
    public static WebElement select_calendar3;
    //select month
    //select date-9
    @FindBy(xpath="/html/body/div[2]/div[2]/div/mat-datepicker-content/mat-calendar/div/mat-month-view/table/tbody/tr[2]/td[6]/div[1]")
    public static WebElement select_date3;
    
    //price
    @FindBy(xpath="/html/body/app-root/app-add-listing/div/div[1]/div/div/div/div[2]/form/div[6]/div[1]/input")
    public static WebElement price;
    
    //created by
    @FindBy(xpath="/html/body/app-root/app-add-listing/div/div[1]/div/div/div/div[2]/form/div[6]/div[2]/div/input")
    public static WebElement createdby;
    
    //select status
    @FindBy(xpath="/html/body/app-root/app-add-listing/div/div[1]/div/div/div/div[2]/form/div[6]/div[3]/div/mat-form-field/div/div[1]/div/mat-select/div/div[2]")
    public static WebElement status_arrow;
    //select status type
    @FindBy(xpath="/html/body/div[2]/div[2]/div/div/div/mat-option[1]/span")
    public static WebElement status_type;
    
    //submit button
    @FindBy(xpath="/html/body/app-root/app-add-listing/div/div[1]/div/div/div/div[2]/form/div[7]/button")
    public static WebElement submit_button;
    
    //verification
    @FindBy(xpath="//*[@id=\"navbarDropdown\"]")
	public static WebElement welcome;
	
	@FindBy(xpath="/html/body/app-root/app-home1/div/app-header1/header/div/div/div/app-navigation/div[1]/div/ul/li/div/a[1]")
	public static WebElement mydashboard;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div[1]/app-profile-dash/div[1]/section/div[1]/div[1]/div/div[2]/input")
	public static WebElement type_chemicalname;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div[1]/app-profile-dash/div[1]/section/div[1]/div[1]/div/div[1]/span")
	public static WebElement search;
	
	//chemical name 
	@FindBy(xpath="/html/body/app-root/app-dashboard/div[1]/app-profile-dash/div[1]/section/div[2]/div[1]/div/div/div/table/tr[2]/td[1]")
	public static WebElement chemical_name1;
	
	//Slide toggle bars
	@FindBy(xpath="/html/body/app-root/app-dashboard/div[1]/app-profile-dash/div[1]/section/div[2]/div[1]/div/div/div/table/tr[2]/td[7]/mat-slide-toggle")
	public static WebElement togglebar_on;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div[1]/app-profile-dash/div[1]/section/div[2]/div[1]/div/div/div/table/tr[2]/td[7]/mat-slide-toggle")
	public static WebElement togglebar_off;
}
