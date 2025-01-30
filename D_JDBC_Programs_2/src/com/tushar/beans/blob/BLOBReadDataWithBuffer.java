package com.tushar.beans.blob;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BLOBReadDataWithBuffer {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			String sqlQuery = "select * from persons";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			FileOutputStream fileOutputStream = new FileOutputStream(
					"/Users/tushar/JDBC/D_JDBC_Programs_2/src/com/tushar/beans/blob/catDB.jpeg");

			if (resultSet.next()) {
				String name = resultSet.getString(1);
				InputStream inputStream = resultSet.getBinaryStream(2);

				byte[] buffer = new byte[1024];

				while (inputStream.read(buffer) > 0) {
					fileOutputStream.write(buffer);
				}
			}
			fileOutputStream.flush();
			fileOutputStream.close();
			System.out.println("Open file to see the image.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
