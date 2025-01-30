package com.tushar.beans.blob;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BLOBInserData {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			String sqlQuery = "insert into persons values(?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setString(1, "Tushar");
			
			File file = new File("/Users/tushar/JDBC/D_JDBC_Programs_2/src/com/tushar/beans/blob/cat.jpeg");
			FileInputStream fileInputStream = new FileInputStream(file);
			preparedStatement.setBinaryStream(2, fileInputStream);
			
			int insertedRecords = preparedStatement.executeUpdate();
			
			if(insertedRecords > 0)
				System.out.println("Record inserted.");
			else
				System.out.println("Record not inserted.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
