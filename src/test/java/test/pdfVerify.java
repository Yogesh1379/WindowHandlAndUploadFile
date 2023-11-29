package test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class pdfVerify {
	

public static  String readPdfContent(String url) throws IOException {
		
		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = Loader.loadPDF(bf);
		
		String content = new PDFTextStripper().getText(doc);
		doc.close();
	
	return content;
}
	@Test
	public void pdfVerifion()
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("-start-maximized");
		co.setImplicitWaitTimeout(Duration.ofSeconds(30));
		ChromeDriver driver = new ChromeDriver(co);
		
		String url ="http://www.pdf995.com/samples/pdf.pdf";
		driver.get(url);
		try {
			String pdfContent = readPdfContent(url);
			Assert.assertTrue(pdfContent.contains("The Pdf995 Suite offers the following features"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
