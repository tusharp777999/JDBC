package com.tushar.beans.webrowset;

import java.io.FileWriter;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetProgram1 {
	public static void main(String[] args) {
		try {
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			WebRowSet webRowSet = rowSetFactory.createWebRowSet();
			webRowSet.setUrl("jdbc:mysql://localhost:3306/JDBCDB");
			webRowSet.setUsername("root");
			webRowSet.setPassword("root");
			webRowSet.setCommand("select * from employee");
			webRowSet.execute();
			
			FileWriter fileWriter = new FileWriter("/Users/tushar/JDBC/D_JDBC_Programs_2/src/com/tushar/beans/webrowset/databaseToEmployeeFile.xml");
			webRowSet.writeXml(fileWriter);
			System.out.println("Employee data published to xml file.");
			fileWriter.close();
			webRowSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
