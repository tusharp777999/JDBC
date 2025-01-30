package com.tushar.beans.cachedrowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetProgram3 {
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
            cachedRowSet.setCommand("SELECT * FROM student");
            cachedRowSet.execute(connection);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter id: ");
                int id = scanner.nextInt();

                System.out.println("Enter name: ");
                String name = scanner.next();

                System.out.println("Enter department: ");
                String department = scanner.next();

                cachedRowSet.moveToInsertRow();
                cachedRowSet.updateInt(1, id);
                cachedRowSet.updateString(2, name);
                cachedRowSet.updateString(3, department);
                cachedRowSet.insertRow();

                System.out.println("Student inserted successfully!");

                System.out.println("Do you want to insert one more student? [Yes|No]");
                String option = scanner.next();

                if (option.equalsIgnoreCase("No"))
                    break;
            }
            cachedRowSet.moveToCurrentRow();

            // Commit changes using the same connection
            cachedRowSet.acceptChanges(connection);

            System.out.println("All changes committed successfully!");
            cachedRowSet.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
