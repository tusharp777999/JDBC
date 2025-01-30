package com.tushar.beans.delete.single.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteSingleRecord {
	public static void main(String[] args) {
		// Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			Statement statement = connection.createStatement();
			int count = statement.executeUpdate("delete from employee where name = 'Kamlesh'");
			System.out.println(count + " row deleted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
