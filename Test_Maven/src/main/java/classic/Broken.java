package classic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Broken {

	WebDriver driver;
	String homePage = "https://www.zlti.com";

	HttpURLConnection huc = null;
	int respCode = 200;

	String url = "";

	@BeforeMethod
	public void BeforeMethod() {

		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Workspace\\JMD\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(homePage);

	}

	@Test
	public void test1() {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> ite = links.iterator();

		while (ite.hasNext()) {

			url = ite.next().getAttribute("href");
			System.out.println(url);

			if (url == null || url.isEmpty()) {

				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;

			}

			if (!url.startsWith(homePage)) {

				System.out.println("URL belongs to another domain, skipping it.");
				continue;

			}

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}