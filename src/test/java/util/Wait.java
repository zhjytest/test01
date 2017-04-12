package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	int tm = 0 ;
	private WebDriver driver ;
	int timeout = 10 ;
	
	
	public Wait(WebDriver driver){
		this.driver = driver ;
	}
	
	public void waitForElementPresent(By locator){
		try{
			new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public void waitForImplicitly(){
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS) ;
	}
	
	public void waitFor(int t){
	    t *= 1000 ;
		try {
			Thread.sleep(t) ;
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
