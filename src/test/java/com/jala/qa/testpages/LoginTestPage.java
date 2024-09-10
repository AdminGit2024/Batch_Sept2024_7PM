package com.jala.qa.testpages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.pom.pages.LoginPage;
import com.jala.qa.testbase.TestBase;

public class LoginTestPage extends TestBase {
	LoginPage login;
	public LoginTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
	
	}
	
	@Test
	public void validatLoginFunctionality() throws IOException, InterruptedException {
	 login = new LoginPage();
	 login.enterUserName(prop.getProperty("UserName"));
	 login.enterPassword(prop.getProperty("Password"));
	 login.clickOnLoginBtn();
	 holdtime();
	 String actual = driver.getTitle();
	 Assert.assertEquals(actual, "Magnus");
	 Reporter.log("Home title page matched...", true);
	 
	}
		
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
