package com.tushar.beans.jdbcrowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetProgram1 {
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
			jdbcRowSet.setCommand("select * from student");
			jdbcRowSet.execute();
			
			System.out.println("Student List in forward direction: ");
			while(jdbcRowSet.next()) {
				System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString(2) + "\t" + jdbcRowSet.getString(3));
			}
			
			System.out.println();
			
			System.out.println("Student List in reverse direction: ");
			while(jdbcRowSet.previous()) {
				System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString(2) + "\t" + jdbcRowSet.getString(3));
			}
			
			System.out.println();
			
			System.out.println("Student List access randomly: ");
			jdbcRowSet.absolute(3);
			System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString(2) + "\t" + jdbcRowSet.getString(3));
			
			System.out.println();
			
			System.out.println("Student first record: ");
			jdbcRowSet.first();
			System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString(2) + "\t" + jdbcRowSet.getString(3));
		
			System.out.println();
			
			System.out.println("Student lase record: ");
			jdbcRowSet.last();
			System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString(2) + "\t" + jdbcRowSet.getString(3));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
