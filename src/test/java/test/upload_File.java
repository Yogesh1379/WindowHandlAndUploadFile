package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class upload_File {

	@Test
	public void one() throws InterruptedException, IOException
	{
ChromeOptions co = new ChromeOptions();
co.addArguments("--remote-allow-origins=*");
co.addArguments("-start-maximized");
		WebDriver driver=new ChromeDriver(co);
		
		driver.manage().deleteAllCookies();

		//driver.navigate().to("https://demos.devexpress.com/aspxeditorsdemos/Features/NullText.aspx");
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(4000);
		WebElement up = driver.findElement(By.id("imagesrc"));
		Actions act = new Actions(driver);
		act.doubleClick(up).perform();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\User\\Desktop\\abc.exe");//to exe 
/*		ControlFocus("Open","","Edit1");   for scite script
		ControlSetText("Open","","Edit1","C:\Users\User\Desktop\NTS FORM.png");
		ControlClick("Open","","Button1");
*/

		Thread.sleep(2000);
		
		Runtime.getRuntime().exec("C:\\Users\\User\\Desktop\\abc.exe");
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Yogesh");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Dangade");
		driver.findElement(By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid']")).sendKeys("Shrigonda");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("8888024539");
		driver.findElement(By.name("radiooptions")).click();
		driver.findElement(By.id("submitbtn")).click();
		WebElement c = driver.findElement(By.xpath("//select[@id='countries']"));
		Select se = new Select(c);
		List<WebElement> op = se.getOptions();
		for (int i=0;i<op.size();i++)
		{
			String txt = op.get(i).getText();
			System.out.println(txt);
		}
		
		Thread.sleep(4000);	
		
		driver.quit();
	}

}
