package com.jala.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.jala.qa.pom.pages.LoginPage;
import com.jala.qa.testbase.TestBase;

import net.bytebuddy.utility.RandomString;

public class utilityClass extends TestBase{
	
	
public utilityClass() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	//	************* Login Functinlity *******************
//	@DataProvider(name="exceldata")
	public void LoginFunctionality(String umane, String pass) throws IOException {
		LoginPage login = new LoginPage();
		login.enterUserName(umane);
		login.enterPassword(pass);
		login.clickOnLoginBtn();
	}
	
	
//	********************** Data Provider **************************

//	@DataProvider(name ="exceldata")
	public Object[][] getExcelData(String BookName, String exclePath) throws IOException {
		String path ="C:\\Users\\OM SAI AM\\eclipse-workspace\\Jala_HybridFramwork_Sept2024_Batch_7PM\\src\\main\\java\\com\\jala\\qa\\testData\\employeeDetails.xlsx";
		FileInputStream file = new FileInputStream(exclePath);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheetName = book.getSheet(BookName);
		
		Object data[][]=new Object[sheetName.getLastRowNum()][sheetName.getRow(0).getLastCellNum()];
		for(int i=1;i<sheetName.getLastRowNum();i++) {
		for(int j=0;j<sheetName.getRow(0).getLastCellNum();j++) {
//			System.out.print(" "+sheetName.getRow(i).getCell(j).toString());
			  data[i][j] = sheetName.getRow(i).getCell(j).toString();
		}System.out.println();
	}
		return data;
	}
	
//	***************************** screenShot functionlaity ************************
	
	public void captureScreenShot(String methodName) throws IOException {
		// step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// step2: call getScreenshotAs method to create image file

		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String random = RandomString.make(4);
		File dest = new File("C:\\Users\\OM SAI AM\\eclipse-workspace\\Jala_HybridFramwork_Sept2024_Batch_7PM\\screenshot\\"+methodName+random+".png");

		// step3: copy image file to destination
//		FileUtils.copyFile(src, dest);
		FileHandler.copy(src, dest);

		
	}
	
	
	
//	 ********************* extent screenshot code ****************
	
	
public static String takeScreenshot(String testName) {
		
		File sourceScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationScreenshotFile = new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
		try {
//			FileUtils.copyFile(sourceScreenshotFile, destinationScreenshotFile);
			FileHandler.copy(sourceScreenshotFile, destinationScreenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destinationScreenshotFile.getAbsolutePath();
	
	}
	
//	###################### extent report ######################
	
	public static ExtentReports getExtentReport() {
		
		ExtentReports report = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		report.attachReporter(sparkReporter);
		
		return report;
		
	}
	
}
