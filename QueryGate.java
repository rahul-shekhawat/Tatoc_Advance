package com.qait.automation.TatocAdvance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;


public class QueryGate {
	
	WebDriver driver; 
	
	public QueryGate(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verifyingcorrectcredentials() throws SQLException, ClassNotFoundException
	{	
		String symbolname=driver.findElement(By.id("symboldisplay")).getAttribute("innerHTML");
		Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.86/tatoc","tatocuser","tatoc01");
		Class.forName("com.mysql.jdbc.Driver");
		
		String query="SELECT id FROM identity WHERE SYMBOL='"+symbolname+"'";
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		resultSet.next();
		String id=resultSet.getString(1);
		
		String query2="SELECT name,passkey FROM credentials WHERE id='"+id+"'";
		ResultSet resultSet2 = stmt.executeQuery(query2);
		resultSet2.next();
		String name=resultSet2.getString(1);
		String passkey=resultSet2.getString(2);
		
		con.close();
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("passkey")).sendKeys(passkey);
		driver.findElement(By.id("submit")).click();
		
		Assert.assertEquals("http://10.0.1.86/tatoc/advanced/video/player", driver.getCurrentUrl());
		
	}

}
