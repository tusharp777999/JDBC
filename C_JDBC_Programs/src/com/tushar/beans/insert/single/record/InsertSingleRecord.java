package com.tushar.beans.insert.single.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertSingleRecord {
	public static void main(String[] args) {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")){
			Statement statement = connection.createStatement();
			int count = statement.executeUpdate("insert into employee values(4, 'Jone', 'Physics')");
			System.out.println(count + " row inserted.");
			//In JDBC the auto commit is by default is on but if you do the same thing from the workbench of database then there auto commit is off by default
			//In JDBC we can disable the auto commit by using the connection.setAutoCommit(false); and also do the manual commit connection.commit(). 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
