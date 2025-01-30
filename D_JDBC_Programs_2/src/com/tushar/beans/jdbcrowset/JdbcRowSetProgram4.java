package com.tushar.beans.jdbcrowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetProgram4 {
	public static void main(String[] args) {
		try {
			/*
			  Similarity between ResultSet and JdbcRowSet
			  1.Both are not serializable
			  2.Both are connected to database
			  
			  Difference between ResultSet and JdbcRowSet
			  1.Moves cursor in forward direction only in ResultSet but in JdbcRowSet it is scrollable cursor moves in
			  any direction or jumps to specific location as well.
			  2.ResultSet is Read Onlu where as JdbcRowSet is Updatable.
			  
			*/
			
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			JdbcRowSet jdbcRowSet = rowSetFactory.createJdbcRowSet();
			jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/JDBCDB");
			jdbcRowSet.setUsername("root");
			jdbcRowSet.setPassword("root");
			jdbcRowSet.setCommand("select * from employee");
			jdbcRowSet.execute();
			
			while(jdbcRowSet.next()) {
				double salary = jdbcRowSet.getDouble(4);
				if(salary > 3000) {
					jdbcRowSet.deleteRow();
				}
			}
			System.out.println("Record deleted successfully.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
