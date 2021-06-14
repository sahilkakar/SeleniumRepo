package classic;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Launch {

	WebDriver driver;

	@BeforeMethod

	public void test() {

		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Workspace\\JMD\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
// driver = new HtmlUnitDriver();
		driver.manage().window().maximize();

		driver.get("http://booking.com/");

	}

	/*
	 * public void screenshot(String FileName) throws IOException {
	 * 
	 * 
	 * 
	 * File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * File DestFile = new File("D:\\" + FileName + ".png"); FileUtils.copyFile(src,
	 * DestFile); }
	 */

	@Test
	public void login() throws IOException {

		WebDriverWait wat = new WebDriverWait(driver, 9);
		WebElement wat1 = wat
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='xp__dates-inner']")));

		driver.findElement(By.xpath("//div[@class='xp__dates-inner']")).click();

		String a = "//table[@class='bui-calendar__dates']//tbody//tr[";
		int b = 1;
		String c = "]//td[";
		int d = 7;
		String e = "]";

		for (b = 1; b <= 6; b++) {

			for (d = 1; d <= 7; d++) {

				String xpat = a + b + c + d + e;

				String c23 = driver.findElement(By.xpath(xpat)).getText();

				/*if (c23.isEmpty()) {
					break;

				}*/

				System.out.println("All elements are " + c23);
			
			
			
				
				if(c23.equalsIgnoreCase("20")          ){
					driver.findElement(By.xpath(xpat)).click();
					break;	
			
			
			}
		}

		}}
}
