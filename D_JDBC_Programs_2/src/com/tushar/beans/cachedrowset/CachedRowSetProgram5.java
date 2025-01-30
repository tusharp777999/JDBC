package com.tushar.beans.cachedrowset;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetProgram5 {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/JDBCDB";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            // Disable auto-commit on the connection
            connection.setAutoCommit(false);

            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();

            // Set connection details on CachedRowSet
            cachedRowSet.setCommand("SELECT * FROM employee");
            cachedRowSet.execute(connection);
            
            while (cachedRowSet.next()) {
                double salary = cachedRowSet.getDouble(4);
                if(salary > 3500) {
                	cachedRowSet.deleteRow();
                }
            }
            cachedRowSet.moveToCurrentRow();

            // Commit changes using the same connection
            cachedRowSet.acceptChanges(connection);

            System.out.println("Records deleted successfully!");
            cachedRowSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
