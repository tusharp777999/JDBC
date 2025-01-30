package com.tushar.beans.properties;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesProgramShortcut {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileInputStream fileInputStream = new FileInputStream(
					"/Users/tushar/JDBC/D_JDBC_Programs_2/src/com/tushar/beans/properties/jdbc2.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);

			//Note: Properties file should use the key as user and password not anything else its mandatory if you want
			//to pass properties object directly.
			//Two arguments getConnection() method.
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", properties);
			
			//One argument getConnection() method.
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB?user=root&password=root");
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employee");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)
						+ "\t" + resultSet.getDouble(4));
			}
			connection.close();
			fileInputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
