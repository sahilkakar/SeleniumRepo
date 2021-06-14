package classic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicTable {

	WebDriver driver;

	@BeforeMethod

	public void test() {

		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Workspace\\JMD\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
// driver = new HtmlUnitDriver();
		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/test/web-table-element.php");

	}

	@Test
	public void login() throws IOException {

		List<WebElement> c1 = driver.findElements(By.xpath("//table//tr[1]//td"));

		String a = "//table//tr[";
		int q = 1;
		String b = "]//td[";
		int w = 1;
		String v = "]";

		List<WebElement> ROWS = driver.findElements(By.xpath("//table//tr"));
		int rowssIZE = ROWS.size();

		List<WebElement> column = driver.findElements(By.xpath("//table//tr[1]//td"));
		int columnSIZE = column.size();

		for (q = 1; q < rowssIZE; q++) {

			for (w = 1; w < columnSIZE; w++) {

				String xp = a + q + b + w + v;
				String text = driver.findElement(By.xpath(xp)).getText();
				System.out.println("text is " + text);

			}
		}

	}

	@AfterMethod

	public void end() {

		// driver.close();
	}

}
