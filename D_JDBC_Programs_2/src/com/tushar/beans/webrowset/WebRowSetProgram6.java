package com.tushar.beans.webrowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class WebRowSetProgram6 {
	public static void main(String[] args) {
		try {	
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			JdbcRowSet jdbcRowSet = rowSetFactory.createJdbcRowSet();
			jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/JDBCDB");
			jdbcRowSet.setUsername("root");
			jdbcRowSet.setPassword("root");
			jdbcRowSet.setCommand("select * from student");
			jdbcRowSet.addRowSetListener(new RowSetListenerImpl());
			jdbcRowSet.execute();
			
			System.out.println("Student List in forward direction: ");
			while(jdbcRowSet.next()) {
				System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString(2) + "\t" + jdbcRowSet.getString(3));
			}
			jdbcRowSet.moveToInsertRow();
			jdbcRowSet.updateInt(1, 13);
			jdbcRowSet.updateString(2, "Santa");
			jdbcRowSet.updateString(3, "Maths");
			jdbcRowSet.insertRow();
			jdbcRowSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}