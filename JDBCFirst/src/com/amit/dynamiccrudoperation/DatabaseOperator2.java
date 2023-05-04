package com.amit.dynamiccrudoperation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseOperator2 {

	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/m11_e3";
			FileInputStream stream=new FileInputStream("mydbinfo.properties");
			Properties pro = new Properties();
			pro.load(stream);
			Connection con = DriverManager.getConnection(url, pro);
			Statement stm = con.createStatement();
			System.out.println("Enter the query");
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			String query=read.readLine();
			boolean res = stm.execute(query);
			if(res)
			{
				ResultSet set = stm.getResultSet();
				ResultSetMetaData metaData = set.getMetaData();
				int columnCount = metaData.getColumnCount();
				
				while(set.next())
				{
					for(int i=1;i<=columnCount;i++)
					{
						System.out.println(metaData.getColumnLabel(i)+" of the student is "+set.getObject(i));
					}
					System.out.println("--------------------------------");
				}
			}
			else
			{
				System.out.println("Table updated successfully");
			}
			con.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}

	}

}
