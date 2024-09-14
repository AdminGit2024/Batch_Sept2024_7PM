package com.jala.qa.testpages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.jala.qa.pom.pages.LoginPage;
import com.jala.qa.testbase.TestBase;
import com.jala.qa.utility.utilityClass;

public class LoginTestPage extends TestBase {
	LoginPage login;
	String ExcelLoginData= "C:\\Users\\OM SAI AM\\eclipse-workspace\\Jala_HybridFramwork_Sept2024_Batch_7PM\\src\\main\\java\\com\\jala\\qa\\testData\\LoginData.xlsx";
	public LoginTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
	
	}
	
	@DataProvider
	public Object[][] getLoginData() throws IOException {
		utilityClass util = new utilityClass();
		Object[][] loginData = util.getExcelData("Sheet3", ExcelLoginData);
		
		return loginData;
	}
	
	@Test(dataProvider = "getLoginData")
	public void validatLoginFunctionality(String uname, String pass) throws IOException, InterruptedException {
	 login = new LoginPage();
	 login.enterUserName(uname);
	 login.enterPassword(pass);
	 login.clickOnLoginBtn();
	 holdtime();
	 String actual = driver.getTitle();
	 Assert.assertEquals(actual, "Magnus");
	 Reporter.log("Home title page matched...", true);
	 
	}
		
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
