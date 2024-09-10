package com.jala.qa.testpages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.pom.pages.HomePage;
import com.jala.qa.testbase.TestBase;
import com.jala.qa.utility.utilityClass;

public class HomeTestPage extends TestBase {
	HomePage home;
	utilityClass util;

	public HomeTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException {
		Initialization();

		home = new HomePage();
		util = new utilityClass();
		util.LoginFunctionality(prop.getProperty("UserName"), prop.getProperty("Password"));
	}

	@Test
	public void clickOncreateTab() {
		home.clickOnEmployeTab();
		home.clicOnCreateTab();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
