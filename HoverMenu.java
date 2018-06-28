package com.qait.automation.TatocAdvance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HoverMenu {
	
	WebDriver driver;
	
	public HoverMenu(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void HoverMenu2nAttemptClickOnGoNext()
	{	
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[5]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/advanced/query/gate");
	}

}
