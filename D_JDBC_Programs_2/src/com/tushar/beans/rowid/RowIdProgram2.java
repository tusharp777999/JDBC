package com.tushar.beans.rowid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RowIdProgram2 {
	/*
	  Actually the MySQL does not supports the RowId concept as Oracle can. And below code not works because
	  every time the UUID() generates the unique value.
	*/
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student where UUID() = '80a666ce-de79-11ef-8c76-066e152168a4'");

            if (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("name") + "\t" + resultSet.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
