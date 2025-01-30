package com.tushar.beans.cachedrowset;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetProgram2 {
	public static void main(String[] args) {
		try {
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
			cachedRowSet.setUrl("jdbc:mysql://localhost:3306/JDBCDB");
			cachedRowSet.setUsername("root");
			cachedRowSet.setPassword("root");
			cachedRowSet.setCommand("select * from student");
			cachedRowSet.execute();
			
			System.out.println("Result in forward direction: ");
			while(cachedRowSet.next()) {//CachedRowSet after closing the database connection.
				System.out.println(cachedRowSet.getInt(1) + "\t" + cachedRowSet.getString(2) + "\t" + cachedRowSet.getString(3));
			}
			
			System.out.println();
			
			System.out.println("Result in backword direction: ");
			while(cachedRowSet.previous()) {//ResultSet after closing the database connection.
				System.out.println(cachedRowSet.getInt(1) + "\t" + cachedRowSet.getString(2) + "\t" + cachedRowSet.getString(3));
			}
			
			System.out.println();
			
			System.out.println("Result from any position: ");
			cachedRowSet.absolute(3);
			System.out.println(cachedRowSet.getInt(1) + "\t" + cachedRowSet.getString(2) + "\t" + cachedRowSet.getString(3));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
