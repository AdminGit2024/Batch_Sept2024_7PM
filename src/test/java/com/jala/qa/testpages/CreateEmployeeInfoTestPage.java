package com.jala.qa.testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	
//	@DataProvider
//	public Object[][] getData() {
//		Object data[][] = {{"hello","hi","565657"},
//							{"hi","hello","565657"},
//								{"hi","hello","565657"}};
//			
//		return data;
//		}
	
//	@DataProvider
//	public Object[][] getdata() throws IOException {
//		utilityClass util = new utilityClass();
//		info = new CreateEmployeeDatails();
//		Object[][] fetchData = util.getExcelData();
//		
//		return fetchData;
//	}
	
	
	@Test(dataProvider = "exceldata", dataProviderClass = utilityClass.class)
	public void validateEmployeePage(String uname, String Lname,String email, String number,String dob, String address) throws InterruptedException {
		info.enterFirstName(uname);
		info.enterLastName(Lname);
		info.enterEmail(email);
		info.enterMobileNuber(number);
		info.enterDOB(dob);
		info.clickOnMaleBtn();
		info.enterAddress(address);
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
