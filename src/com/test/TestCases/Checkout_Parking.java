/**
 * @author Preet Parikh
 */


package com.test.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import android.R;
import android.widget.TimePicker;

import com.test.QtestConnect.Connect;
 
public class Checkout_Parking {

	public AppiumDriver driver;
	private RemoteWebDriver driver1;

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
//		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
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
			Thread.sleep(5000);
			driver.findElements(By.id("android:id/button1")).get(0).click();
			Thread.sleep(10000);
			driver.scrollTo("Parking");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='Parking']")).click();
			Thread.sleep(5000);
			driver.findElements(By.id("android:id/button1")).get(0).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.myorder.app:id/licence_plate")));
			driver.findElements(By.id("com.myorder.app:id/licence_plate")).get(0).sendKeys("ABCD12");
			Thread.sleep(2000);
			driver.findElements(By.id("com.myorder.app:id/zoneCode")).get(0).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.myorder.app:id/et_parking_zone_code")));
			Thread.sleep(2000);
			driver.findElements(By.id("com.myorder.app:id/et_parking_zone_code")).get(0).sendKeys("8004");
			Thread.sleep(2000);
			driver.findElements(By.id("com.myorder.app:id/txt_startTime")).get(0).click();
						Thread.sleep(2000);
//						driver.findElementByAccessibilityId("hour").sendKeys("12");
						driver.findElements(By.id("android:id/numberpicker_input")).get(0).sendKeys("11");
//						driver.scrollTo("09");
			//			Thread.sleep(2000);
			//			driver.findElements(By.id("android:id/numberpicker_input")).get(1).sendKeys("11");
			
				        
						Thread.sleep(2000);
			driver.findElements(By.id("com.myorder.app:id/txtdone")).get(0).click();
			Thread.sleep(5000);
			driver.findElements(By.id("com.myorder.app:id/btnParking")).get(0).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='iDEAL']")).click();
			Thread.sleep(2000);
			driver.findElements(By.id("com.myorder.app:id/spinner")).get(0).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='Issuer Simulation V3 - ING']")).click();
			Thread.sleep(2000);
			driver.findElements(By.id("com.myorder.app:id/fill_wallet")).get(0).click();
			Thread.sleep(5000);
			//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='Confirm Transaction']")));
			//			driver.findElement(By.xpath("//android.widget.Button[@text='Confirm Transaction']")).click();

			//			WebDriver wdriver = new ChromeDriver();
			//			Thread.sleep(2000);
			//			wdriver.get("https://idealtest.rabobank.nl/ideal/issuerSim.do?trxid=0020000059001008&ideal=prob");
			//			driver.sendKeyEvent(66);
			//			Thread.sleep(2000);
			//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='data']/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[3]/td[1]/input")));
			//			wdriver.findElement(By.xpath(".//*[@id='data']/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[3]/td[1]/input")).click();
			//			driver.switchTo().window("Chrome");

			//			driver.context("WEBVIEW");
			//			Thread.sleep(2000);
			//			driver.findElement(By.xpath(".//*[@id='data']/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[3]/td[1]/input")).click();
			//			Thread.sleep(2000);
			//			driver.context("NATIVE_APP");
			
			
			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
			    System.out.println(contextNames); //prints out something like NATIVE_APP \n WEBVIEW_1
			}
//			driver.context(contextNames.toArray()[1]); // set context to WEBVIEW_1
			
			driver.getContext();
			WebElement div = driver1.findElement(By.xpath(".//*[@id='data']/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[3]/td[1]/input"));
			div.click();

			//			driver.findElements(By.id("com.myorder.app:id/autoComplete")).get(0).sendKeys("Mob Carwash Demo");
			//			driver.tap(1, 710, 1260, 1);
			//			Thread.sleep(2000);
			//		driver.findElement(By.xpath("//android.widget.TextView[@text='Mob Carwash Demo']")).click();
			//		Thread.sleep(5000);
			//		driver.findElement(By.xpath("//android.widget.TextView[@text='Wasprogramma 2']")).click();
			//		Thread.sleep(2000);
			//		driver.findElements(By.id("com.myorder.app:id/btnOrderMeal")).get(0).click();
			//		Thread.sleep(2000);
			//		driver.findElements(By.id("com.myorder.app:id/basket_open")).get(0).click();
			//		Thread.sleep(2000);
			//		driver.findElements(By.id("com.myorder.app:id/btnAddToCart")).get(0).click();
			//		Thread.sleep(2000);
			//		driver.findElements(By.id("com.myorder.app:id/fulFillmentExtraInfo")).get(0).sendKeys("0649226464");
			//		Thread.sleep(2000);
			//		driver.findElement(By.id("com.myorder.app:id/minitix_layout")).click();
			//		driver.findElement(By.id("android:id/button1")).click();
			//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button3")));
			//		driver.findElement(By.id("android:id/button3")).click();
			//		Thread.sleep(2000);
			//		driver.findElement(By.xpath("//android.widget.TextView[@text='Transactions']")).click();
			//		Thread.sleep(2000);
			//		connect.scrollData(driver, 0.0, 700.0, 500.0, 700.0);
			//		Thread.sleep(2000);
			//		driver.findElement(By.xpath("//android.widget.TextView[@text='Home']")).click();
			//		
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
