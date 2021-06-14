package com.qa.crm.pages;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(css = "input.btn.btn-small")
	WebElement loginBtn;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public String validateLoginPgeTitle() {

		return driver.getTitle();
	}

	public HomePage login(String un, String Pass) throws InterruptedException {

		username.sendKeys(un);

		password.sendKeys(Pass);

		Thread.sleep(5000);
		loginBtn.click();

		return new HomePage();
	}


	
	public HomePage multipleLoginDataProviders(String un, String Pass) throws InterruptedException
	{
		username.sendKeys(un);

		password.sendKeys(Pass);

		Thread.sleep(5000);
		loginBtn.click();

		return new HomePage();
	}


}
	
	


