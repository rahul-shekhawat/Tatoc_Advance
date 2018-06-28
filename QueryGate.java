package com.qait.automation.TatocAdvance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;


public class QueryGate {
	
	WebDriver driver; 
	
	public QueryGate(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void gettingcorrectcredentialsfromdatabase() throws SQLException, ClassNotFoundException
	{	
		//ResultSet resultSet = null;
		Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.86/tatoc","tatocuser","tatoc01");
		Class.forName("com.mysql.jdbc.Driver");
		String query="select * from identity";
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		while (resultSet .next()) {
			System.out.println(resultSet .getString(1));
		}

		con.close();

	}

}
