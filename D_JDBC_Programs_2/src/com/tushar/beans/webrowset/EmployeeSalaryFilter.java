package com.tushar.beans.webrowset;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;

public class EmployeeSalaryFilter implements Predicate {

	double low;
	
	double high;
	
	public EmployeeSalaryFilter(double low, double high) {
		this.low = low;
		this.high = high;
	}
	
	@Override
	public boolean evaluate(RowSet rs) {
		boolean evaluate = false;
		try {
			FilteredRowSet filteredRowSet = (FilteredRowSet) rs;
			double salary = filteredRowSet.getDouble(4);
			if(salary > low && salary < high) {
				evaluate = true;
			} else {
				evaluate = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return evaluate;
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		return false;
	}

}
