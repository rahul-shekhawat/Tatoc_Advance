package com.qait.automation.TatocAdvance;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Restful {
	
	private final String USER_AGENT = "Chrome/67.0.3396.87";
	public  WebDriver driver;
	public int id;

	
	public Restful(WebDriver driver)
	{
		this.driver=driver;
	}

	
	
	public String sendGET() throws IOException, InterruptedException
	{	
		driver.get("http://10.0.1.86/tatoc/advanced/rest");
		Thread.sleep(2000);
		String session=driver.findElement(By.id("session_id")).getAttribute("innerHTML");
		
		String []ssid=session.split("\\s+");
		id=Integer.parseInt(ssid[2]);
		String url = "http://10.0.1.86/tatoc/advanced/rest/service/token/"+id+"";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		
		
		in.close();

		JSONObject res=new JSONObject(response.toString());
		String token=(String) res.get("token");
		System.out.println(token);
		return token;
	}
	
	public void sendPOST(String token) throws IOException
	{	
		String ide=Integer.toString(id);
		System.out.println(token);
		String url = "http://10.0.1.86/tatoc/advanced/rest/service/register";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "id="+ide+"&signature="+token+"&allow_access=1";
		System.out.println(urlParameters);
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		
		int responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);
		wr.flush();
		wr.close();
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(),"http://10.0.1.86/tatoc/advanced/file/handle");
		
	}
	


}
