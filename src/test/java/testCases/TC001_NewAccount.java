package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.NewAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC001_NewAccount extends BaseClass {
	
	@Test(dataProvider = "na",dataProviderClass = DataProviders.class)
	public void test_NewAccount(String uname,String umail,String upass,String day,String mon,String year,String country) {
		
		
		logger.info("*** Starting TC001_NewAccount ***");
		try {
		
		LoginPage lp = new LoginPage(driver);
		lp.newAccount();
		logger.info("Clicked on Create a New Account");
		
		NewAccount na = new NewAccount(driver);
		
		na.sendName(uname);
		logger.info("Entered data in Full Name");
		
		na.sendEmail(umail);
		logger.info("Entered data in Rediffmail ID");
		
		List<WebElement> Radios = na.checkAvialability();
		for(WebElement ele : Radios) {
			ele.click();
			Assert.assertEquals(ele.isSelected(), true);
			break;
		}
		logger.info("Clicked on available email id");
		
		na.sendPassword(upass);
		logger.info("Entered data in Password");
		
		na.alterID();
		logger.info("Clicked on Alternate ID");
		
		na.selectDay(day);
		na.selectMonth(mon);
		na.selectYear(year);
		logger.info("Selected date");
		int count=0; 
		Select getCountries = na.selectCountry(country);
		logger.info("Selected country");
		System.out.println("List of Countries in DropDown Menu");
		List<WebElement> options = getCountries.getOptions();
		for(WebElement opts : options ) {
			System.out.println(opts.getText());
			count++;
		}
		System.out.println("Total no of countries : "+count);
		logger.info("Total no of Countries in Drop down is displayed");
		logger.info("Validating whether the expected Counrty is selected");
		Assert.assertEquals(getCountries.getFirstSelectedOption().getText(),"India");
		}
		catch(Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("*** Finishing TC001_NewAccount ***");
	}
		
		

}
