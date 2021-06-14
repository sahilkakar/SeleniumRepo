package com.qa.crm.util;

import java.io.File;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.crm.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static void screenshotWithName(String MethodName, String FileName) {

		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File dest = new File(
					"D:\\Eclipse Workspace\\Test_Maven\\Screenshots\\" + MethodName + "_" + FileName + ".png");

			FileUtils.copyFile(src, dest);

		}

		catch (Exception e) {

			e.printStackTrace();

		}
	}

}
