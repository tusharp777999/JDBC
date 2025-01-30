package com.tushar.beans.webrowset;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class WebRowSetProgram5 {
	public static void main(String[] args) {
		try {	
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			FilteredRowSet filteredRowSet = rowSetFactory.createFilteredRowSet();
			filteredRowSet.setUrl("jdbc:mysql://localhost:3306/JDBCDB");
			filteredRowSet.setUsername("root");
			filteredRowSet.setPassword("root");
			filteredRowSet.setCommand("select * from employee");
			filteredRowSet.execute();
			
			System.out.println("Data before filtering: ");
			while(filteredRowSet.next()) {
				System.out.println(filteredRowSet.getInt(1) + "\t" + filteredRowSet.getString(2) + "\t" + filteredRowSet.getString(3) + "\t" + filteredRowSet.getDouble(4));
			}
			
			EmployeeSalaryFilter employeeSalaryFilter = new EmployeeSalaryFilter(2000, 3000);
			filteredRowSet.setFilter(employeeSalaryFilter);
			filteredRowSet.beforeFirst();
			
			System.out.println("Data after filtering: ");
			while(filteredRowSet.next()) {
				System.out.println(filteredRowSet.getInt(1) + "\t" + filteredRowSet.getString(2) + "\t" + filteredRowSet.getString(3) + "\t" + filteredRowSet.getDouble(4));
			}
			
			filteredRowSet.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
