package test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class demoPractice {

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void AllFielddemo() throws InterruptedException {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("-start-maximized");
		co.setImplicitWaitTimeout(Duration.ofSeconds(30));
		ChromeDriver driver = new ChromeDriver(co);
		
		driver.get("https://tutorialshut.com/demo-website-for-selenium-automation-practice/");
		//page title verification
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, "Demo website for selenium Automation Practice - Tutorials Hut");
		Reporter.log("Page title is verify and site is open seccessfully",true);
		
	driver.findElement(By.id("fname")).sendKeys("Hello World");
	driver.findElement(By.id("idOfButton")).click();
	WebElement result1 = driver.findElement(By.xpath("//p[@id='result1']"));
	String result1Text = result1.getText();

		assertEquals(result1Text, "You clicked on submit Button ::Yes");
		Reporter.log("Text is enter ",true);
		
		//To handle dropdown
		WebElement dropdown = driver.findElement(By.id("testingDropdown"));
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		for(WebElement txt:options)
		{
			String text = txt.getText();
			System.out.println(text);
		}
		select.selectByVisibleText("Performance Testing");
		
		//to handle alert
		driver.findElement(By.xpath("//button[.='Generate Alert Box']")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		Thread.sleep(4000);
		driver.navigate().refresh();
		
		WebElement but = driver.findElement(By.xpath("//button[.='Enter text in Alert Box']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		org.openqa.selenium.Point point = but.getLocation();
		int xAxix = point.getX();
		int yAxix = point.getY();
		
		jse.executeScript("window.scrollBy("+xAxix+","+yAxix+")");
		Thread.sleep(2000);
	driver.findElement(By.xpath("//button[.='Enter text in Alert Box']")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("hello");
		Thread.sleep(4000);
		alert2.accept();
			driver.findElement(By.id("button1")).click();
		
		String second = driver.getWindowHandle();
		Set<String> whl = driver.getWindowHandles();
		for(String newh:whl)
		{
			if(!newh.equals(second))
			{
				driver.switchTo().window(newh);
			}
		}
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window(second);
	Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@style='background-color:DarkBlue'])[3]")).click();
		
		Set<String> az = driver.getWindowHandles();
		for(String aq:az)
		{
			if(!az.equals(second))
			{
				driver.switchTo().window(aq);
			}
		}
		String actualTitle1 = driver.getTitle();
		assertEquals(actualTitle1, "Tutorials Hut -Free Tutorials and Software Testing material");
		
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(second);
		Thread.sleep(3000);
		driver.findElement(By.id("male")).click();
		driver.findElement(By.id("seleniumtest")).click();
		Actions act = new Actions(driver);
		
		WebElement up = driver.findElement(By.id("uploadfile"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Point abs = up.getLocation();
		int x = abs.getX();
		int y = abs.getY();
		js.executeScript("window.scrollBy("+x+","+y+")");
		act.doubleClick(up).perform(); 
		
	//	driver.quit();
	}

}
