package mavenbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Openchrome {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.rediff.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifygetTitle()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "Facebook");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
