/**
 * @author Preet Parikh
 */


package com.test.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.QtestConnect.Connect;

public class Checkout_Thuisbegorgd {

	public AndroidDriver driver;

	@BeforeMethod
	public void Setup() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "Application");
		File app = new File(appDir, "MyOrderApp.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Mob Store (SM-N750)");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("app-package", "com.myorder.app");
		capabilities.setCapability("app-activity", ".rootActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4473/wd/hub/"),capabilities);
	}

	@Test
	public void checkoutTest() throws InterruptedException {
		Connect connect = new Connect();
		Date startDate = Calendar.getInstance().getTime();
		Date endDate = null;
		
		try{
		// Scripts Here
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.myorder.app:id/txt_done")));
			driver.findElements(By.id("com.myorder.app:id/txt_done")).get(0).click();
			Thread.sleep(5000);
			connect.scrollData(driver, 0.0, 700.0, 500.0, 700.0);
			Thread.sleep(2000);
			driver.findElements(By.id("com.myorder.app:id/txtUserName")).get(0).click();
			driver.findElements(By.id("com.myorder.app:id/phone_number")).get(0).sendKeys("0649226464");
			driver.findElements(By.id("com.myorder.app:id/pass_field")).get(0).sendKeys("abcdA1");
			driver.findElements(By.id("com.myorder.app:id/login_btn_login")).get(0).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
			Thread.sleep(5000);
			driver.findElement(By.id("android:id/button1")).click();
			Thread.sleep(10000);
			driver.scrollTo("Thuisbezorgd.nl");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='Thuisbezorgd.nl']")).click();
			Thread.sleep(5000);
			driver.findElements(By.id("com.myorder.app:id/autoComplete")).get(0).sendKeys("8888-alpha");
			driver.tap(1, 710, 1260, 1);
			Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='New York Pizza']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Pizza']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='4 Cheese Pizza']")).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/option_name")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/merchantProductTitle")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/btnOrderMeal")).get(0).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.myorder.app:id/basket_open")));
		driver.findElements(By.id("com.myorder.app:id/basket_open")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/btnAddToCart")).get(0).click();
		Thread.sleep(2000);
//		driver.tap(1, 200, 710, 1);
//		driver.sendKeyEvent(67);
//		driver.sendKeyEvent(67);
//		driver.sendKeyEvent(67);
//		driver.findElement(By.xpath("//android.widget.TextView[@text='1083HN']")).sendKeys("8888-alpha");
//		driver.getAppStrings("NL");
		
		driver.tap(1, 100, 1075, 1);
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/txtdone")).get(0).click();
		Thread.sleep(2000);
		driver.scrollTo("Pay with");
//		driver.findElement(By.id("com.myorder.app:id/minitix_layout")).click();
//		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='iDEAL']")).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/spinner")).get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Issuer Simulation V3 - ING']")).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/fill_wallet")).get(0).click();
		Thread.sleep(10000);
		
		driver.tap(1, 50, 318, 1);
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button3")));
		driver.findElement(By.id("android:id/button3")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Transactions']")).click();
		Thread.sleep(2000);
		connect.scrollData(driver, 0.0, 700.0, 500.0, 700.0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Home']")).click();
		
		//End Scripts
		endDate = Calendar.getInstance().getTime();
		connect.processData(startDate, endDate, "pass","662306","Test Case Successful");			// Update Test Run ID here	
			}catch(Exception e){
				e.printStackTrace();
				
				endDate = Calendar.getInstance().getTime();
				connect.processData(startDate, endDate, "fail","662306",e.getMessage());			// Update Test Run ID here
			}
	}
	
		
		@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
