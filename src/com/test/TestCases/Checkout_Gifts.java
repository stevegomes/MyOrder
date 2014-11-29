/**
 * @author Preet Parikh
 */


package com.test.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.QtestConnect.Connect;

public class Checkout_Gifts {

	public WebDriver driver;

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
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4473/wd/hub/"),capabilities);
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
			driver.findElements(By.id("android:id/button1")).get(0).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='Gifts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Mob Gift Demo']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Nationale Entertainment Card']")).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/addProductImg")).get(0).click();
		driver.findElements(By.id("com.myorder.app:id/option_name")).get(0).click();
		driver.findElements(By.id("com.myorder.app:id/merchantProductTitle")).get(4).click();
		driver.findElement(By.id("com.myorder.app:id/ok")).click();
		Thread.sleep(5000);
		driver.findElements(By.id("com.myorder.app:id/option_name")).get(1).click();
		driver.findElements(By.id("com.myorder.app:id/merchantProductTitle")).get(0).click();
		driver.findElements(By.id("com.myorder.app:id/btnOrderMeal")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/basket_open")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/btnAddToCart")).get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.myorder.app:id/minitix_layout")).click();
		driver.findElement(By.id("android:id/button1")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button3")));
		driver.findElement(By.id("android:id/button3")).click();
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
