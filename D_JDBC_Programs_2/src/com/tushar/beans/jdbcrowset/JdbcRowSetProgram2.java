package com.tushar.beans.jdbcrowset;

import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetProgram2 {
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
			
			Scanner scanner = new Scanner(System.in);
			jdbcRowSet.moveToInsertRow();
			
			while(true) {
				System.out.println("Enter id: ");
				int id = scanner.nextInt();
				
				System.out.println("Enter name: ");
				String name = scanner.next();
				
				System.out.println("Enter department: ");
				String department = scanner.next();
				
				jdbcRowSet.updateInt(1, id);
				jdbcRowSet.updateString(2, name);
				jdbcRowSet.updateString(3, department);
				jdbcRowSet.insertRow();
				
				System.out.println("Student record inserted successfully.");
				System.out.println("Do you want to continue to insert another record? [Yes|No]: ");
				String option = scanner.next();
				if(option.equalsIgnoreCase("No")) {
					break;
				}
			}
			scanner.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
