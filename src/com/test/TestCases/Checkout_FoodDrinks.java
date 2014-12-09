/**
 * @author Preet Parikh
 */

package com.test.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import com.test.QtestConnect.Connect;


public class Checkout_FoodDrinks{

	private AndroidDriver driver;
	
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
	public void CheckoutFoodDrinks() throws InterruptedException {
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
			driver.swipe( 1, 1000, 250, 1000, 0);
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
			driver.findElement(By.xpath("//android.widget.TextView[@text='Food & drinks']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
		driver.findElements(By.id("android:id/button1")).get(0).click();
		driver.findElements(By.id("com.myorder.app:id/autoComplete")).get(0).sendKeys("Mc");
		
//		driver.sendKeyEvent(66);
		
//		driver.findElement(By.id("com.myorder.app:id/autoComplete")).sendKeys(Keys.ENTER);
//		driver.getKeyboard().pressKey("SEARCH");
		
						
//		HashMap<String, Integer> keycode = new HashMap<String, Integer>();
//		keycode.put("keycode", 84);
//		((JavascriptExecutor)driver).executeScript("mobile:keyevent", keycode);

//		JavascriptExecutor jse = (JavascriptExecutor) driver; jse.executeScript("UIATarget.localTarget().frontMostApp().keyboard().buttons()['Done\'].tap()");
		driver.tap(1, 710, 1260, 1);
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/merchantName")).get(1).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.myorder.app:id/menuTab")));
		driver.findElements(By.id("com.myorder.app:id/menuTab")).get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Luxe belegde broodjes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Broodje gehaktbal (koud)']")).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/btnOrderMeal")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/basket_open")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/txtDeliveryMethod")).get(0).click();
		Thread.sleep(5000);
		driver.findElements(By.id("com.myorder.app:id/txtDelivery")).get(1).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/btnAddToCart")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.myorder.app:id/fulFillmentExtraInfo")).get(0).sendKeys("12");
		Thread.sleep(2000);
		driver.sendKeyEvent(4);
//		driver.findElement(By.id("com.myorder.app:id/minitix_layout")).click();
//		Thread.sleep(5000);
//		driver.scrollTo("iDEAL");
		Thread.sleep(2000);
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
//		driver.getContext();
//		WebElement div = driver.findElement(By.xpath(".//*[@id='data']/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[3]/td[1]/input"));
//		div.click();
		
//		driver.findElement(By.id("android:id/button1")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button3")));
		driver.findElement(By.id("android:id/button3")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Transactions']")).click();
		Thread.sleep(2000);
		driver.swipe( 1, 1000, 250, 1000, 0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Home']")).click();
		
//		 Dimension dimensions = driver.manage().window().getSize();
//	        int screenWidth = dimensions.getWidth();
//	        int screenHeight = dimensions.getHeight();
	        
	    		
		
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
