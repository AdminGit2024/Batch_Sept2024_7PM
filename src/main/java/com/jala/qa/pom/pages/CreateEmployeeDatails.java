package com.jala.qa.pom.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jala.qa.testbase.TestBase;

public class CreateEmployeeDatails extends TestBase {
//	pom - 1. WebElement- object factory  2.countructor 3. Action Function
	
	@FindBy(id = "FirstName")
	WebElement fname;
	
	@FindBy(name = "LastName")
	WebElement Lname;
	
	@FindBy(id = "EmailId")
	WebElement email;
	
	@FindBy(id = "MobileNo")
	WebElement mobileNumber;
	
	@FindBy(id = "DOB")
	WebElement DOB;
	
	@FindBy(id = "rdbMale")
	WebElement clickOnMaleBtn;
	
	@FindBy(id = "Address")
	WebElement Adrress;
	
	
	@FindBy(id = "CountryId")
	WebElement CountryId;
	
	@FindBy(id = "CityId")
	WebElement CityId;
	
	@FindBy(id = "chkSkill_3")
	WebElement skills;
	
	@FindBy(xpath = "//*[@id=\"frmEmployee\"]/div[2]/button")
	WebElement saveBtn;
	
	public CreateEmployeeDatails() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstname) {
		fname.sendKeys(firstname);
	}
	
	public void enterLastName(String LastName) {
		Lname.sendKeys(LastName);
	}
	
	public void enterEmail(String email1) {
		email.sendKeys(email1);
	}
	
	public void enterMobileNuber(String MoNumber) {
		mobileNumber.sendKeys(MoNumber);
	}
	
	public void enterDOB(String dob) {
		mobileNumber.sendKeys(dob);
	}
	
	
	public void clickOnMaleBtn() {
		clickOnMaleBtn.click();
	}
	
	
	public void enterAddress(String address) {
		Adrress.sendKeys(address);
	}
	
	
	public void selectCountry() {
		Select select = new Select(CountryId);
		select.selectByValue("1");
	}
	
	public void selectCity() {
		Select select = new Select(CityId);
		select.selectByIndex(7);
	}
	
	
	public void selectSkills() {
		skills.click();
	}
	
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
}
