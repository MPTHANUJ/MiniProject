package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewAccount extends BasePage {

	public NewAccount(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	
	@FindBy(xpath = "//*[@id=\'tblcrtac\']/tbody/tr[3]/td[3]/input")
	WebElement name;
	
	@FindBy(xpath = "//*[@id=\'tblcrtac\']/tbody/tr[7]/td[3]/input[1]")
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\'tblcrtac\']/tbody/tr[7]/td[3]/input[2]")
	WebElement chk_avail;
	
	@FindBy(xpath = "//input[@name='radio_login']")
	List<WebElement> radios;
	
	@FindBy(id = "newpasswd")
	WebElement password;
	
	@FindBy(id = "newpasswd1")
	WebElement repassword;
	
	@FindBy(xpath = "//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input")
	WebElement Alter_email;
	
	@FindBy(xpath = "//*[@id=\'tblcrtac\']/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")
	WebElement clk_alterid;
	
	@FindBy(id = "mobno")
	WebElement mobile_no;
	
	@FindBy(xpath = "//div[@id='country_id']//ul//li")
	List<WebElement> country_codes;
	
	@FindBy(id = "lbl_txt")
	WebElement clk_countrycode;
	
	@FindBy(xpath = "//*[@id=\'tblcrtac\']/tbody/tr[22]/td[3]/select[1]")
	WebElement day;
	
	@FindBy(xpath = "//*[@id=\'tblcrtac\']/tbody/tr[22]/td[3]/select[2]")
	WebElement month;
	
	@FindBy(xpath = "//*[@id=\'tblcrtac\']/tbody/tr[22]/td[3]/select[3]")
	WebElement year;
	
	@FindBy(xpath = "//input[@value='m']")
	WebElement gen_male;
	
	@FindBy(xpath = "//input[@value='f']")
	WebElement gen_female;
	
	@FindBy(id = "country")
	WebElement Country;
	
	@FindBy(xpath = "	//*[@id=\'div_city\']/table/tbody/tr[1]/td[3]/select")
	WebElement City;

	
	
	//Action methods
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void sendName(String uname) {
		name.sendKeys(uname);
	}
	
	public void sendEmail(String uemail) {
		email.sendKeys(uemail);
	}
	
	public List<WebElement> checkAvialability() {
		chk_avail.click();
		return radios;
		
	}
	
	public void sendPassword(String upass) {
		password.sendKeys(upass);
	}
	
	public void retypePassword(String repass) {
		password.sendKeys(repass);
	}
	
	public void sendAlterEmail(String altemail) {
		Alter_email.sendKeys(altemail);
	}
	
	public void alterID() {
		clk_alterid.click();
	}
	
	public void sendMobileNo(String mobno) {
		mobile_no.sendKeys(mobno);
	}
	
	public void clickCountryCode() {
		clk_countrycode.click();
	}
	
	public void selectCountryCode(String code) {
		for(WebElement ele : country_codes) {
			if(ele.getText().equals(code)) {
				ele.click();
			}
		}
	}
	
	public void selectDay(String sday) {
		Select days = new Select(day);
		days.selectByVisibleText(sday);
	}
	
	public void selectMonth(String smonth) {
		Select days = new Select(month);
		days.selectByVisibleText(smonth);
	}
	
	public void selectYear(String syear) {
		Select days = new Select(year);
		days.selectByVisibleText(syear);
	}
	
	public void selectGender(String gen) {
		if(gen.equals("male")) {
			gen_male.click();
		}
		else {
			gen_female.click();
		}
	}
	
	public Select selectCountry(String sCountry) {
		
		Select countries = new Select(Country);
		countries.selectByVisibleText(sCountry);
		return countries;
		
	}
	
	public Select selectCity(String scity) {
		
		Select cities = new Select(City);
		cities.selectByVisibleText(scity);
		return cities;
		
	}
	
	
	
}
