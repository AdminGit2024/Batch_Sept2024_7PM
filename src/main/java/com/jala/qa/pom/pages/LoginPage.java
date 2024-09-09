package com.jala.qa.pom.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.testbase.TestBase;

public class LoginPage extends TestBase {

//	pom - 1. WebElement- object factory  2.countructor 3. Action Function
	
	@FindBy(id = "UserName")
	WebElement username;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(id = "btnLogin")
	WebElement clickOnSignInBtn;
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterUserName(String uname) {
		username.sendKeys(uname);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLoginBtn() {
		clickOnSignInBtn.click();
	}
	
}

