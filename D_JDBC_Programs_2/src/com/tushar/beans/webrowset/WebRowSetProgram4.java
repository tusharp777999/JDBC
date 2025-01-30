package com.tushar.beans.webrowset;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class WebRowSetProgram4 {
	public static void main(String[] args) {
		/*
		 Here the common column is considered as a single column so the total count of column will be
		 Example: Table A having 3 Columns and Table B having 2 Columns so the total columns will be 
		 3 + 2 = 5 total column and consider common column as 1 so 5 - 1 = 4 so there will be only 
		 4 columns.
		*/
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {	
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			CachedRowSet cachedRowSet1 = rowSetFactory.createCachedRowSet();
			cachedRowSet1.setCommand("select * from students");
			cachedRowSet1.execute(connection);
			
			CachedRowSet cachedRowSet2 = rowSetFactory.createCachedRowSet();
			cachedRowSet2.setCommand("select * from departments");
			cachedRowSet2.execute(connection);
			
			JoinRowSet joinRowSet = rowSetFactory.createJoinRowSet();
			joinRowSet.addRowSet(cachedRowSet1, 3);
			joinRowSet.addRowSet(cachedRowSet2, 1);
			
			FileWriter fileWriter = new FileWriter("/Users/tushar/JDBC/D_JDBC_Programs_2/src/com/tushar/beans/webrowset/joinRowSetData.xml");
			joinRowSet.writeXml(fileWriter);
			
			while(joinRowSet.previous()) {
				System.out.println(joinRowSet.getInt(1) + "\t" + joinRowSet.getString(2) + "\t" + joinRowSet.getInt(3) + "\t" + joinRowSet.getString(4));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
