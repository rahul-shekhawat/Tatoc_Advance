package com.qait.automation.TatocAdvance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Download {
	
	WebDriver driver;
	public Download(WebDriver driver)
	{
		this.driver=driver;
	}

	public void downloadnEnteringSig() throws IOException, InterruptedException
	{
		  driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		  Thread.sleep(2000);
		  File file = new File("/home/rahulsinghshekhawat/Downloads/file_handle_test.dat");
		  BufferedReader br = new BufferedReader(new FileReader(file));
		 
		  String st;
		  String data = "";
		  while ((st = br.readLine()) != null)
		  {
		    System.out.println(st);
		    data=data+st;
		    
		  }
		  
		  String ss[]=data.split("\\s+");
		  System.out.println(ss[4]);
		  driver.findElement(By.xpath("//*[@id='signature']")).sendKeys(ss[4]);
		  driver.findElement(By.xpath("/html/body/div/div[2]/form/input[2]")).click();
		  
	}
	
	
}
