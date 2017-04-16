package launch;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Wait;

public class TestBrowsers {
	public static WebDriver driver ;
	private String username = "" ;
	private String password = "" ;
	private Wait wait ;
 	
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.103:5555/wd/hub"),capabilities) ;
		Browsers browser = new Browsers(BrowsersType.chrome,1);
		driver = browser.driver ;
		System.out.println("before driver:"+driver);
		username = "19520001000" ;
		password = "aaa123" ;
		wait = new Wait(driver) ;
		System.out.println("after driver:"+wait);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	
	
	@Test
	public void login() throws InterruptedException{
		driver.get("http://www.squcorp.com");
		wait.waitForElementPresent(By.id("phoNum")) ;
		driver.findElement(By.id("phoNum")).clear();
		driver.findElement(By.id("phoNum")).sendKeys(username);
		driver.findElement(By.id("psw")).clear();
		driver.findElement(By.id("psw")).sendKeys(password);
		driver.findElement(By.id("LoginIn")).click();
		wait.waitFor(2);
	}
	

}
