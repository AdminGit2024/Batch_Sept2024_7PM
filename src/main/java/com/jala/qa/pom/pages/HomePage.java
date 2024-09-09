package com.jala.qa.pom.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.testbase.TestBase;

public class HomePage extends TestBase {
//	pom - 1. WebElement- object factory  2.countructor 3. Action Function
	
	@FindBy(linkText = "Employee")
	WebElement clickOnEployeeTab;
	
	@FindBy(linkText = "Create")
	WebElement clickOnCreateTab;
	
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnEmployeTab() {
		clickOnEployeeTab.click();
	}
	public void clicOnCreateTab() {
		clickOnCreateTab.click();
	}
	
}


