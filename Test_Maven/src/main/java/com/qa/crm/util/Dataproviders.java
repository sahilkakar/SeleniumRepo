package com.qa.crm.util;

import org.testng.annotations.DataProvider;

import com.qa.crm.base.TestBase;

public class Dataproviders extends TestBase {

	@DataProvider(name = "data-provider")
	public Object[][] dataforMultipleLoginTests() {

		Object[][] loginData = new Object[3][2];

		// 1st row
		loginData[0][0] = "groupautomationn";
		loginData[0][1] = "Test@123456";

		// 2nd row
		loginData[1][0] = "groupautomation";
		loginData[1][1] = "Test@1234";

		// 3rd row
		loginData[2][0] = "groupautomation";
		loginData[2][1] = "Test@12345";

		return loginData;
	}


}
