package com.qait.automation.TatocAdvance;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAll {
	
	WebDriver driver;
	TatocHome home;
	HoverMenu menu;
	QueryGate gate;
	
	@Test(priority=0)
	public void clickingonAdvanceCoursewillgotonextpage()
	{
		home.verifyworkingofhomepage();
	}
	
	@Test(priority=1)
	public void clickOnGoNextwillRenderNextPage()
	{
		menu.HoverMenu2nAttemptClickOnGoNext();
	}
	
	@Test(priority=2)
	public void func() throws ClassNotFoundException, SQLException
	{
		gate.gettingcorrectcredentialsfromdatabase();
	}
	
	@BeforeClass
	public void launchwebsite()
	{    
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		home=new TatocHome(driver);
		menu=new HoverMenu(driver);
		gate=new QueryGate(driver);
	}
	
	@AfterClass
	public void closeWebsite() throws InterruptedException
	{   
		Thread.sleep(2000);
		driver.quit();
	}
}
