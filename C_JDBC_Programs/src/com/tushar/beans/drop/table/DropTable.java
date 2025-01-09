package com.tushar.beans.drop.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DropTable {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("drop table student");
			System.out.println("Table dropped.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
