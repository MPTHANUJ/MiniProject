package testBase;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) {
		
		rb = ResourceBundle.getBundle("config");
		logger = LogManager.getLogger(this.getClass());
		
		if(br.equals("chrome")) {
		driver = new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	

}
