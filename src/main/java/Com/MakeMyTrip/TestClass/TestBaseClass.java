package Com.MakeMyTrip.TestClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Com.MakeMyTrip.LoginPOMClass.LoginPOMClass;

public class TestBaseClass {
	WebDriver driver;

	Logger log = Logger.getLogger("MavenMakeMyTripProject");

//	@Parameters("browserName")
	@BeforeMethod
	public void setUp(/* String browserName*/) throws InterruptedException {
//		if (browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//		} 
//		else if(browserName.equals("firefox"))
//		{
			System.setProperty("webdriver.gecko.driver", "./Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
//		}
//		else
//		{
//			log.info("Show Exception");
//		}

		PropertyConfigurator.configure("log4j.properties");
		log.info("Browser is opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		log.info("Url is opened");
        driver.navigate().refresh();
		LoginPOMClass a = new LoginPOMClass(driver);
	//	a.clickOnCreateAccount();
	//	log.info("click on create account");
		a.clickOnLoginWithPhoneOrEmail();
		a.sendEmail();
		log.info("Email ID entered");
//		Thread.sleep(5000);
		a.clickOnContinue();
		log.info("click on continue");
		a.sendPassword();
		log.info("Password entered");
		a.clickOnLogin();
		log.info("click on login");
		log.info("Homepage open");
		Thread.sleep(10000);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		log.info("Browser window closed");
		log.info("End of program");
	}
}
