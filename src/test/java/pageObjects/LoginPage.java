package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(name = "login")
	WebElement username;
	
	@FindBy(name = "passwd")
	WebElement password;
	
	@FindBy(name = "proceed")
	WebElement signin;
	
	@FindBy(xpath = "//u[normalize-space()='Create a new account']")
	WebElement newAccount;
	
	
	//Action methods
	public void sendUsername(String uname) {
		username.sendKeys(uname);
	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void Signin() {
		
		signin.click();
		
	}
	
	public void newAccount() {
		newAccount.click();
	}

}
