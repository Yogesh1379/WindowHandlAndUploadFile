package test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class pupPDFVerify {
	
	String uRl="https://2023.mscepuppss.in/PDF/PRESSNOTE_FINAL_ANSWER_KEY_10032023.pdf";
	public static String readpdfContaint(String uRl) throws IOException
	{
		URL pdfURL = new URL(uRl);
		InputStream is = pdfURL.openStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		PDDocument doc = Loader.loadPDF(bis);
		String containt = new PDFTextStripper().getText(doc);
		doc.close();
		return containt;
		
	}
	
	@Test
	public void verify() throws InterruptedException, IOException
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("-start-maximized");
		co.setImplicitWaitTimeout(Duration.ofSeconds(30));
		WebDriver driver=new ChromeDriver(co);
		driver.get("https://2023.mscepuppss.in/startpage.aspx");
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("/html/body/div[3]/section/div/div/div[2]/div/div/div[2]/div/div/div[2]/a[1]")).click();
        Set<String> whl = driver.getWindowHandles();
        
        for(String as:whl)
        {
        	if(!as.equals(parent))
        	{
        		driver.switchTo().window(as);
        	}
        }
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		String ct = readpdfContaint(currentURL);
		Assert.assertTrue(ct.contains("अंतिम उत्तरसूची "));
	}

}
