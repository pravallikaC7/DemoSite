package loginSection;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;

/*
 * Verify the Login Section of Demo Site 
 */
public class Login {
	
	static WebDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium IDE\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * Go to http://www.demo.guru99.com/V4/
		 */
		driver.get("http://www.demo.guru99.com/V4/");
		loginSuccessful();
	}
	
	/*
	 * Enter valid Userid & Password
	 */
	public void loginSuccessful() {
		//Enter valid userID
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr320209");	
		//Enter valid password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("depehAb");
		//Click on Login
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		String expected = "Manger Id" + " : mng" + "r320209";
		String actual = driver.findElement(By.cssSelector(".heading3 > td")).getText();
		Assert.assertEquals(expected, actual);
		//Verify that Login is Successful.
		System.out.println("Login Successful");
		}

	public static void main(String[] args) {
		Login test = new Login();
		test.invokeBrowser();

	}

}