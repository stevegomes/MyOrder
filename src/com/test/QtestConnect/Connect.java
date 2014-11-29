package com.test.QtestConnect;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.google.gson.Gson;


public class Connect {
	
	public static boolean autoTestLogs(String projectId,String testRunId,Qtest qTest){
		// Logic goes here 
		HttpClient httpClient = new DefaultHttpClient();
	    try {
	        HttpPost request = new HttpPost("https://mobiquity.qtestnet.com/api/v3/projects/"+projectId+"/test-runs/"+testRunId+"/auto-test-logs");
	        Gson gsonObject = new Gson();
	        String jsonString = gsonObject.toJson(qTest);
	        request.setEntity(new StringEntity(jsonString));
	        request.addHeader("content-type", "application/json");
	        request.addHeader("Authorization", "bW9iaXF1aXR5fHBwYXJpa2hAbW9iaXF1aXR5aW5jLmNvbToxNDQ1NDA1NzM2NzAzOjhiNDI5ODRmMWFmNDg5MDZmMjQ5OGI1NzhhZGEyNTY5");
	        HttpResponse response = httpClient.execute(request);
	        if(response.getStatusLine().getStatusCode() == 201){
	        	return Boolean.TRUE;
	        }else{
	        	return Boolean.FALSE;
	        }
	    }catch (Exception e) {
	    	e.printStackTrace();
	    	return Boolean.FALSE;
	    } finally {
	        httpClient.getConnectionManager().shutdown();
	    }
	}
	
	public static void main(String args[]){
	
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		System.out.println(sdf.format(c1.getTime()));
		}
	
	public boolean processData(Date startDate,Date endDate,String status,String testCaseID,String errorLogs){
		// Now Update Result
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Qtest qTest = new Qtest();
       // qTest.setname("TC-Add a Comment to Event");
        //qTest.setautomation_content(errorLogs);
        qTest.setStatus(status);
        qTest.setNote(errorLogs);
		qTest.setexe_start_date(sdf.format(startDate.getTime()));
		qTest.setexe_end_date(sdf.format(endDate.getTime()));
		try{
			if(Connect.autoTestLogs("6378", testCaseID, qTest)){
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}catch(Exception e){
			System.err.println("Error Occured while Communication ::: "+e.getMessage());
			return Boolean.FALSE;
		}
	}
	
	public void scrollData(WebDriver driver,Double startX,Double startY,Double endX,Double endY)			//Function for page scroll
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		swipeObject.put("startX", startX);
		swipeObject.put("startY", startY);
		swipeObject.put("endX", endX);
		swipeObject.put("endY", endY);
		swipeObject.put("duration", 2.0);
		js.executeScript("mobile: swipe", swipeObject);
	}
	
	public void tapData(WebDriver driver,Integer Xcoordinate, Integer Ycoordinnate)				// Function for tap using co-ordinates
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		HashMap<String, Integer> tapObject = new HashMap<String, Integer>();
        tapObject.put("Xcoordinate", Xcoordinate); // in pixels from left
        tapObject.put("Ycoordinnate", Ycoordinnate); // in pixels from top
        js.executeScript("mobile: tap", tapObject);
	}
}