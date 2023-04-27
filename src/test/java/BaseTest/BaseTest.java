package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import MainPageObjects.Header;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public Header header;
	
	
	public WebDriver InitializeBrowser() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}
	
	
	@BeforeMethod
	public void launchApplication() {
		driver = InitializeBrowser();
		header = new Header(driver);
		header.hitUrl();
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//	}

}
