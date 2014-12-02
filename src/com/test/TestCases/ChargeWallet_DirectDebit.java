/**
 * @author Preet Parikh
 */

package com.test.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.test.QtestConnect.Connect;


public class ChargeWallet_DirectDebit{

	private AppiumDriver driver;
//	private AndroidDriver driver2;
	
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
	public void ChargeWall() throws InterruptedException {
		Connect connect = new Connect();
		Date startDate = Calendar.getInstance().getTime();
		Date endDate = null;
		
		try{
		// Scripts Here
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.myorder.app:id/txt_done")));
			driver.findElements(By.id("com.myorder.app:id/txt_done")).get(0).click();
			Thread.sleep(5000);
//			driver.swipe(0, 700, 500, 700, 1);
			driver.findElement(By.id("android:id/home")).click();
//			connect.scrollData(driver, 0.0, 700.0, 500.0, 700.0);
			Thread.sleep(2000);
			driver.findElements(By.id("com.myorder.app:id/txtUserName")).get(0).click();
			driver.findElements(By.id("com.myorder.app:id/phone_number")).get(0).sendKeys("0649226464");
			driver.findElements(By.id("com.myorder.app:id/pass_field")).get(0).sendKeys("abcdA1");
			driver.findElements(By.id("com.myorder.app:id/login_btn_login")).get(0).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
			Thread.sleep(2000);
			driver.findElement(By.id("android:id/button1")).click();
			Thread.sleep(10000);
			driver.findElement(By.id("android:id/home")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.myorder.app:id/txtCashWallet")));
			driver.findElement(By.id("com.myorder.app:id/txtCashWallet")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.myorder.app:id/payment_provider_view")));
			driver.findElements(By.id("com.myorder.app:id/payment_provider_view")).get(3).click();
			Thread.sleep(5000);
			driver.findElements(By.id("com.myorder.app:id/amountView")).get(0).sendKeys("25");
			driver.findElements(By.id("com.myorder.app:id/bankAccountView")).get(0).sendKeys("849986");
			driver.findElement(By.id("com.myorder.app:id/morethan18checkbox")).click();
			driver.findElement(By.id("com.myorder.app:id/okButton")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("com.myorder.app:id/checkbox_agree_ota")).click();
			driver.findElement(By.id("com.myorder.app:id/mandate_btn_accept")).click();
			Thread.sleep(5000);
			driver.findElements(By.id("com.myorder.app:id/confirmation_code")).get(0).sendKeys("MINITIX");
			driver.findElement(By.id("com.myorder.app:id/confirm")).click();
			
			
			Thread.sleep(5000);
			
			
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