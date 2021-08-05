package executableTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import pages.BuyPage;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPagee;
import pages.LogoutPage;
import pages.RegisterPage;
import pages.SellPage;
import pages.UpdateProfilePage;
import utilities.BaseTest;
import utilities.ExcelReuse;

public class LoginTest extends BaseTest {

	String FileName="E:\\Selenium\\Chemical Agent\\Chemicalagent.xlsx";
	

	@Test(priority=1)
	public void lanchbrowser() throws Throwable {
  
		test=extent.createTest("Chemical Agent HomePage");
		inIt();
		browserInitialisation();
		launchUrl();
		test.log(Status.INFO,"Chemical Agent Url");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	//Register member 
		@Test(priority=2, dataProvider="Registermydataprovider", enabled=false)
		public void Registerpage(String fname, String lname, String email, String address, String city, String phnum, String companyname, String uname, String typepwd, String confirmpwd) throws Throwable {
			int rc = ExcelReuse.getRowCount(FileName, "Mregister");
			for(int i=1;i<=rc;i++) {
	
				click(RegisterPage.member);
				Thread.sleep(3000);
				click(RegisterPage.register);
				Thread.sleep(1000);
				sendData(RegisterPage.fname,fname);
				Thread.sleep(1000);
				sendData(RegisterPage.lname,lname);
				Thread.sleep(1000);
				sendData(RegisterPage.email,email);
				Thread.sleep(1000);
				sendData(RegisterPage.address,address);
				Thread.sleep(1000);
				sendData(RegisterPage.city,city);
				Thread.sleep(1000);
				sendData(RegisterPage.phnum,phnum);
				Thread.sleep(1000);
				sendData(RegisterPage.companyname,companyname);
				Thread.sleep(1000);
				sendData(RegisterPage.uname,uname);
				Thread.sleep(1000);
				sendData(RegisterPage.typepwd,typepwd);
				Thread.sleep(1000);
				sendData(RegisterPage.confirmpwd,confirmpwd);
				Thread.sleep(1000);
				click(RegisterPage.checkbox);
				Thread.sleep(1000);
				click(RegisterPage.submitbutton);
			}
		}
		@DataProvider
		public Object[][] Registermydataprovider() throws Throwable
		{
			return ExcelReuse.getData(FileName, "Mregister");
	
		}

	// Member Login
	@Test(priority=5, dataProvider="mydataprovider")
	public void login(String uname, String psd) throws Throwable {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int rc = ExcelReuse.getRowCount(FileName, "Mlogin");
		for(int i=1;i<=rc;i++) {
			
			test=extent.createTest("Chemical Agent Member Longin");
			
			Thread.sleep(3000);
			click(LoginPagee.member);
			test.log(Status.INFO,"Clicked on Memberlogin");
			Thread.sleep(2000);
			//Assert class &  softAssert class (verify)
			String logintitle=driver.getTitle();
			//Assert.assertEquals(logintitle,"ChemicalAge");
			SoftAssert st=new SoftAssert();
			st.assertEquals(logintitle, "ChemicalAgent");
			sendData(LoginPagee.username,uname);
			test.log(Status.INFO,"Entered username");
			Thread.sleep(2000);
			sendData(LoginPagee.pwd,psd);
			test.log(Status.INFO,"Entered password");
			Thread.sleep(2000);
			click(LoginPagee.loginbutton);
			
			test.log(Status.INFO,"Clicked on Login button");
			Thread.sleep(4000);
			st.assertAll();
		}
	}

	@DataProvider
	public Object[][] mydataprovider() throws Throwable
	{
		return ExcelReuse.getData(FileName, "Mlogin");

	}

	//Search chemical in Home 
	@Test(priority=3, dataProvider="SearchChemicalmydataprovider", enabled=false)
	public void SearchChemical(String chemicalnames) throws Throwable {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int rc = ExcelReuse.getRowCount(FileName, "SearchChemical");
		for(int i=1;i<=rc;i++) {
			
			test=extent.createTest("Chemical Agent Search Chemicals In HomePage");
			
			Thread.sleep(4000);
			click(HomePage.home);
			test.log(Status.INFO,"Clicked on 'Home'");
			Thread.sleep(2000);		
			click(HomePage.search_chemical);
			Thread.sleep(2000);
			sendData(HomePage.search_chemical,chemicalnames);
			test.log(Status.INFO,"Entered Chemical Name");
			Thread.sleep(2000);
			click(HomePage.search_button);
			test.log(Status.INFO,"Clicked on Search button");
			Thread.sleep(4000);
			
			//Verify the chemical names in table
			WebElement cname = driver.findElement(By.xpath("//*[@id=\"bg\"]/app-root/app-chemicalagent/div/table/tr[2]/td[1]"));
			String chemicalname = cname.getText();
			Assert.assertEquals(chemicalname, chemicalnames);
			Thread.sleep(2000);	
		}
	}
	@DataProvider
	public Object[][] SearchChemicalmydataprovider() throws Throwable
	{
		return ExcelReuse.getData(FileName, "SearchChemical");
	}

	//Contact Us
	@Test(priority=4, dataProvider="contactusmydataprovider", enabled=false)
	public void Contactus(String yourname, String youremai, String phone, String typemsg) throws Throwable {
		int rc = ExcelReuse.getRowCount(FileName, "Contactus");
		for(int i=1;i<=rc;i++) {

			test=extent.createTest("Chemical Agent ContactUs");
			
			Thread.sleep(6000);
			click(ContactUsPage.contactus);
			test.log(Status.INFO,"Clicked on Contactus");
			Thread.sleep(2000);
			WebElement element=driver.findElement(By.xpath("//*[@id=\"bg\"]/app-root/app-contact-us/div/div[1]/div/div/div[2]/div[1]/div/div[3]/div[1]/div/div/input"));	
			Point loc=element.getLocation();

			RemoteWebDriver rwd=(RemoteWebDriver)driver;
			rwd.executeScript("window.scrollBy"+loc);
			Thread.sleep(4000);
			sendData(ContactUsPage.yourname,yourname);
			test.log(Status.INFO,"Entered Yourname");
			Thread.sleep(3000);
			sendData(ContactUsPage.youremail,youremai);
			test.log(Status.INFO,"Entered YourEmail");
			Thread.sleep(3000);
			sendData(ContactUsPage.phone,phone);
			test.log(Status.INFO,"Entered YourPhoneNumber");
			Thread.sleep(3000);
			click(ContactUsPage.select_issue);
			Thread.sleep(4000);
			click(ContactUsPage.issue_type);
			test.log(Status.INFO,"Selected Issue Type");
			Thread.sleep(3000);
			sendData(ContactUsPage.type_msg,typemsg);
			test.log(Status.INFO,"Entered issue msg");
			Thread.sleep(2000);
			click(ContactUsPage.submitnow_button);
			test.log(Status.INFO,"Clicked on Submitnow button");
			Thread.sleep(5000);
		}
	}
	@DataProvider
	public Object[][] contactusmydataprovider() throws Throwable
	{
		return ExcelReuse.getData(FileName, "Contactus");
	}

	//Sell
	@Test(priority=6, dataProvider="Addchemicalmydataprovider", enabled=false)
	public void AddChemicals(String chemicalname, String quantity, String price, String createdby) throws Throwable {
		click(SellPage.sell);
		test.log(Status.INFO,"Clicked On Sell");
		int rc = ExcelReuse.getRowCount(FileName, "Addchemical");
		
		for(int i=1;i<=rc;i++) {
			test=extent.createTest("Chemical Agent Sell");
			Thread.sleep(3000);
			sendData(SellPage.Chemicalname,chemicalname);
			test.log(Status.INFO,"Entered Chemical Name");
			Thread.sleep(3000);
			sendData(SellPage.quantity,quantity);
			test.log(Status.INFO,"Selected Quantity");
			Thread.sleep(3000);
			click(SellPage.select_units);
			Thread.sleep(3000);
			click(SellPage.selectunits_type);
			test.log(Status.INFO,"Selected Units Type");
			Thread.sleep(3000);
			//MANUFACTURE DATE
			click(SellPage.select_calendar);
			test.log(Status.INFO,"Selected Manufactured Calendar");
			Thread.sleep(3000);
			click(SellPage.select_month);
			test.log(Status.INFO,"Selected Manufactured Month");
			Thread.sleep(3000);
			click(SellPage.select_date);
			test.log(Status.INFO,"Selected Manufactured Date");
			Thread.sleep(3000);
			//EXPIRY DATE
			click(SellPage.select_calendar2);
			test.log(Status.INFO,"Selected Expiry Date Calendar");
			Thread.sleep(3000);
			click(SellPage.select_arrow);
			Thread.sleep(3000);
			click(SellPage.select_year);
			test.log(Status.INFO,"Selected Expiry Year");
			Thread.sleep(3000);
			click(SellPage.select_month2);
			test.log(Status.INFO,"Selected Expiry Month");
			Thread.sleep(3000);
			click(SellPage.select_date2);
			test.log(Status.INFO,"Selected Expiry Date");
			Thread.sleep(3000);

			//AVAILABILITY DATE
			click(SellPage.select_calendar3);
			test.log(Status.INFO,"Selected Availability Date Calendar");
			Thread.sleep(3000);
			click(SellPage.select_date3);
			test.log(Status.INFO,"Selected Availability Date");
			Thread.sleep(3000);
			//PRICE
			sendData(SellPage.price,price);
			test.log(Status.INFO,"Entered Price");
			Thread.sleep(3000);
			//CreatedBy
			sendData(SellPage.createdby,createdby);
			test.log(Status.INFO,"Entered CreatedBy Name");
			Thread.sleep(3000);
			//Status
			click(SellPage.status_arrow);
			Thread.sleep(3000);
			click(SellPage.status_type);
			test.log(Status.INFO,"Selected Status Type");
			Thread.sleep(3000);
			//submit button
			click(SellPage.submit_button);
			test.log(Status.INFO,"Clicked on Submit button");
			Thread.sleep(2000);
			
			
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-1300)");
			Thread.sleep(2000);
		}
	}
	@DataProvider
	public Object[][] Addchemicalmydataprovider() throws Throwable
	{
		return ExcelReuse.getData(FileName, "Addchemical");
	}

	//Verification chemicals in Mydashboard
	@Test(priority=7,  dataProvider="chemicalnamesmydataprovider", enabled=false)
	public void VerifictionChemicals(String chemicalnames) throws Throwable {
		test=extent.createTest("Verification chemical names in Mydashboard");
		
		click(SellPage.welcome);
		Thread.sleep(4000);
		click(SellPage.mydashboard);
		Thread.sleep(3000);
		int rc = ExcelReuse.getRowCount(FileName, "Chemicalnames");
		for(int i=1;i<=rc;i++) {
		sendData(SellPage.type_chemicalname,chemicalnames);
		Thread.sleep(2000);
		click(SellPage.search);
		Thread.sleep(2000);
		WebElement cname = driver.findElement(By.xpath("//*[@id=\"bg\"]/app-root/app-dashboard/div[1]/app-profile-dash/div[1]/section/div[2]/div[1]/div/div/div/table/tr[2]/td[1]"));
		String chemicalname = cname.getText();
		Assert.assertEquals(chemicalname,chemicalnames);
		clear(SellPage.type_chemicalname);
		Thread.sleep(3000);
		}
	}
		@DataProvider
		public Object[][] chemicalnamesmydataprovider() throws Throwable
		{
			return ExcelReuse.getData(FileName, "Chemicalnames");
		}
	   

	//Update Profile
	@Test(priority=8, dataProvider="Updateprofilemydataprovider", enabled=false)

	public void UpdateProfile(String fullname, String phonenum) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int rc = ExcelReuse.getRowCount(FileName, "Updateprofile");
		for(int i=1;i<=rc;i++) {
			test=extent.createTest("Chemical Agent Update Profile");

			//Thread.sleep(6000);
			click(UpdateProfilePage.welcome);
			test.log(Status.INFO,"Clicked on Welcome");
			//Thread.sleep(3000);
			click(UpdateProfilePage.mydashboard);
			test.log(Status.INFO,"Selected on Mydashboard");
			//Thread.sleep(3000);
			click(UpdateProfilePage.editicon);
			test.log(Status.INFO,"Clicked on Editicon");
			//Thread.sleep(3000);
			sendData(UpdateProfilePage.fullname,fullname);
			test.log(Status.INFO,"Entered Fullname");
			//Thread.sleep(3000);
			//		click(UpdateProfilePage.choosefile);
			//		Thread.sleep(3000);
			//		//it will run the 'exe' files
			//		Runtime.getRuntime().exec("E:\\Selenium\\Chemical Agent\\ChemicalagentFile.exe");
			//		Thread.sleep(3000);
			sendData(UpdateProfilePage.phonenum,phonenum);
			test.log(Status.INFO,"Entered Phonenumber");
			//Thread.sleep(3000);
			click(UpdateProfilePage.update_button);
			test.log(Status.INFO,"Clicked on Update button");
			//Thread.sleep(6000);
		}
	}
	@DataProvider
	public Object[][] Updateprofilemydataprovider() throws Throwable
	{
		return ExcelReuse.getData(FileName, "Updateprofile");
	}

	//"Next" and "Previous" ButtonsFunctionality
	@Test(priority=9, enabled=false)
	public void ButtonsFunctionality() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test=extent.createTest("Chemical Agent Next And Previous Buttons Functionality");
		
		//Thread.sleep(4000);
		click(BuyPage.buy);
		test.log(Status.INFO,"Clicked on Buy");
		//Thread.sleep(3000);
		WebElement element=driver.findElement(By.xpath("//a[text()=' Next ']"));	
		Point loc=element.getLocation();

		RemoteWebDriver rwd=(RemoteWebDriver)driver;
		rwd.executeScript("window.scrollBy"+loc);
		//Thread.sleep(3000);
		click(BuyPage.next_button);
		test.log(Status.INFO,"Clicked on Next button");
		//Thread.sleep(3000);
		click(BuyPage.previous_button);
		test.log(Status.INFO,"Clicked on Previous button");
		//Thread.sleep(6000);
	}

	//Maps 
		@Test(priority=10, enabled=false)
		public void Map() throws Throwable {
			
			click(ContactUsPage.contactus);
			Thread.sleep(2000);
			WebElement element=driver.findElement(By.xpath("/html/body/app-root/app-contact-us/div/div[1]/div/div/div[2]/div[1]/div/div[1]/h2"));	
			Point loc=element.getLocation();
			
			RemoteWebDriver rwd=(RemoteWebDriver)driver;
		     rwd.executeScript("window.scrollBy"+loc);
		     Thread.sleep(2000);
		     click(ContactUsPage.view_largemap);
		     Thread.sleep(3000);
		     click(ContactUsPage.zoonin);
		     Thread.sleep(2000);
		     click(ContactUsPage.zooout);
		     Thread.sleep(2000);
		}

//	//Slide toggle bars
	@Test(priority=11, enabled=false)
	public void SlidetogglebarsFunctionality() throws Throwable {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test=extent.createTest("Chemical Agent Slide toggle bar Functionality");
		
		Thread.sleep(6000);
		click(SellPage.welcome);
		test.log(Status.INFO,"Clicked on Welcome");
		Thread.sleep(4000);
		click(SellPage.mydashboard);
		test.log(Status.INFO,"Selected on Mydashboard");
		Thread.sleep(5000);
		click(SellPage.togglebar_off);
		test.log(Status.INFO,"Slide toggle bar 'Off' functionality");
		Thread.sleep(3000);
		click(SellPage.togglebar_on);
		test.log(Status.INFO,"Slide toggle bar 'On' functionality");
		Thread.sleep(6000); 
	}

	//Logout 
	@Test(priority=12, enabled=false)
	public void Logout() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		test=extent.createTest("Chemical Agent Logout");
		
		//Thread.sleep(6000);
		click(LogoutPage.welcome);
		test.log(Status.INFO,"Clicked on Welcome");
		//Thread.sleep(4000);
		click(LogoutPage.logout);
		test.log(Status.INFO,"Selected Logout");
		//Thread.sleep(4000);
	}
}
