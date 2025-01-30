package com.tushar.beans.update.single.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateSingleRecord {
	public static void main(String[] args) {
		// Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			Statement statement = connection.createStatement();
			int count = statement.executeUpdate("update employee set name = 'Manyata' where id = 1");
			System.out.println(count + " row updated.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
