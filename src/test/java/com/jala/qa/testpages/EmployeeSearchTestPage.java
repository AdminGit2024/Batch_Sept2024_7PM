package com.jala.qa.testpages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.pom.pages.CreateEmployeeDatails;
import com.jala.qa.pom.pages.EmploeeSearchPage;
import com.jala.qa.pom.pages.HomePage;
import com.jala.qa.testbase.TestBase;
import com.jala.qa.utility.utilityClass;

public class EmployeeSearchTestPage extends TestBase {

	EmploeeSearchPage search;
	public EmployeeSearchTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException {
		Initialization();
		utilityClass util = new utilityClass();
		util.LoginFunctionality(prop.getProperty("UserName"), prop.getProperty("Password"));
		HomePage home = new HomePage();
		home.clickOnEmployeTab();
		home.clicOnCreateTab();
		 search = new EmploeeSearchPage();
		search.clickOnSearchTab();
	}
	
	
	@Test
	public void validateSearchPage() {
		search.getTable();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
