package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.qa.crm.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstNameTxtBx;

	@FindBy(xpath = "//input[@id='surname']")
	WebElement lastNameTxtBx;

	@FindBy(xpath = "//input[@value='Save and Create Another (same company)']//..//input[@value='Save']")
	WebElement saveBtn;

	public ContactsPage() {

		PageFactory.initElements(driver, this);

	}

	public void createNewContactsEvent() {

		firstNameTxtBx.sendKeys("Narender");

		lastNameTxtBx.sendKeys("Modi");

		saveBtn.click();

	}

}
