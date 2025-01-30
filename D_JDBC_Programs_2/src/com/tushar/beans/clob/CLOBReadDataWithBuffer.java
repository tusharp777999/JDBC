package com.tushar.beans.clob;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CLOBReadDataWithBuffer {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			String sqlQuery = "select * from resumes";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			FileWriter fileWriter = new FileWriter("/Users/tushar/JDBC/D_JDBC_Programs_2/src/com/tushar/beans/clob/resumeDB.rtf");
			

			if (resultSet.next()) {
				String name = resultSet.getString(1);
				Reader reader = resultSet.getCharacterStream(2);

				char[] buffer = new char[1024];

				while (reader.read(buffer) > 0) {
					fileWriter.write(buffer);
				}
			}
			fileWriter.flush();
			fileWriter.close();
			System.out.println("Open file to see the image.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
