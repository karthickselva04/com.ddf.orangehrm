package DDF;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithExcel
{

	WebDriver driver;

@BeforeTest
public void setUp()
{
	System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@Test(dataProvider = "S1")
public void login(String username, String password)
{
	    driver.findElement(By.id("txtUsername")).sendKeys(username);
	    driver.findElement(By.id("txtPassword")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@type='submit'][@name='Submit']")).click();
	    driver.findElement(By.id("welcome")).click();
	    driver.findElement(By.xpath("//a[text()='Logout']")).click();
}

@AfterTest
public void tearDown()
{
	driver.close();
}

@DataProvider(name="S1")
public Object[][] getData()
{
	Excel_Reader r=new Excel_Reader("G:\\Excel files\\orangehrm.xlsx");  // object for Excel_Reader class 	
	int rows=r.ExcelRowsize("Sheet1");
	int cols=r.Excelcolsize("Sheet1");
	Object[][] obj=new Object[rows][cols];
	for(int i=0; i<rows; i++)
	{
		for(int j=0; j<cols; j++)
		{
			obj[i][j]=r.getData("Sheet1", i, j);
		}
	}
	
	return obj;
}

}
