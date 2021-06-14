package com.qa.crm.testcases;

import java.io.File;

import org.eclipse.jetty.io.ClientConnectionFactory.Helper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.crm.base.TestBase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;

	public ExtentReports report;
	public ExtentTest logger;

	String methodName;

	public ContactsPageTest() {

		super();

	}

	@BeforeSuite

	public void setUpSuite() {

		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/ExtentReport.html"));

		report = new ExtentReports();
		report.attachReporter(extent);

	}

	@BeforeTest

	public void setUp() throws InterruptedException {

		initiliazation();

		loginpage = new LoginPage();
		homepage = new HomePage();
		contactspage = new ContactsPage();

		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void clickOnNewContactsLinkTest() {

		homepage.clickOnNewContactsLink();

		log.info("contactts link clicked");

	}

	@Test(dependsOnMethods = { "clickOnNewContactsLinkTest" })
	public void createNewContactTest() {

		logger = report.createTest(methodName);

		logger.info("printing methodssssssssssssssssssssssssss");

		contactspage.createNewContactsEvent();

		logger.pass("contact created successfully");

		Assert.assertEquals(driver.getTitle(), "CRMPRO", "Title of the current page doesn't match");
		logger.info("Title is matching");

	}

	@AfterMethod

	public void tearDown(ITestResult result) {

		methodName = result.getName();

		if (result.isSuccess()) {

			TestUtil.screenshotWithName(methodName, "Screenshot");
			log.info("screenshot taken and saved");

		}

		report.flush();

	}

	@AfterTest

	public void closeBrowser() {

		driver.quit();

	}

}
