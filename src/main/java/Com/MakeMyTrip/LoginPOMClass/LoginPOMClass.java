package Com.MakeMyTrip.LoginPOMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOMClass {
	private WebDriver driver;
	Actions act;
	
	@FindBy (xpath = "//div[contains(@class,'makeFlex spaceBetween column')]") private WebElement createAccount;
	public void clickOnCreateAccount()
	{
		act.click(createAccount).perform();
	}
	
	@FindBy(xpath = "//label[contains(text(),'Login with Phone/Email')]") private WebElement phoneEmail;
	public void clickOnLoginWithPhoneOrEmail()
	{
		act.click(phoneEmail).perform();
	}
	
	public String getTextOfProfile()
	{
		String a = createAccount.getText();
		return a;
	}
	
	@FindBy (xpath = "//input[contains(@id,'username')] ") private WebElement Email;
	public void sendEmail()
	{
		Email.sendKeys("dshinde868@gmail.com");
	}
	

	@FindBy (xpath="//button[@class='capText font16']") private WebElement Continue;
	public void clickOnContinue() throws InterruptedException
	{
		Thread.sleep(7000);
		act.moveToElement(Continue).perform();
		act.click(Continue).perform();
	}
	
	@FindBy (xpath = "//input[contains(@id,'password')] ") private WebElement password;
	public void sendPassword()
	{
		password.sendKeys("Dvlsjs!14");
	}
	
	@FindBy (xpath = "//span[contains(text(),'Login')] ") private WebElement login;
	public void clickOnLogin()
	{
		act.click(login).perform();
	}
	
	public LoginPOMClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		act= new Actions(driver);
	}
}
