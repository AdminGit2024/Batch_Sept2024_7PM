package com.jala.qa.testpages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jala.qa.testbase.TestBase;

public class HomeTestPage extends TestBase{

	public HomeTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
