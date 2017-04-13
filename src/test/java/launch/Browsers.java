package launch ;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import util.ParseProperties;

public class Browsers {
	public WebDriver driver ;
	private ParseProperties remote_url ;
	public String url ;
	private String projectpath = System.getProperty("user.dir") ;
	
	
	public Browsers(BrowsersType browserstype,int i) throws MalformedURLException{
		remote_url = new ParseProperties(projectpath+"/tools/test.properties") ;
		url = remote_url.getValue("remote_url") ;
		System.out.println(projectpath) ;
		switch(browserstype){
			case firefox:
				System.setProperty("webdriver.gecko.driver", projectpath+"/tools/geckodriver.exe");
				driver = new FirefoxDriver() ;
				break ;
			case ie:
				System.setProperty("webdriver.ie.driver", projectpath+"/tools/IEDriverServer.exe");
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	            caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	            caps.setCapability("ignoreProtectedModeSettings",true);  
				driver = new InternetExplorerDriver(caps);
				break ;
			case chrome:
				System.setProperty("webdriver.chrome.driver", projectpath+"/tools/chromedriver.exe");
				System.out.println(System.getProperty("webdriver.chrome.driver"));
				if(i == 0){
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					driver = new RemoteWebDriver(new URL(url),capabilities) ;
				}
				else{
					driver = new ChromeDriver() ;
				}
				break ;
		}
	}
}
