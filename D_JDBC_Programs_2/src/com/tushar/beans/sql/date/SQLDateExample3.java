package com.tushar.beans.sql.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class SQLDateExample3 {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			String sqlQuery = "select * from people";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();

			//while (resultSet.next()) {
			//	System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getDate(3));
			//}
			
			//Note: ResultSet only works in forward direction once its iterates the cursor goes After Last Record and initially it was Before First Record .
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t"
						+ simpleDateFormat.format(resultSet.getDate(3)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
