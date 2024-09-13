package com.jala.qa.pom.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.testbase.TestBase;

public class EmploeeSearchPage extends TestBase {
//	pom - 1. WebElement- object factory  2.countructor 3. Action Function
	
	
	@FindBy(linkText = "Search")
	WebElement searchtab;
	
	@FindBy(id = "tblEmployee")
	WebElement table;
	
	@FindBy(id = "MobileNo")
	WebElement mobilenum;
	
	@FindBy(id = "btnSearch")
	WebElement searchBtn;
	
	public EmploeeSearchPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnSearchTab() {
		searchtab.click();
	}
	
	public void getTable() {
		List<WebElement> data = table.findElements(By.tagName("tr"));
		System.out.println(data.size());
		for(int i=0;i<data.size();i++) {
			 System.out.println( data.get(i).getText());
		}
		
	}
	
	public void getSingleData() throws InterruptedException {
		
		mobilenum.sendKeys("7204330225");
		searchBtn.click();
		Thread.sleep(3000);
		List<WebElement> data = table.findElements(By.tagName("tr"));
		System.out.println(data.size());
		for(int i=0;i<data.size();i++) {
			 System.out.println( data.get(i).getText());
			 String actual = data.get(i).getText();
			 String expected ="shridhar@gmail.com";
			 if(actual.contains(expected)) {
				 System.out.println("data matched");
			 }
			 else {
				 System.out.println("data not matched");
			 }
		}
	}
	
}
