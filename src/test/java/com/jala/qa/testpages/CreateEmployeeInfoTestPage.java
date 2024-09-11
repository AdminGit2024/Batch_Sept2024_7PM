package com.jala.qa.testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.pom.pages.CreateEmployeeDatails;
import com.jala.qa.pom.pages.HomePage;
import com.jala.qa.testbase.TestBase;
import com.jala.qa.utility.utilityClass;

public class CreateEmployeeInfoTestPage extends TestBase{
	CreateEmployeeDatails info;
	public CreateEmployeeInfoTestPage() throws IOException {
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
		info = new CreateEmployeeDatails();
	}
	
	@Test
	public void validateEmployeePage() throws InterruptedException {
		info.enterFirstName("abc");
		info.enterLastName("xyz");
		info.enterEmail("abc@gmail.com");
		info.enterMobileNuber("39899894343");
		info.enterDOB("07/08/1997");
		info.clickOnMaleBtn();
		info.enterAddress("pune");
		info.selectCountry();
		info.selectCity();
		info.selectSkills();
		info.clickOnSaveBtn();
		Thread.sleep(3000);
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, "https://magnus.jalatechnologies.com/Employee/Search");
		Reporter.log("Url matched",true);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
