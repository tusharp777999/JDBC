package com.tushar.beans.resultset.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetTypeProgram7 {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			/*
			 The updatable supported by only Type 1 and Type 2 Driver and the basic difference between this 2 drivers is that the Type 1 works with * in select
			 query where Type 2 driver needs column names in select query.
			 
			 1.We can do updation like insert, update and delete.
			 2.No need of SQL queries to update the data into the database.
			 3.Only Type 1 and Type 2 driver supports the updatable resultset.
			 4.If you are using Joins, Aggregate functions in a query updatable resultset won't work.
			*/
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = statement.executeQuery("select * from student");

			resultSet.moveToInsertRow();//Inserts the empty row at the last in result set.
			resultSet.updateInt(1, 1);
			resultSet.updateString(2, "Amol");
			resultSet.updateString(3, "CA");
			resultSet.insertRow();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
