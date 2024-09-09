package com.jala.qa.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException {
		prop = new Properties();
		String localPath = System.getProperty("user.dir");
		FileInputStream path = new FileInputStream(
				localPath + "\\src\\main\\java\\com\\jala\\qa\\Environment\\Config.properties");
		prop.load(path);
	}

	public void Initialization() {
		String BrowserName = prop.getProperty("Browser");

		if (BrowserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BrowserName.equals("FireFox")) {
			driver = new FirefoxDriver();
		} else if (BrowserName.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Somthing went wrong.....! plase check your browser name");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//	Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// Explicit wait
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));

		driver.get(prop.getProperty("Url"));
	}

	public void holdtime() throws InterruptedException {
		Thread.sleep(4000);
	}

}
