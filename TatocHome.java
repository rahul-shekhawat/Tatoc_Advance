package com.qait.automation.TatocAdvance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class TatocHome {
	
	WebDriver driver;
	public TatocHome(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verifyworkingofhomepage()
	{
		driver.findElement(By.linkText("Advanced Course")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://10.0.1.86/tatoc/advanced/hover/menu");
	}
}
