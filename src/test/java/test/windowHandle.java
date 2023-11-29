package test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class windowHandle {
	@Test (invocationCount = 4)
	public void wondow() throws InterruptedException
	{
		ChromeOptions co = new ChromeOptions();
		
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("-start-maximized");
		co.setImplicitWaitTimeout(Duration.ofSeconds(30));
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.findElement(By.partialLinkText("click")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> newWindow = driver.getWindowHandles();
		for(String WindowHandle:newWindow)
		{
			if(!WindowHandle.equals(parentWindow))
			{
				driver.switchTo().window(WindowHandle);
			}
			else
			{
				
			}
		}
		String pgTitle = driver.getTitle();
		if(pgTitle.equals("Selenium"))
		{
			System.out.println("Page title of new window is verify "+"Selenium");
		}
		else
		{
			System.out.println("control is not switch");
		}
		
		driver.findElement(By.xpath("//a[contains(@class,'selenium-button selenium-we')]")).click();
		
		String pgTitle1 = driver.getTitle();
		if(pgTitle1.equals("WebDriver | Selenium"))
		{
			System.out.println("Page title of WebDriver is verify "+"WebDriver | Selenium");
		}
		else
		{
			System.out.println("not click");
		}
	/*	WebElement api = driver.findElement(By.partialLinkText("Actions API"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		org.openqa.selenium.Point point = api.getLocation();
		int xAxix = point.getX();
		int yAxix = point.getY();
		
		jse.executeScript("window.scrollBy("+xAxix+","+yAxix+")");
		//*/
		driver.findElement(By.xpath("//a[.='Watch the Videos']")).click();
		String secondWindow = driver.getWindowHandle();
		
		Set<String> allHDl = driver.getWindowHandles();
		
		for(String newWindow2:allHDl)
		{
			if (!newWindow2.equals(secondWindow))
			{
				if(!newWindow2.equals(parentWindow))
				{
				driver.switchTo().window(newWindow2);
				String ss = driver.getTitle();
				System.out.println(ss);
				driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[4]")).click();
				driver.close();
			}
			}
			else
			{
				
			}
		}
Thread.sleep(4000);	
		
		driver.quit();
		
	}

}
