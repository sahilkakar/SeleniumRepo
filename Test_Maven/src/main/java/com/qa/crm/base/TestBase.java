package com.qa.crm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.qa.crm.util.TestUtil;

public class TestBase {

	protected static WebDriver driver;

	protected static Properties prop;

	protected static Logger log;

	public TestBase() {

		log = Logger.getLogger(TestBase.class);

		PropertyConfigurator.configure("log4j.properties");

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"D:\\Eclipse Workspace\\Test_Maven\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
			prop.load(fis);

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initiliazation() {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Workspace\\JMD\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();


			log.info("sahil");

		}

		driver.manage().window().maximize();
		log.info("Browser maximised");

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("URL loaded");
	}

}
