package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.qa.crm.base.TestBase;

public class CalenderPage extends TestBase {

	@FindBy(id = "title")
	WebElement titleTxtBx;

	@FindBy(xpath = "//select[@name='assigned_to_user_id_src']//option[contains(text(),'group automation')]")
	WebElement AssignedTo;

	@FindBy(xpath = "//input[@value='==ADD==>']")
	WebElement addBtn;
	
	public CalenderPage() {

		PageFactory.initElements(driver, this);

	}

	public void createNewCalenderEvent() {

		
titleTxtBx.sendKeys("Test puropse");
AssignedTo.click();

		

	}

}
