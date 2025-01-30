package com.tushar.beans.cachedrowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetProgram1 {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from student");
			
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
			cachedRowSet.populate(resultSet);
			connection.close();
			
			while(cachedRowSet.next()) {//CachedRowSet after closing the database connection.
				System.out.println(cachedRowSet.getInt(1) + "\t" + cachedRowSet.getString(2) + "\t" + cachedRowSet.getString(3));
			}
			
			while(resultSet.next()) {//ResultSet after closing the database connection.
				System.out.println(cachedRowSet.getInt(1) + "\t" + cachedRowSet.getString(2) + "\t" + cachedRowSet.getString(3));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
