package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[text()= 'Contacts']")
	WebElement contacts;

	@FindBy(xpath = "//a[text()= 'New Contact']")
	WebElement newContact;

	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	public ContactsPage clickOnNewContactsLink() {

		driver.switchTo().frame("mainpanel");

		Actions act = new Actions(driver);

		act.moveToElement(contacts).build().perform();

		newContact.click();

		return new ContactsPage();

	}

}