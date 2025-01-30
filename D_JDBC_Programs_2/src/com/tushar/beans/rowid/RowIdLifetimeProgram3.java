package com.tushar.beans.rowid;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class RowIdLifetimeProgram3 {
	/*
	  RowId Lifetime.
	  There are 4 types of RowId Lifetime
	  It is an enum present in java.sql.* package.
	  1.ROWID_UNSUPPORTED
	  2.ROWID_VALID_FOREVER
	  3.ROWID_VALID_SESSION
	  4.ROWID_VALID_TRANSACTION
	  
	  Only Oracle supports the RowId concept but MySQL not supports.
	  
	  To check whether database supports or not we have the following program.
	*/
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
        	DatabaseMetaData databaseMetaData = connection.getMetaData();
        	System.out.println(databaseMetaData.getRowIdLifetime());
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
