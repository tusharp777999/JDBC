package com.tushar.beans.jdbcrowset;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class RowSetProgram {
	public static void main(String[] args) {
		try {
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			
			JdbcRowSet jdbcRowSet = rowSetFactory.createJdbcRowSet();
			System.out.println("Jdbc Row Set: " + jdbcRowSet.getClass().getName());
			
			CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
			System.out.println("Cached Row Set: " + cachedRowSet.getClass().getName());
			
			WebRowSet webRowSet = rowSetFactory.createWebRowSet();
			System.out.println("Web Row Set: " + webRowSet.getClass().getName());
			
			JoinRowSet joinRowSet = rowSetFactory.createJoinRowSet();
			System.out.println("Join Row Set: " + joinRowSet.getClass().getName());
			
			FilteredRowSet filteredRowSet = rowSetFactory.createFilteredRowSet();
			System.out.println("Filtered Row Set: " + filteredRowSet.getClass().getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
