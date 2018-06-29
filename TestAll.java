package com.qait.automation.TatocAdvance;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAll {
	
	WebDriver driver;
	TatocHome home;
	HoverMenu menu;
	QueryGate gate;
	Restful rest;
	Download down;
	
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
	public void enteringcorrectcredentialswillrendernextpage() throws ClassNotFoundException, SQLException
	{
		gate.gettingcorrectcredentialsfromdatabase();
	}
	
	@Test(priority=3)
	public void succregisterservicewilldisplaynextpage() throws IOException, InterruptedException
	{
		String token=rest.sendGET();
		rest.sendPOST(token);
		
	}
	
	@Test(priority=4)
	public void successfulsigsubmitwilldisplaynextpage() throws IOException, InterruptedException
	{
		down.downloadnEnteringSig();
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
		rest=new Restful(driver);
		down=new Download(driver);
	}
	
	@AfterClass
	public void closeWebsite() throws InterruptedException
	{   
		Thread.sleep(2000);
		driver.quit();
	}
	
	
}
