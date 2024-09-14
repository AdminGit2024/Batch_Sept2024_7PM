package com.jala.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jala.qa.pom.pages.LoginPage;

public class utilityClass {
	
	
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
	
	
}
