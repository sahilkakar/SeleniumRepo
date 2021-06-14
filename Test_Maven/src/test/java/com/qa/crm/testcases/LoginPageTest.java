package com.qa.crm.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;
import com.qa.crm.util.Dataproviders;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {

		super();

	}

	@BeforeMethod
	public void setUp() {

		initiliazation();

		loginpage = new LoginPage();

	}

	@Test(priority = 1)

	public void validateLoginPgeTitleTest() {

		String title = loginpage.validateLoginPgeTitle();

		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.",
				"Title doesn't match");

	}

	@Test(priority = 2)

	public void loginTest() throws InterruptedException {

		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 3, dataProvider = "data-provider", dataProviderClass = com.qa.crm.util.Dataproviders.class)

	public void multipleLoginDataProvidersTest(String User, String Passw) throws InterruptedException {

		homepage = loginpage.multipleLoginDataProviders(User, Passw);

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		String Methodname = result.getName();

		System.out.println("name is- " + Methodname);

		if (result.isSuccess()) {

			TestUtil.screenshotWithName(Methodname, "screenshot");
		}

		driver.quit();

	}
}
