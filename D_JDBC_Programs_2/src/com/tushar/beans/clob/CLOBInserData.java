package com.tushar.beans.clob;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CLOBInserData { //Similar to the CLOB MySQL having TEXT type.
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			String sqlQuery = "insert into resumes values(?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setString(1, "Tushar");
			
			File file = new File("/Users/tushar/JDBC/D_JDBC_Programs_2/src/com/tushar/beans/clob/resume.rtf");
			FileReader fileReader = new FileReader(file);
			preparedStatement.setCharacterStream(2, fileReader);
			
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
