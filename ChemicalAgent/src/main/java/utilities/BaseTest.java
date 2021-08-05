package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pages.BuyPage;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPagee;
import pages.LogoutPage;
import pages.RegisterPage;
import pages.SellPage;
import pages.UpdateProfilePage;

public class BaseTest {

	public static WebDriver driver;
	public static Actions ac;
	public static Properties prop;

	//pages initialization
	public static LoginPagee LoginpageeObject;
	public static RegisterPage RegisterPageObject;
    public static HomePage HomePageObject;
    public static ContactUsPage ContactUsPageObject;
    public static SellPage SellPageObject;
    public static UpdateProfilePage UpdateProfilePageObject;
    public static BuyPage BuyPageObject;
    public static LogoutPage LogoutPageObject;
    
	public static void  inIt() throws Exception 
	{
		String configFilePath="C:\\Users\\user\\eclipse-workspace\\ChemicalAgent\\src\\main\\java\\Configuration.properties";
		prop=new Properties();
		File f=new File(configFilePath);
		FileInputStream fis = new FileInputStream(f);
		prop.load(fis);
	}
	
	public static void browserInitialisation()
	{
		if(prop.getProperty("Browser").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\eclipse-workspace\\Framework\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(prop.getProperty("Browser").equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\Framework\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		ac=new Actions(driver);
		pageinit();

	}

	public static void pageinit() {
		LoginpageeObject=PageFactory.initElements(driver, LoginPagee.class);
		RegisterPageObject=PageFactory.initElements(driver, RegisterPage.class);
		HomePageObject=PageFactory.initElements(driver, HomePage.class);
		ContactUsPageObject=PageFactory.initElements(driver, ContactUsPage.class);
		SellPageObject=PageFactory.initElements(driver, SellPage.class);
		UpdateProfilePageObject=PageFactory.initElements(driver, UpdateProfilePage.class);
		BuyPageObject=PageFactory.initElements(driver, BuyPage.class);
		LogoutPageObject=PageFactory.initElements(driver, LogoutPage.class);
	}

	public static void launchUrl() {
		driver.get(prop.getProperty("URL"));
	}

	public static void sendData(WebElement element,String data) {
		element.sendKeys(data);
	}

	public static void click(WebElement element) {
		element.click();
	}
	
	public static void clear(WebElement element) {
		element.clear();
	}

	public static void moveToElement(WebElement element) {
		ac.moveToElement(element).build().perform();
	}


//Reports Generation 

	public static ExtentHtmlReporter htmlReporter;
	  public static ExtentReports extent;
	  public static ExtentTest test;

	@BeforeSuite
 public void reportInitialization() throws IOException, Exception
 {
     htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/ChemicalAgentTestReport.html");
     extent = new ExtentReports();
     extent.attachReporter(htmlReporter);
      
     htmlReporter.config().setChartVisibilityOnOpen(true);
     htmlReporter.config().setDocumentTitle("Chemical Agent Reports");
     htmlReporter.config().setReportName("Chemical Agent Reports ");
     htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
     htmlReporter.config().setTheme(Theme.STANDARD);
 }
 @AfterMethod
 public void getResult(ITestResult result)
 {
     if(result.getStatus() == ITestResult.FAILURE)
     {
         test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
         test.fail(result.getThrowable());
     }
     else if(result.getStatus() == ITestResult.SUCCESS)
     {
         test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
     }
     else
     {
         test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
         test.skip(result.getThrowable());
     }
 }

 @AfterSuite
 public void reportGenerate()
 { 
	 System.out.println("In report Generate"); 
     extent.flush();
   // driver.quit();   
 }
 public static void passReport(String data)
 {
 	test.log(Status.PASS, data);
 }
 public static void InfoReport(String data)
 {
 	test.log(Status.INFO, data);
 }
	
 public static void FailReport(String data) throws IOException
 {
 	test.log(Status.FAIL, data);
 	
 	   String temp=getScreenshot(driver);
 		test.fail("Screenshot: ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
 	}
	public static String getScreenshot(WebDriver driver)
	{
	TakesScreenshot sc=(TakesScreenshot)driver;
	
	File src=sc.getScreenshotAs(OutputType.FILE);
	
	String path=System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
	
	File des=new File(path);
	try {
		FileUtils.copyFile(src, des);
	}
  catch(Exception e)
	{
 	 System.out.println(e);
	}
	return path;
 }
}


