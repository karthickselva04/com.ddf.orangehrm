package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basicmethods {

	public static void main(String[] args) throws InterruptedException {
		
		String Expectedtitle=("fb - login or signup");
		String ExpectedUrl=("facebook.com");
		
		System.setProperty("webdriver.chrome.driver", "G://chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.navigate().to("http://www.fb.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title='English (UK)']")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000); 
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		String Actualtitle=driver.getTitle();
		{
			System.out.println("Actual Title="+ Actualtitle);
		}
		String Actualurl=driver.getCurrentUrl();
		{
			System.out.println("Actual URL="+ Actualurl);
		}
		
		if(Expectedtitle.equals(Actualtitle))
		{
			System.out.println("Test case pass");
		}
		else
		{
			System.out.println("Test case fail");
			
		}
		
		if(ExpectedUrl.equals(Actualurl))
		{
			System.out.println("Test case pass");
		}
		else
		{
			System.out.println("Test case fail");
		}
       driver.close();
	}

}
