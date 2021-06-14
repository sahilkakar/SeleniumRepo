package com.qa.crm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	int retrylogin = 3;

	public boolean retry(ITestResult result) {

		if (counter < retrylogin) {

			counter++;
		}

		return false;
	}



}



























