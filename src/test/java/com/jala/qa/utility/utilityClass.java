package com.jala.qa.utility;

import java.io.IOException;

import com.jala.qa.pom.pages.LoginPage;

public class utilityClass {
	
	
//	************* Login Functinlity *******************
	
	public void LoginFunctionality(String umane, String pass) throws IOException {
		LoginPage login = new LoginPage();
		login.enterUserName(umane);
		login.enterPassword(pass);
		login.clickOnLoginBtn();
	}
	

}
